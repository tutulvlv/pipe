package com.pipe.iccraw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pipe.iccraw.util.DBCon;

public class GetKey {
	public static String getManufacturekey() throws ClassNotFoundException, SQLException{
		String manufacturekey = null;
		Connection con =DBCon.getDBCon();
		String sql = " SELECT manufacturerkey FROM digidet where statusic = 0 LIMIT 0,1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		manufacturekey = rs.getString("manufacturerkey");
		return manufacturekey;
	}
	
	
}
