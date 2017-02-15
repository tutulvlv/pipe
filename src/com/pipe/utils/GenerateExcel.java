package com.pipe.utils;

import java.io.File;
import java.io.FileOutputStream;

import com.pipe.entity.SupExcDet;

import java.util.*;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateExcel {
    
    
    public static String createExcelFile(List<SupExcDet> contents,String name) {
    	
    	String excelPath="D:\\excel\\download\\";
    	File temp = new File(excelPath);
        System.out.println("创建的路径"+temp.getAbsolutePath());
        if(!temp.exists() && !temp.isDirectory()){
        	try{
        		temp.mkdir();
        	}catch(Exception e){
        		e.printStackTrace();
        		System.out.println("文件夹创建出现异常");
        	}
        }
        
        String excel_name = name+".xlsx";
        excelPath = excelPath+"\\"+excel_name;
        System.out.println(excelPath+"####################");
    	String[] columnNames = {"品牌","型号","数量","批次","价格"};
        boolean isCreateSuccess = false;
        Workbook workbook = null;
        try {
            // XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
        	workbook = new XSSFWorkbook();//
        }catch(Exception e) {
            System.out.println("It cause Error on CREATING excel workbook: ");
            e.printStackTrace();
        }
        
        if(workbook != null) {
            Sheet sheet = workbook.createSheet("testdata");
            Row row0 = sheet.createRow(0);
            for(int i = 0; i < 5; i++) {
                Cell cell_1 = row0.createCell(i, Cell.CELL_TYPE_STRING);
                CellStyle style = getStyle(workbook);
                cell_1.setCellStyle(style);
                cell_1.setCellValue(columnNames[i]);
                sheet.autoSizeColumn(i);
            }
            
            for (int rowNum = 1; rowNum <= contents.size(); rowNum++) {
            	SupExcDet d = contents.get(rowNum-1);           	
                Row row = sheet.createRow(rowNum);
                for(int i = 0; i < 5; i++) {              	
                if(i==0){
                	Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                	cell.setCellValue(d.getFactory());
                }else if(i==1){
                	Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                	cell.setCellValue(d.getRetrievalmodel());
                }else if(i==2){
                	Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                	Integer quantity = d.getQuantity();
                	if(quantity==null){
                		cell.setCellValue("");
                	}else{
                		cell.setCellValue(quantity);
                	}
                }else if(i==3){
                	Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                	cell.setCellValue(d.getBatch());
                }else if(i==4){
                	Cell cell = row.createCell(i, Cell.CELL_TYPE_NUMERIC);
                	Double price = d.getPrice();
                	if(price==null){
                		cell.setCellValue("");
                	}else{
                		cell.setCellValue(price);
                	}
                }
                }               
            }
            
            try {
                FileOutputStream outputStream = new FileOutputStream(excelPath);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
                isCreateSuccess = true;
            } catch (Exception e) {
                System.out.println("It cause Error on WRITTING excel workbook: ");
                e.printStackTrace();
            }
        }
        File sss = new File(excelPath);
        System.out.println(sss.getAbsolutePath());
        return excel_name;
    }
    
    private static CellStyle getStyle(Workbook workbook){
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER); 
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short)14);
        headerFont.setColor(HSSFColor.RED.index);
        headerFont.setFontName("as");
        style.setFont(headerFont);
        style.setWrapText(true);

        //
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        style.setBorderTop((short)1);
        style.setWrapText(true);
        return style;
    }
}
