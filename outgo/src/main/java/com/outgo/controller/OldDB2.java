package com.outgo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transaction;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.outgo.bean.TransactionMaster;
import com.outgo.services.ApiServices;

@Controller
public class OldDB2 {


	@Autowired
	ApiServices service;	
	

@ResponseBody
@RequestMapping(value = { "/excel2"})
public String newProduct(HttpServletRequest request,@RequestParam("imageFile") MultipartFile file ) throws RollbackException {
	
	String path="";
	
	String skeep="";
	
	int i = 15;
	HSSFWorkbook workbook;
	try{
	workbook= new HSSFWorkbook(new POIFSFileSystem(
			file.getInputStream()));
	
	}catch(OfficeXmlFileException v){
		return "2007";
	}catch(IOException v){
		return "Unable";
	}
	HSSFSheet worksheet = workbook.getSheetAt(0);
	
	//system.println("worksheet====>>>>>>"+worksheet+"--...."+worksheet.getLastRowNum());
	try {
		
	
	while (i <= worksheet.getLastRowNum()) {
		HSSFRow row = worksheet.getRow(i++);
		HSSFRow row1 = worksheet.getRow(16);

		try {

	//system.println();

	
	try {
	
		System.out.println(test(row, 2));
		System.out.println("Service Charge  "+test(row, 7));
		System.out.println("GST "+test(row, 8));
		System.out.println("Settlement Amount "+ test(row, 9));

		if(test(row, 2)==null||test(row, 2).equals("")) {
			
		}else {
			
			TransactionMaster t  =service.getTransaction(test(row, 2).trim());
			
			System.out.println("DATA" + new Gson().toJson(t));
					
			
			 //u.getData("select t.transaction_order_id from Transaction_Master t where t.transaction_order_id='"+test(row, 22).trim()+"'");
try {
			if(t!=null) {
				service.update("update Transaction_Master tx set tx.transaction_realease_amount='"+ floatv(row, 9)+"' ,tx.transaction_release_code='"+test(row1,0)+"' ,tx.transaction_payout=true ,tx.transaction_Release_date='"+test(row1, 19)+"', tx.payoutref='true' where tx.transaction_order_id='"+test(row, 2)+"'");
				
/*				t.setPayoutref("true");
				t.setTransaction_payout(true);
				t.setTransaction_release_code(test(row,19));
				t.setTransaction_realease_amount(Double.parseDouble(test(row, 9)));
				t.setTransaction_Release_date(test(row, 18));
				t=u.insertTransaction(t);
*/			}
}catch (NullPointerException e) {
	System.out.println("DATA NULL" );
	}		
			
	//	u.update("update Transaction_Master tx set tx.transaction_realease_amount='"+ test(row, 9)+"' ,tx.transaction_release_code='"+test(row,19)+"' ,tx.transaction_payout=true ,tx.transaction_Release_date='"+test(row, 18)+"', tx.payoutref='true' where tx.transaction_order_id='"+test(row, 2)+"'");
		}
	
		
	}catch (NullPointerException e) {
		System.out.println(" null: "+ e +"             "+test(row, 1));
	}catch (org.springframework.transaction.UnexpectedRollbackException e) {
		System.out.println(" springframework: "+ e +"             "+test(row, 1));
	}
	
		
	
		
		}catch (org.springframework.transaction.UnexpectedRollbackException e) {
			System.out.print (  "  ---EROOR " +i);

			
			  skeep+=" UnexpectedRollbackException: "+test(row, 1);
				continue;
		}
		catch (Exception e) {
			  skeep+=" XXX: "+test(row, 1);
		}

	}
		
	}catch (Exception e) {
		  skeep+=" yyy: ";
	
	}
	
	return skeep;
	
}
	




public String test(HSSFRow row ,int p) {
	String val;

	try {							
		
		int str = row.getCell(p).getCellType();
		switch (str) {
		case Cell.CELL_TYPE_STRING:							
			val=row.getCell(p).getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			val=(long)row.getCell(p).getNumericCellValue()+"";
			break;
		default:
			val="";
			break;
		}
		} catch (NullPointerException e) {
		val="";
		}
	return val;
}


public String floatv(HSSFRow row ,int p) {
	String val;

	try {							
		
		int str = row.getCell(p).getCellType();
		switch (str) {
		case Cell.CELL_TYPE_STRING:							
			val=row.getCell(p).getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			val=(Double)row.getCell(p).getNumericCellValue()+"";
			break;
		default:
			val="";
			break;
		}
		} catch (NullPointerException e) {
		val="";
		}
	return val;
}

}
