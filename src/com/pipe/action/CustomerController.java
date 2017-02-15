package com.pipe.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.pipe.entity.CusExcDet;
import com.pipe.entity.Customer;
import com.pipe.entity.CustomerExcel;
import com.pipe.iccraw.app.PipeService;
import com.pipe.service.CustomerService;
import com.pipe.service.IcService;
import com.pipe.utils.AnalysisExcel;
import com.pipe.utils.SendMail;
import com.pipe.utils.SendMes;
import com.pipe.utils.Upload;
import com.pipe.vo.IcView;
import com.taobao.api.ApiException;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	@Resource
	private IcService icService;
	@RequestMapping("/uploadBom")
	public String uploadBom(@RequestParam("cus_bom") MultipartFile file,Customer customer,HttpServletRequest request,CustomerExcel customerExcel){
		Integer customerId = customerService.getCustomerId(customer);
		if(customerId==null){
			customerService.insertCustomer(customer);
			customerId = customerService.getCustomerId(customer);
		}
		customerExcel.setCustomer_id(customerId);
		long date=new Date().getTime();
		String path=null;
		try {
			path=Upload.uploadExcel(request,file, date);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<CusExcDet> cusExcDetList=null;
		try {
			cusExcDetList = AnalysisExcel.getContent(path);
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		final List<CusExcDet> cusExcDetList2=cusExcDetList;
		final List<String> modelList=new ArrayList<String>();
		for (CusExcDet cusExcDet : cusExcDetList) {
			modelList.add(cusExcDet.getRetrievalmodel());
		}
		customerExcel.setExcel_name(date+"_"+file.getOriginalFilename());
		System.out.println(JSON.toJSONString(cusExcDetList));
		final int cusExcelId = customerService.insertCusExcel(customerExcel, cusExcDetList);
		new Thread() {
            public void run() {
//            	List<Map> lm=new ArrayList<>();
            	List<IcView> icViewList= icService.getIcByModel(modelList);
            	System.out.println(icViewList.size());
            	if(icViewList.size()<modelList.size()*30){
//            		PipeService.getIcBusin(modelList.get(0));
//            		PipeService.getIcBusin(modelList.get(1));
//            		PipeService.getIcBusin(modelList.get(2));
            		for (String model : modelList) {
            			PipeService.getIcBusin(model);
            		}
            		icViewList=icService.getIcByModel(modelList);
            	}
            	int i=0;
            	List<Map> lsh=new ArrayList<Map>();
            	for (IcView icView : icViewList) {
        			i++;
        			int j=0;
        			for(CusExcDet cusExcDet : cusExcDetList2){
        				if(icView.getRetrievalmodel().equals(cusExcDet.getRetrievalmodel())){
        					break;
        				}
        				j++;
        			}
        			SendMail.sendMailSSL(icView.getIcqq()+"@qq.com",icView.getBusinname(),icView.getRetrievalmodel(),cusExcDetList2.get(j).getQuantity()+"",
        					"http://wechat.xdailiao.com/pipe/supplier/showCusExcDet.do?excel_id="+cusExcelId+"&email="+icView.getIcqq()+"@qq.com&uuid="+icView.getUuid()+"&oldname="+icView.getBusinname());
        			try {
        				System.out.println(i+"....."+icView.getMobnum());
						SendMes.sendMesUtil(icView.getMobnum(), modelList.get(0),cusExcDetList2.get(j).getQuantity()+"", icView.getIcqq()+"@qq.com");
					} catch (ApiException e) {
						e.printStackTrace();
					}
//        			if(i%30==0){
//        				SendMail.sendMailSSL("1139800505@qq.com",icView.getBusinname(),icView.getRetrievalmodel(),cusExcDetList2.get(j).getQuantity()+"",
//        						"http://wechat.xdailiao.com/pipe/supplier/showCusExcDet.do?excel_id="+cusExcelId+"&email="+icView.getIcqq()+"@qq.com&uuid=tulv&oldname="+icView.getBusinname());
//        				try {
//							SendMes.sendMesUtil("15826813513", icView.getRetrievalmodel(),cusExcDetList2.get(j).getQuantity()+"", icView.getIcqq()+"@qq.com");
//						} catch (ApiException e) {
//							e.printStackTrace();
//						}
//        			}
        			Map send=new HashMap();
        			send.put("cus_excel_id",cusExcelId );
        			send.put("uuid", icView.getUuid());
        			lsh.add(send);
        			if(i==100){
        				break;
        			}
        		}
            	customerService.insertSend(lsh);
            }    
        }.start();
		return "confirmSend";
	}
	
	@RequestMapping("/getAllCusExcel")
	public String getAllCusExcel(HttpServletRequest request){
		String currentPage=request.getParameter("currentPage");
		Map map = customerService.getAllCusExcel(currentPage);
		request.setAttribute("cusExcList",map.get("cusExcList"));
		request.setAttribute("pager",map.get("pager"));
		return "cus_bom_list";
	}
	
	@RequestMapping("/getViewHistory")
	public String getViewHistory(HttpServletRequest request){
		String currentPage=request.getParameter("currentPage");
		Map map = icService.getViewHistory(currentPage);
		request.setAttribute("viewHistoryList",map.get("viewHistoryList"));
		request.setAttribute("pager",map.get("pager"));
		return "view_history";
	}
	@RequestMapping("/getSendHistory")
	public String getSendHistory(HttpServletRequest request){
		String currentPage=request.getParameter("currentPage");
		Map map = icService.getSendHistory(currentPage);
		request.setAttribute("sendHistoryList",map.get("sendHistoryList"));
		request.setAttribute("pager",map.get("pager"));
		return "send_history";
	}
}
