package com.pipe.iccraw.app;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 传入URL获取相应的网页document对象
 * @author viakiba
 *
 */
public class ReDocument {
	/**
	 * 尝试重连三次  三次失败返回  null
	 * @param url
	 * @return
	 */
	public static Document getDoc (String url){
		Document doc;
		
		Connection conn = Jsoup.connect(url);
		try {
			doc = conn.get();
		} catch (IOException e) {
			try {
				doc = conn.get();
			} catch (IOException e1) {
				try {
					doc = conn.get();
				} catch (IOException e2) {
					return null;
				}
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return doc;
	}
}
