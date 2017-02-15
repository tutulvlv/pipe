package com.pipe.iccraw.app;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pipe.iccraw.entity.Business;
import com.pipe.iccraw.entity.Contacts;
import com.pipe.iccraw.entity.Qq;

/**
 * 型号检索页   分析方案如下  ic.net.cn
 * @author viakiba
 *
 */

public class GetIcDetail {
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	public static List<Business> getBusiness(Document doc) {
		int page = 1;
		
		Element count = null;
		
		try{
		count = doc.getElementById("icCount");
		}catch(NullPointerException e){
			return null;
		}
		
		if(count != null){
			int s = Integer.parseInt(count.text());
			int mod = s % 50;
			page = s/50;
			if(mod>0){
				page = page+1;
			}
		}
		
		List<Business> list = new ArrayList<Business>();
		Elements businesses = doc.getElementsByClass("stair_tr");
		for(int m=1;m<businesses.size();m++){
			Business business = new Business();
			//获取公司名称 
			Elements nameComp = businesses.get(m).getElementsByClass("layer_companyName");
			String Businname = nameComp.text();
			business.setBusinname(Businname);//名字
			
			//商家标识   result_icons
			Elements icons = businesses.get(m).getElementsByClass("result_icons");
			Elements icon = icons.get(0).select("a[href]");
			//得到公司标识  
			String memberlevel = icon.attr("class");
			business.setMemberlevel(memberlevel);//等级
			
			//获取电话  以及    联系人  layer_contacts
			Elements contacts = businesses.get(m).getElementsByClass("layer_contacts");
			List<Contacts> list_contact = new ArrayList<Contacts>();
			if(contacts != null){
				for(int i=0;i<contacts.size();i++){
					Contacts con = new Contacts();
					Elements telph = contacts.get(i).getElementsByClass("layer_telNumber");
					Elements name = contacts.get(i).getElementsByClass("layer_contactName");
					if(name.size() == 0){
						System.out.println("姓名为空");
					}
					
					con.setName(telph.get(0).text());
					con.setTelPhone(name.get(0).text());
					
					list_contact.add(con);
				}
			}
			business.setContacts(list_contact);
			//获取手机号
			Elements mobleph = businesses.get(m).getElementsByClass("layer_otherContentphone");
			business.setMobnum(mobleph.get(0).text());
			//获取地址
			Elements company_address = businesses.get(m).getElementsByClass("company_address2");
			String address = company_address.get(0).text();
			business.setAddress(address);
			//获取会员年限
			Elements orangenumber = businesses.get(m).getElementsByClass("orangenumber");
			String memberyears = orangenumber.get(0).text();
			business.setMemberyears(memberyears);
			//获取型号  product_number
			Elements product_number = businesses.get(m).getElementsByClass("product_number");
			String retrievalmodel = product_number.get(0).text();
			business.setRetrievalmodel(retrievalmodel);
			
			//拿到厂家   result_factory
			String factory = businesses.get(m).getElementsByClass("result_factory").text();
			business.setFactory(factory);
			
			//获取qq 数据
			Elements qq_table = businesses.get(m).getElementsByClass("result_askPrice");
			Elements qq_list = qq_table.get(0).select("a[href]");
			List<Qq> list_qq = new ArrayList<Qq>();
			int k=qq_list.size();
			String qq1 = null;
			String qq2 = null;
			if(k == 1){
				Qq qq = new Qq();
				qq1 = qq_list.attr("title");
				qq.setQqnum(qq1);
				list_qq.add(qq);
			}
			if(k == 2){
				Qq qq_1 = new Qq();
				Qq qq_2 = new Qq();
				qq1 = qq_list.get(0).attr("title");
				qq2 = qq_list.get(1).attr("title");
				
				qq_1.setQqnum(qq1);
				qq_2.setQqnum(qq2);
				list_qq.add(qq_1);
				list_qq.add(qq_2);
			}
			business.setQq(list_qq);
			business.setPagesize(String.valueOf(page));
			list.add(business);
		}
		return list;
	}
}

