package com.outgo.pdf;


import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

public class TaxInvoice extends AbstractITextPdfViewA4 {
	
	private Font headFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 20, Font.BOLD);
	private Font headFont1= FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 10, Font.NORMAL);
	private Font headFont2= FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 13, Font.BOLD);
	
	private Font subHeadFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 10, Font.BOLD);
	private Font bigFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 10, Font.BOLD);
	   private Font smallFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 9, Font.ITALIC);
	   private Font smallFont1 = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 10, Font.NORMAL);
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String s = formatter.format(new Date());
	  
	    String custName=request.getAttribute("custName")+"";
	    String custMobile=request.getAttribute("custMobile")+"";
	    String custId=request.getAttribute("custId")+"";
	    String custAddress=request.getAttribute("custAddress")+"";
	    String amount=request.getAttribute("amount")+"";
	    String gstId=request.getAttribute("gstId")+"";
	    String billNo=request.getAttribute("billNo")+"";
	    String billDueDate=request.getAttribute("billDueDate")+"";
	    String billDate=request.getAttribute("billDate")+"";
	    String billPeriod=request.getAttribute("billPeriod")+"";
	    String serviceCode=request.getAttribute("serviceCode")+"";
	    String serviceName=request.getAttribute("serviceName")+"";
	    String SAC=request.getAttribute("SAC")+"";
	    
		/*List<TransactionDetailsSave> list= (List<TransactionDetailsSave>) model.get("list");*/
		
		 String service="";
		doc.addTitle(service);//
		//To add the Author for the PDF
		doc.addAuthor("OutGo Payment Solution Pvt. Ltd. [Amol Delmade]");
		//To add the subject to the PDF document
		doc.addSubject("OutGo Commison");
		
		
	
		Font f2 = new Font();
        f2.setColor(BaseColor.BLACK);
        f2.setSize(22);
        Font f3 = new Font();
        f3.setColor(BaseColor.BLACK);
        f3.setSize(15);
		
     Image companyLogo = Image.getInstance("http://s3.ap-south-1.amazonaws.com/www.phonehouse.in/img/Capture.PNG");
    //    Image companyLogo = Image.getInstance("http://localhost:8080/admin/resources/img/profile-pics/1.jpg");
	        companyLogo.scaleToFit(120, 120);
	       // table3.setWidthPercentage(99.0f);
	        Paragraph p3;
	        //headFont.setColor(0,147,221);
	        p3 = new Paragraph("");
	        companyLogo.setAlignment(Image.LEFT| Image.TEXTWRAP);  
	        p3.add(new Chunk(companyLogo, 0, 0, true));  
	        //p3.add(new Chunk("Broadband Pvt Ltd", headFont));  
	        doc.add(p3);
	        p3 = new Paragraph(20,"Tax Invoice",headFont);//Org Name changes as per area
	        p3.setAlignment(Element.ALIGN_CENTER);
	        doc.add(p3);
	       
			PdfPTable t1 = new PdfPTable(1); 
			t1.setWidthPercentage(100); 
			t1.setSpacingBefore(11f); 
			
			float[] c = {1f};
			t1.setWidths(c);
	       
			
			PdfPTable table = new PdfPTable(2); 
			table.setWidthPercentage(100); 
			table.setSpacingBefore(11f); 
			table.setSpacingAfter(11f); 
			
			float[] columnWidths = {2f, 1f};
			table.setWidths(columnWidths);
			PdfPCell cell1 = new PdfPCell(new Paragraph(20,"Group Company Name:  "+custName+"\nCompany Name:  "+custName+"\nGST ID:  "+gstId+"\nBilling Address:  "+custAddress+"\nContact Person:  "+custName+"\nContact No:  "+custMobile+"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.disableBorderSide(0);
			cell1.disableBorderSide(1);
			cell1.disableBorderSide(2);
			cell1.disableBorderSide(3);
			cell1.disableBorderSide(4);
			
		
			PdfPCell cell2 = new PdfPCell(new Paragraph(20,"Bill Number:  "+billNo+"\nCustomer Code: "+custId+" \nBill Date:  "+billDate+"\nBill Due:  "+billDueDate+  "\nDate Bill:  "+billDate+  "\nPeriod: "+billPeriod+"\nBilling Cycle",headFont1));
			cell2.setBorderColor(BaseColor.WHITE);
			cell2.disableBorderSide(0);
			cell2.disableBorderSide(1);
			cell2.disableBorderSide(2);
			cell2.disableBorderSide(3);
			cell2.disableBorderSide(4);
			table.addCell(cell1);
			table.addCell(cell2);
			
			PdfPCell tcell = new PdfPCell(table);
			tcell.setBorderColor(BaseColor.BLACK);
			tcell.setPaddingLeft(12);
			tcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t1.addCell(tcell);
			doc.add(t1);
			
			
			/* table = new PdfPTable(1); // 3 columns.
				table.setWidthPercentage(100); //Width 100%
				table.setSpacingBefore(11f); //Space before table
				float[] columnWidth = {1f};
				table.setWidths(columnWidth);
				 tcell = new PdfPCell(new Paragraph(20,"Invoice Items",headFont1));
				tcell.setBorderColor(BaseColor.BLACK);
				tcell.setPaddingLeft(12);
				tcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				tcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(tcell);
				doc.add(table);*/
			Paragraph p = new Paragraph(" " + 
			  		"Invoice Items\n",headFont1);   
		doc.add(p);
		t1 = new PdfPTable(1); 
		t1.setWidthPercentage(100); 
		t1.setSpacingBefore(11f); 
		t1.setWidths(c);
			 table = new PdfPTable(5); // 3 columns.
			table.setWidthPercentage(100); //Width 100%
			table.setSpacingBefore(11f); //Space before table
			float[] columnWidths1 = {1f,1f,1f,1f,1f};

			table.setWidths(columnWidths1);
			cell1 = new PdfPCell(new Paragraph(20,"Invoice Items",headFont1));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell2 = new PdfPCell(new Paragraph(20,"Rate",headFont1));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(12);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//table.addCell(cell1);
			
			
	/*		cell1 = new PdfPCell(new Paragraph(20,"\nService Code         Service Description         Invoice Period        Charges         Total Due( in Rupee)         ",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	*/	
			
			cell1 = new PdfPCell(new Paragraph(20,"Service Code",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Service Description",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Invoice Period",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Charges",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Total Due( in Rupee)         ",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			t1.addCell(table);	
			float amt=Float.parseFloat(amount);
			/*float tax=(amt/100)*18;
			float tamount=amt-tax;
			float gst=tax/2;*/
			float tax=(amt/100)*18;
			float tamount=amt+tax;
			float gst=tax/2;
			
			 table = new PdfPTable(5); // 3 columns.
				table.setWidthPercentage(100); //Width 100%
				table.setSpacingBefore(11f); //Space before table
				//float[] columnWidths1 = {1f,1f,1f,1f,1f};
				table.setWidths(columnWidths1);
			
			cell1 = new PdfPCell(new Paragraph(20,""+serviceCode,headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+serviceName,headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+billPeriod,headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	

			
			cell1 = new PdfPCell(new Paragraph(20,"SAC Code",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Recuring Charge",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(amt,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);

			

			
			
			
			cell1 = new PdfPCell(new Paragraph(20,""+SAC,headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Sub Total",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(amt,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);


			

			
			
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"SGST@9%",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(gst,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);


			
			
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"CGST@9%",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(gst,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);


			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Sub Total",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(tamount,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);


			
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Total",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(tamount,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			
			t1.addCell(table);	
			 table = new PdfPTable(5); // 3 columns.
				table.setWidthPercentage(100); //Width 100%
				table.setSpacingBefore(11f); //Space before table
				//float[] columnWidths1 = {1f,1f,1f,1f,1f};
				table.setWidths(columnWidths1);
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,"Total",headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
	
			cell1 = new PdfPCell(new Paragraph(20,""+round(tamount,2),headFont1));
			cell1.setBorderColor(BaseColor.WHITE);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			t1.addCell(table);	
				//table.addCell(cell2);
			
			
				cell2 = new PdfPCell(new Paragraph(20,"\n "+serviceCode+"                     "+serviceName+"                   "+billPeriod+"                \n\n"
			             + "  SAC Code                                                                               Recuring Charge         :  "+tamount+" \n"
			             + "  "+SAC+"                                                                                         Sub Total          :  "+tamount+" \n"
			             + "                                                                                                         SGST@9%        :  "+gst+" \n"
			             + "                                                                                                         CGST@9%        :  "+gst+" \n"
			             + "                                                                                                             Sub total        :  "+amount+" \n"
			             + "                                                                                                                   Total        :  "+amount+" \n"
						             + "                                                                                                \n",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
					//table.addCell(cell2);
			

			
			cell1 = new PdfPCell(new Paragraph(20,"\n                                                                                                                   Total        :  "+amount+" \n",headFont1));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//table.addCell(cell1);
			 cell2 = new PdfPCell(new Paragraph(20,"",headFont1));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(12);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			//table.addCell(cell2);
		
			
				cell2 = new PdfPCell(new Paragraph(20,"\nRemark",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//table.addCell(cell2);
				
				
				
				
				
				doc.add(t1);
				  p = new Paragraph(" " + 
					  		"Remark\n",headFont1);   
				doc.add(p);
				
				t1 = new PdfPTable(1); 
				t1.setWidthPercentage(100); 
				t1.setSpacingBefore(11f); 
				t1.setWidths(c);
		       
				
				PdfPTable table1 = new PdfPTable(2); 
				table1.setWidthPercentage(100); 
				table1.setSpacingBefore(11f); 
				table1.setSpacingAfter(11f); 
				
				
				table1.setWidths(columnWidths);
				 cell1 = new PdfPCell(new Paragraph(20,"Company Registered Address:\n264/4, Shaniwar Peth, Near Omkareshwar Mandir, Pune\n\nInstructions:\n"
				 		+ "1. Please pay by DD/Crossed Cheque in favour of PHONE HOUSE\n"
				 		+ "2. Past dues are to be paid immediately in order to avoid disconnection.\n"
				 		+ "4. PAN No. AAHPT4206C\n"
				 		+ "5. CIN No.-\n"
				 		+ "6. GST ID. 27AAHPT4206C1ZX",headFont1));
				cell1.setBorderColor(BaseColor.WHITE);
				cell1.disableBorderSide(0);
				cell1.disableBorderSide(1);
				cell1.disableBorderSide(2);
				cell1.disableBorderSide(3);
				cell1.disableBorderSide(4);
				
			
				 cell2 = new PdfPCell(new Paragraph(20,"	For any queries please email us.\n\n"
				 		+ "	Billing Email    :   phonehouse.asf@gmail.com\n"
				 		+ "	\n"
				 		+ "	CustomerCare  No:9850494052 \n"
				 		+ "",headFont1));
				cell2.setBorderColor(BaseColor.WHITE);
				cell2.disableBorderSide(0);
				cell2.disableBorderSide(1);
				cell2.disableBorderSide(2);
				cell2.disableBorderSide(3);
				cell2.disableBorderSide(4);
				table1.addCell(cell1);
				table1.addCell(cell2);
				
				 tcell = new PdfPCell(table1);
				tcell.setBorderColor(BaseColor.BLACK);
				tcell.setPaddingLeft(12);
				tcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				tcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				t1.addCell(tcell);
				doc.add(t1);
				

				
			
			
			
			  Paragraph p6 = new Paragraph("                                      Please cut the below portion and attach it along with the payments. ",smallFont);   
			  
		    doc.add(p6);	
			
		    p6 = new Paragraph("                              --------------------------------------------------------------------------------------------------------------------------------- \n",smallFont);    
		    doc.add(p6);
	      

		  
		 
		
		    
		    table = new PdfPTable(5); // 3 columns.
			table.setWidthPercentage(100); //Width 100%
			//table.setSpacingBefore(16f); //Space before table
			//table.setSpacingAfter(16f); //Space after table
			float[] columnWidths2 = {1f, 1f,1f,1f,1f};
			table.setWidths(columnWidths2);
			
			cell1 = new PdfPCell(new Paragraph(20,"Account ID ",bigFont));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell2 = new PdfPCell(new Paragraph(20,"Bill No",bigFont));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(12);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			table.addCell(cell2);
		
			    cell2 = new PdfPCell(new Paragraph(20,"Bill Date",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				

			    cell2 = new PdfPCell(new Paragraph(20,"Bill Amount",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(20,"Payment Due Date",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2);
				
				
				cell2 = new PdfPCell(new Paragraph(30,custId+" ",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30," "+billNo,headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30," "+billDate,headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,""+round(tamount,2),headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,""+billDueDate,headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				
				  p6 = new Paragraph("  Cheque / DD should be in favour of PHONE HOUSE.\n ",headFont1);   
				  
				  
				
		doc.add(table);
		  doc.add(p6);	
		  table = new PdfPTable(5); // 3 columns.
			table.setWidthPercentage(100); //Width 100%
			//table.setSpacingBefore(16f); //Space before table
			//table.setSpacingAfter(16f); //Space after table
			
			table.setWidths(columnWidths2);
			
			cell1 = new PdfPCell(new Paragraph(20,"Cheque / DD No ",bigFont));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(12);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell2 = new PdfPCell(new Paragraph(20,"Bank Name",bigFont));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(12);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			table.addCell(cell2);
		
			    cell2 = new PdfPCell(new Paragraph(20,"Bank Branch",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				

			    cell2 = new PdfPCell(new Paragraph(20," Amount",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(20,"Remark",bigFont));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2);
				
				
				cell2 = new PdfPCell(new Paragraph(30,"-",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,"-",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,"-",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,"-",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(30,"-",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				
				  p6 = new Paragraph(" " + 
				  		"Payment Details\n ",headFont1);   
				  
				  
				
		doc.add(table);
		  doc.add(p6);	
		  
		  
		  
		  
		  
		  
		  table = new PdfPTable(2); // 3 columns.
			table.setWidthPercentage(100); //Width 100%
			//table.setSpacingBefore(16f); //Space before table
			//table.setSpacingAfter(16f); //Space after table
			float[] columnWidths3 = {1f, 1f};
			table.setWidths(columnWidths3);
			
			
				
				
				cell2 = new PdfPCell(new Paragraph(50,"Beneficiary name: PHONE HOUSE\n\nCompany Address: 264/4, Shaniwar Peth, Near Omkareshwar Mandir, Pune\n\nBank Account Number: 045100100000595\n\nRTGS - NEFT IFSC Code: SRCB0000045\n\nMICR Code:\n\nBank Name: Saraswat Bank",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				//cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				//cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(50,"Beneficiary name: PHONE HOUSE\n\nCompany Address: 264/4, Shaniwar Peth, Near Omkareshwar Mandir, Pune\n\nBank Account Number: 045100100000595\n\nRTGS - NEFT IFSC Code: SRCB0000045\n\nMICR Code:\n\nBank Name: Saraswat Bank",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				//cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				//cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				/*cell2 = new PdfPCell(new Paragraph(50,"Beneficiary name:\nCompany Address:\n\n\nBank Account Number:\nRTGS - NEFT IFSC Code\nMICR Code\\nBank Name",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); 
				cell2 = new PdfPCell(new Paragraph(50," PHONE HOUSE\n 264/4, Shaniwar Peth, Near Omkareshwar Mandir, Pune\n045100100000595\nSRCB0000045\n \nSaraswat Bank",headFont1));
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setPaddingLeft(12);
				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell2); */
				
				 
				  
				
		doc.add(table);
		  
		  
		  
		  
		  
		 p6 = new Paragraph("                 'This is a system generated Invoice, does not require any signatures' ",headFont1);   
			doc.add(p6);
	   
	   	
		
		
	   
	}
	
	
	
	
	
	 public static float round(float d, int decimalPlace) {
	        BigDecimal bd = new BigDecimal(Float.toString(d));
	        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	        return bd.floatValue();
	    }
	
	
	
}
