package com.pipe.iccraw.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.jsoup.nodes.Document;

import com.pipe.iccraw.dao.GetKey;
import com.pipe.iccraw.dao.SetBusin;
import com.pipe.iccraw.entity.Business;
import com.pipe.iccraw.util.DBCon;

public class TaskThreadHelp extends TimerTask{

	@Override
	public void run() {
		try {
			Date date = new Date();
			SimpleDateFormat sip = new SimpleDateFormat("MM-dd-hh-mm");
			String format = sip.format(date);
			System.out.println("时间："+format);
			
			String key = GetKey.getManufacturekey();
			System.out.println(key);
			String url1 = "http://www.ic.net.cn/search.php?IC_Method=icsearch&key="+ key;
			Document doc = ReDocument.getDoc(url1);
			List<Business> busin = GetIcDetail.getBusiness(doc);
			System.out.println("*******************************");
			if(busin != null){
				if(busin.size() > 0){
					for(int i=0;i<busin.size();i++){
						String status = SetBusin.setBusin(busin.get(i), key);
						System.out.println("结束插入"+key+status);
					}
					System.out.println("结束插入");
				  }
			}
			String sql = " update digidet set statusic= ? where manufacturerkey= ? ";//更新digidet的状态  statusic！=0
			Connection con =DBCon.getDBCon();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "1");
			pstmt.setString(2, key);
			pstmt.executeUpdate();
			con.commit();
			System.out.println(key+">>>>>>>>>>>>>>>>>>success  结束此型号");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(">>>>>>>>>>>>>>>>>>fail<<<<<<<<<<<<<<<<<<<");
			e.printStackTrace();
		}
	}

}
