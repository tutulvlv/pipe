package com.pipe.iccraw.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.jsoup.nodes.Document;


import com.pipe.iccraw.dao.GetKey;
import com.pipe.iccraw.dao.SetBusin;
import com.pipe.iccraw.entity.Business;

public class test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		UUID id = UUID.randomUUID();
		String str = id.toString().replace("-", "");
		System.out.println(str);
		
		String manufacturekey = GetKey.getManufacturekey();
		Document doc = ReDocument.getDoc("http://www.ic.net.cn/search.php?IC_Method=icsearch&key="+"MAX3232C");
		List<Business> busin = GetIcDetail.getBusiness(doc);
		if(busin.size() > 0){
			for(int i=0;i<busin.size();i++){
				String status = SetBusin.setBusin(busin.get(i), manufacturekey);
				System.out.println(status+manufacturekey);
			}
		}
		System.out.println(busin.toString());
		
	}



}
