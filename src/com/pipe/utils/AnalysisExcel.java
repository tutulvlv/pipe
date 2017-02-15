package com.pipe.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pipe.entity.CusExcDet;

/**
	     		xssfWorkbook = new XSSFWorkbook(f2);//2007+
				sheetName = xssfWorkbook.getSheetName(0);
				System.out.println(sheetName+"===================");
				System.out.println("======================分隔符======================");
				hssfWorkbook = new HSSFWorkbook(f2);//2007+
				String shName = hssfWorkbook.getSheetName(0);
				System.out.println(shName+">>>>>>>>>>>>>>>>>>>");
 */
/**
 * 解析程序   先默认  第一栏型号   第二栏 数量
 * @author viakiba
 *
 */
public class AnalysisExcel {
	
	public static List<CusExcDet> getContent(String path) throws InvalidFormatException, IOException{
		List<CusExcDet> list = new ArrayList<CusExcDet>();
		
	    FileInputStream f1 = new FileInputStream(new File(path));
	    Workbook create = create(f1);
	    String s = create.getSheetName(0);
	    //从第一行开始
	    Sheet sheet = create.getSheetAt(0);//获取sheet   0===》实际的第一个sheet
	    int rownum = sheet.getLastRowNum(); 
	    System.out.println(rownum+"<<<===excel总行数");
	    for(int i=1; i<=rownum;i++){
	    	Row row = sheet.getRow(i);
	    	if(row!=null){
//	    		int colnum = row.getLastCellNum();
	    		Cell name_cell = row.getCell(1);
                String name = name_cell.getStringCellValue();
                Cell retrievalmodel_cell = row.getCell(2);
	            String retrievalmodel=null;
				try {
					retrievalmodel = retrievalmodel_cell.getStringCellValue();
				} catch (Exception e) {
					retrievalmodel = retrievalmodel_cell.getNumericCellValue()+"";
				}
                Cell factory_cell = row.getCell(3);
                String factory=null;
                if(factory_cell!=null){
                	factory = factory_cell.getStringCellValue();
                }
	            
	            Cell quantity_cell = row.getCell(4);
	            double quantity = 0;
	            if(quantity_cell!=null){
	            	quantity = quantity_cell.getNumericCellValue();
	            }
	            
	            Cell batch_cell = row.getCell(5);
	            String batch=null;
	            if(batch_cell!=null){
	            	batch = batch_cell.getStringCellValue();
	            }
	            
	            CusExcDet ab = new CusExcDet();
	            ab.setIc_name(name);
	            ab.setFactory(factory);
	            ab.setRetrievalmodel(retrievalmodel);
	            ab.setQuantity((int)quantity);
	            ab.setBatch(batch);
	            list.add(ab);
	    	}
	    }
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Workbook create(InputStream in) throws IOException,InvalidFormatException {
        if (!in.markSupported()) {//测试此输入流是否支持
            in = new PushbackInputStream(in, 8);//测试此输入流是否支持
        }
        if (POIFSFileSystem.hasPOIFSHeader(in)) {
            return new HSSFWorkbook(in);
        }
        if (POIXMLDocument.hasOOXMLHeader(in)) {
            return new XSSFWorkbook(OPCPackage.open(in));
        }
        throw new IllegalArgumentException("你的excel版本目前poi解析不了");
    }
	
	public static void main(String[] args) throws Exception {
		
	}

}
