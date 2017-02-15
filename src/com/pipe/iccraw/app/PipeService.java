package com.pipe.iccraw.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;

import com.pipe.iccraw.dao.SetBusin;
import com.pipe.iccraw.entity.Business;
import com.pipe.iccraw.util.DBCon;

public class PipeService {
	
	public static int getIcBusin(String key){
		String url1 = "http://www.ic.net.cn/search.php?IC_Method=icsearch&key="+ key;
		Document doc = ReDocument.getDoc(url1);
		List<Business> busin = GetIcDetail.getBusiness(doc);
		System.out.println("*******************************");
		if(busin != null){
			if(busin.size() > 0){
				for(int i=0;i<busin.size();i++){
					String status = null;
					try {
						status = SetBusin.setBusin(busin.get(i), key);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("结束插入"+key+status);
				}
				System.out.println("结束插入");
			  }
		}
		String sql = " update digidet set statusic= ? where manufacturerkey= ? ";//更新digidet的状态  statusic！=0
		try {
			Connection con = DBCon.getDBCon();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "1");
			pstmt.setString(2, key);
			pstmt.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(key+">>>>>>>>>>>>>>>>>>success  结束此型号");
		
		return 1;
	}
}
