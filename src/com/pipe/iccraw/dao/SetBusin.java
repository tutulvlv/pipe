package com.pipe.iccraw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.pipe.iccraw.entity.Business;
import com.pipe.iccraw.entity.Contacts;
import com.pipe.iccraw.entity.Qq;
import com.pipe.iccraw.util.DBCon;

public class SetBusin {

	
	public static String setBusin(Business bus,String key) throws ClassNotFoundException, SQLException{
		String sql1 = " insert into ic ( uuid, Businname, memberlevel, retrievalmodel, Memberyears, mobnum, address , pagesize ,factory) values ( ?, ?, ?, ?, ?, ?, ? , ? ,?) " ;//插入公司信息  信息表
		String sql2 = " insert into icnum ( uuid, conname, connum ) values ( ?, ?, ? ) ";//插入公司的联系电话        联系人表
		String sql3 = " insert into icqq ( uuid, qq) values ( ?, ? ) ";//插入公司的qq      qq表
		String sql4 = " update digidet set statusic= ? where manufacturerkey= ? ";//更新digidet的状态  statusic！=0
		//System.out.println(key+"=======================");
		Connection con = DBCon.getDBCon();
		con.setAutoCommit(false);
		PreparedStatement pstmt1 = con.prepareStatement(sql1);
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		PreparedStatement pstmt4 = con.prepareStatement(sql4);
		
		UUID uid = UUID.randomUUID();
		String id = uid.toString().replace("-", "");//关联
		//System.out.println(id);
		
		pstmt1.setString(1, id);
		pstmt1.setString(2, bus.getBusinname());
		//System.out.println(bus.getBusinname());
		pstmt1.setString(3, bus.getMemberlevel());
		pstmt1.setString(4, bus.getRetrievalmodel());
		pstmt1.setString(5, bus.getMemberyears());
		pstmt1.setString(6, bus.getMobnum());
		pstmt1.setString(7, bus.getAddress());
		pstmt1.setString(8, bus.getPagesize());
		pstmt1.setString(9, bus.getFactory());
		pstmt1.executeUpdate();
		pstmt1.close();
		con.commit();
		
		List<Contacts> connum = bus.getContacts();
		if(connum.size() > 0){
			for(int i=0; i<connum.size() ;i++){
				pstmt2.setString(1, id);
				pstmt2.setString(2, connum.get(i).getTelPhone());
				pstmt2.setString(3, connum.get(i).getName());
				pstmt2.executeUpdate();
				con.commit();
			}
		}
		pstmt2.close();
		
		List<Qq> qq = bus.getQq();
		if(qq.size()>0){
			for(int i=0;i<qq.size();i++){
				pstmt3.setString(1, id);
				pstmt3.setString(2, qq.get(i).getQqnum());
				pstmt3.executeUpdate();
				con.commit();
			}
		}
		pstmt3.close();
		
		pstmt4.setString(1, "1");
		pstmt4.setString(2, key);
		pstmt4.executeUpdate();
		con.commit();
		pstmt4.close();
		
		con.close();
		return "success";
	}
}
