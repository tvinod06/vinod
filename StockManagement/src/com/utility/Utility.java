package com.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.constant.Constants;
import com.dao.BankDao;
import com.dao.CommonDao;
import com.dao.DocumentDao;
import com.dao.ExpenditureDao;
import com.dao.StockInDao;
import com.dao.WorkersDao;
import com.dto.CmnLookupBean;
import com.dto.CustomerFormBean;
import com.dto.FileUploadBean;
import com.dto.ReportFormBean;
import com.dto.RetailFormBean;
import com.dto.StockFormBean;
import com.dto.WorkersFormBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.valueobject.Document;

@Controller
public class Utility {
	
	@Autowired
	private DocumentDao docDao;
	@Autowired
	private CommonDao cmnDao;
	@Autowired
	private StockInDao stockInDao;
	@Autowired
	private ExpenditureDao expenditureDao;
	@Autowired
	private WorkersDao workersDao;
	@Autowired
	private BankDao bankDao;
	
	@RequestMapping(value="uploadFile",method=RequestMethod.POST)
	public @ResponseBody String uploadFile(MultipartHttpServletRequest request,HttpSession session) throws Exception
 {
		Iterator<String> itr = request.getFileNames();
		Document doc = new Document();
		BeanUtils.populate(doc, request.getParameterMap());
		JSONObject jObj = new JSONObject();
		while (itr.hasNext()) {
			MultipartFile mpf = request.getFile(itr.next());
			try {
				if(doc.getCategory() == null || doc.getCategory().equals("-1")){
					doc.setCategory(Constants.WITHDRAWL);
				}
				doc.setFileBytes(mpf.getBytes());
				if(mpf.getContentType().length() <= 50){
					doc.setFileType(mpf.getContentType());
				}else{
					doc.setFileType(mpf.getContentType().substring(0, 49));
				}
				if(mpf.getOriginalFilename().length() <= 50){
					doc.setFileName(mpf.getOriginalFilename());
				}else{
					doc.setFileName(mpf.getOriginalFilename().substring(0, 49));
				}
				if(doc.getFileBytes().length > 16777215){
					jObj.put("docId", "");
				}else{
					Long docId = docDao.saveDocumentDtl(doc);
					jObj.put("docId", docId);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jObj.toString();
	}
	
	public FileUploadBean getUploadedFileDtl(MultipartHttpServletRequest request) throws Exception
	{
		Iterator<String> itr =  request.getFileNames();
		FileUploadBean bean = new FileUploadBean();
		 
		while (itr.hasNext()) {
			MultipartFile mpf = request.getFile(itr.next());
			bean.setLength(Long.valueOf(mpf.getBytes().length));
			bean.setBytes(mpf.getBytes());
			bean.setContentType(mpf.getContentType());
			bean.setName(mpf.getOriginalFilename());
		}
	return bean;
	}
	
	public List<StockFormBean> getBeanListFromObject(String str){
		List<StockFormBean> productList = null;
		if(str != null){
			try{
				productList = new ArrayList<StockFormBean>();
				JSONArray productArray = new JSONArray(str);
				for(int i=0; i<productArray.length(); i++){
					JSONArray productDtl = new JSONArray(productArray.get(i).toString());
					StockFormBean bean = new StockFormBean();
					bean.setProductUniqueId(productDtl.get(0).toString());
					bean.setProductName(productDtl.get(1).toString());
					bean.setCategory(productDtl.get(2).toString());
					bean.setQuantity(Long.parseLong(productDtl.get(3).toString()));
					bean.setRatePerUnit(Long.parseLong(productDtl.get(4).toString()));
					bean.setTotalAmount(Long.parseLong(productDtl.get(5).toString()));
					productList.add(bean);
				}
				
			}catch(Exception e){
				System.out.println("Could not cast "+e.getMessage());
			}
		}
		return productList;
	}
	
	
	public List<CustomerFormBean> getCustProdListFrmArray(String str){
		List<CustomerFormBean> custProdList = null;
		if(str != null){
			try{
				custProdList = new ArrayList<CustomerFormBean>();
				JSONArray productArray = new JSONArray(str);
				for(int i=0; i<productArray.length(); i++){
					JSONArray productDtl = new JSONArray(productArray.get(i).toString());
					CustomerFormBean bean = new CustomerFormBean();
					bean.setProductUniqueId(productDtl.get(0).toString());
					bean.setProductName(productDtl.get(1).toString());
					bean.setCategory(productDtl.get(2).toString());
					bean.setScale(productDtl.get(3).toString());
					custProdList.add(bean);
				}
				
			}catch(Exception e){
				System.out.println("Could not cast "+e.getMessage());
			}
		}
		return custProdList;
	}
	
	public List<CmnLookupBean> getLookupNameByParentId(Long parentId) throws Exception{
		List<CmnLookupBean> lookupLst = null;
		if(parentId != null){
			lookupLst = cmnDao.getLookupNameByParentId(parentId);
		}
		return lookupLst;
	}

	public List<RetailFormBean> getRetailListFromObject(String str) {
		List<RetailFormBean> productList = null;
		if(str != null){
			try{
				productList = new ArrayList<RetailFormBean>();
				JSONArray productArray = new JSONArray(str);
				for(int i=0; i<productArray.length(); i++){
					JSONArray productDtl = new JSONArray(productArray.get(i).toString());
					RetailFormBean bean = new RetailFormBean();
					bean.setProductUniqueId(productDtl.get(0).toString());
					bean.setProductName(productDtl.get(1).toString());
					bean.setCategory(productDtl.get(2).toString());
					bean.setQuantity(Long.parseLong(productDtl.get(3).toString()));
					bean.setRatePerUnit(Long.parseLong(productDtl.get(4).toString()));
					bean.setTotalAmount(Long.parseLong(productDtl.get(5).toString()));
					productList.add(bean);
				}
				
			}catch(Exception e){
				System.out.println("Could not cast "+e.getMessage());
			}
		}
		return productList;
	}

	public List<WorkersFormBean> getWorkerList(String str, WorkersFormBean workerBean) {
		List<WorkersFormBean> workerList = null;
		if(str != null){
			try{
				workerList = new ArrayList<WorkersFormBean>();
				JSONArray workersArray = new JSONArray(str);
				for(int i=0; i<workersArray.length(); i++){
					JSONArray productDtl = new JSONArray(workersArray.get(i).toString());
					WorkersFormBean bean = new WorkersFormBean();
					bean.setNumOfUnits(Long.parseLong(productDtl.get(1).toString()));
					bean.setTotalAmount(bean.getNumOfUnits()*workerBean.getRatePerUnit());
					workerList.add(bean);
				}
				
			}catch(Exception e){
				System.out.println("Could not cast "+e.getMessage());
			}
		}
		return workerList;
	}
	
	public Map<String,Object> getHomePageDtls() throws Exception{
		Map<String,Object> displayMap = new HashMap<String, Object>();
		//stock in amount
		displayMap.put("stockInAmt", stockInDao.getMonthlyStockInAmnt());
		//stock out amount
		displayMap.put("stockOutAmt", stockInDao.getMonthlyStockOutAmnt());
		//bank withdrawl
		displayMap.put("withDrawlAmt", bankDao.getMonthlyBankWithDrawAmnt());
		//bank deposit
		displayMap.put("depositAmt", bankDao.getMonthlyBankDepositAmnt());
		// innvestment
		displayMap.put("investmentAmt", expenditureDao.getMonthlyExpenditureAmnt());
		//workers wages
		displayMap.put("workersAmt", workersDao.getMonthlyWorkersAmnt());
		return displayMap;
		
	}
	
	public String generateReports(Date frmDate, Date toDate, String orientation)
			throws Exception {

		com.itextpdf.text.Document document = null;
		if (orientation.equals("1")) {
			document = new com.itextpdf.text.Document(PageSize.A4.rotate()); // Create
		} else {
			document = new com.itextpdf.text.Document();
		}
		
		String home = System.getProperty("user.home");
		if(!new File(home+"/Downloads/Friends Chicken/").exists()){
			new File(home+"/Downloads/Friends Chicken/").mkdirs();
		}
		String path = home+"/Downloads/Friends Chicken/"
				+ System.currentTimeMillis() + ".pdf";
		OutputStream outputStream = new FileOutputStream(new File(path));
		PdfWriter.getInstance(document, outputStream);
		document.open();
		// Add content to the document.
		document = addHeader(document);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Paragraph paragraph1 = new Paragraph("This report shows details from "
				+ sdf.format(frmDate) + " to " + sdf.format(toDate));
		paragraph1.setIndentationLeft(80);
		paragraph1.setIndentationRight(80);
		paragraph1.setAlignment(Element.ALIGN_CENTER);
		paragraph1.setSpacingAfter(15);
		document.add(paragraph1);

		document = addTable(document, frmDate, toDate);

		document = addFooter(document);

		document.close();
		outputStream.close();
		
		return path;
	}
	
	private com.itextpdf.text.Document addHeader(com.itextpdf.text.Document document) throws Exception{
		
		Phrase phrase2 = new Phrase();
        Paragraph paragraph = new Paragraph();
        Font timesRomanfont = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLDITALIC);
        Font timesRomanfont1 = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL);
        Chunk timesRomanChunk = new Chunk("Friends Chicken Centre",timesRomanfont);
        phrase2.add(timesRomanChunk);
        phrase2.add(Chunk.NEWLINE);
        phrase2.add(new Chunk("Sapthagiri Nagar Circle, Tirupati.",timesRomanfont1));
        phrase2.add(Chunk.NEWLINE);
        phrase2.add(Chunk.NEWLINE);
         
       /* Font underlineFont = new Font(Font.FontFamily.HELVETICA,20,Font.UNDERLINE);
        Chunk underlineChunk = new Chunk("This is underLined",underlineFont);
        phrase2.add(underlineChunk);*/
         
        paragraph.add(phrase2);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        
        return document;
	}
	
	private com.itextpdf.text.Document addFooter(com.itextpdf.text.Document document) throws Exception{
		
        Phrase phrase2 = new Phrase();
        Phrase phrase3 = new Phrase();
        Paragraph paragraph = new Paragraph();
        Paragraph paragraph2 = new Paragraph();
        Font timesRomanfont1 = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL);
        Chunk timesRomanChunk = new Chunk("**This Report is generated from Stock Manament System",timesRomanfont1);
        Chunk timesRomanChunk1 = new Chunk("*All amount in INR and date in DD/MM/YYYY ",timesRomanfont1);
        phrase2.add(timesRomanChunk);
        phrase2.add(new Chunk(" on "+new Date()+".",timesRomanfont1));
        phrase3.add(timesRomanChunk1);
        paragraph.add(phrase2);
        paragraph2.add(phrase3);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        paragraph2.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        document.add(paragraph2);
        
        return document;
	}

	private com.itextpdf.text.Document addTable(
			com.itextpdf.text.Document document, Date frmDate, Date toDate)
			throws Exception {

		List<ReportFormBean> stockDtls = cmnDao.getAllReportDtls(frmDate,
				toDate);
		List<ReportFormBean> retailDtls = cmnDao.getRetailDtls(frmDate,
				toDate);
		Map<Date, List<ReportFormBean>> datewise = new HashMap<Date, List<ReportFormBean>>();
		Set<String> hotels = new HashSet<String>();
		if (stockDtls != null) {
			for (ReportFormBean bean : stockDtls) {
				if(bean.getCustomerName() != null && !bean.getCustomerName().trim().equals("")){
					hotels.add(bean.getCustomerName());
				}
			}
			
			for (ReportFormBean bean : stockDtls) {
				List<ReportFormBean> list = new ArrayList<ReportFormBean>();
				bean.setRetailAmount(0L);
				if (datewise.containsKey(bean.getTodayDate())) {
					list = datewise.get(bean.getTodayDate());
					list.add(bean);
				} else {
					list.add(bean);
					datewise.put(bean.getTodayDate(), list);
				}
			}
		}
		
		if (retailDtls != null) {
			for (ReportFormBean bean : retailDtls) {
				List<ReportFormBean> list = new ArrayList<ReportFormBean>();
				if (datewise.containsKey(bean.getTodayDate())) {
					list = datewise.get(bean.getTodayDate());
					list.get(0).setRetailAmount(bean.getRetailAmount());
				} else {
					list.add(bean);
					datewise.put(bean.getTodayDate(), list);
				}
			}
		}
		
		PdfPTable table = new PdfPTable(6+hotels.size());
		table.setTotalWidth(PageSize.A4.getWidth());
		table.setLockedWidth(true);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Date");
		//table.addCell("Live Rate");
		table.addCell("Total Live Amount");

		for (String hotel : hotels) {
			if(hotel != null && !hotel.trim().equals("")){
				table.addCell(hotel);
			}
		}

		table.addCell("Total Hotel Amount");
		table.addCell("Total Retail Amount");
		table.addCell("Other Expense");
		table.addCell("Balance (H + R - L - E) ");
		table.setHeaderRows(1);
		table.completeRow();
		PdfPCell[] cells = table.getRow(0).getCells();
		for (int j = 0; j < cells.length; j++) {
			cells[j].setBackgroundColor(BaseColor.LIGHT_GRAY);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (datewise.keySet() != null && !datewise.keySet().isEmpty()) {
			for (Date dt : datewise.keySet()) {
				table.addCell(sdf.format(dt));
				List<ReportFormBean> beanLst = datewise.get(dt);
				if (beanLst != null && !beanLst.isEmpty()) {
					ReportFormBean bean = beanLst.get(0);
					//table.addCell(bean.getLiveRate() == null ? "0" : bean.getLiveRate().toString());
					table.addCell(bean.getStockInAmount() == null ? "0" : bean.getStockInAmount().toString());
				}
				Long totalhotelAmnt = 0L;
				Iterator<String> itr = hotels.iterator();
				while (itr.hasNext()) {
					String hotel = itr.next();
					boolean noOrder = true;
					for (ReportFormBean bean : beanLst) {
						if (bean.getCustomerName() != null && bean.getCustomerName().equals(hotel)) {
							table.addCell(bean.getStockOutAmount().toString());
							totalhotelAmnt = totalhotelAmnt
									+ bean.getStockOutAmount();
							noOrder = false;
						}
					}
					if(noOrder){
						table.addCell("0");
					}
				}

				if (beanLst != null && !beanLst.isEmpty()) {
					ReportFormBean bean = beanLst.get(0);
					table.addCell(totalhotelAmnt.toString());
					table.addCell(bean.getRetailAmount() == null ? "0" : bean.getRetailAmount().toString());
					table.addCell(bean.getExpenditureAmount()==null ? "0" : bean.getExpenditureAmount().toString());
					table.addCell(String.valueOf(totalhotelAmnt + (bean.getRetailAmount() == null ? 0L : bean.getRetailAmount())
							- (bean.getStockInAmount() == null ? 0L : bean.getStockInAmount())
							- (bean.getExpenditureAmount() == null ? 0L : bean.getExpenditureAmount())));
				}
				table.completeRow();
			}
			//Footer
			ReportFormBean beans = cmnDao.getReportFooterDetails(frmDate, toDate);
			table.addCell("Total");
			//table.addCell("-");
			table.addCell(beans.getFinalStockInAmount().toString());
			Long totalHotelsAmnt = 0L;
			Iterator<String> itr = hotels.iterator();
			while (itr.hasNext()) {
				String hotel = itr.next();
				boolean noOrder = true;
				if (beans.getReportFormBeanList() != null) {
					for (ReportFormBean bean : beans.getReportFormBeanList()) {
						if (bean.getCustomerName().equals(hotel)) {
							table.addCell(bean.getFinalStockOutAmount()
									.toString());
							totalHotelsAmnt = totalHotelsAmnt
									+ bean.getFinalStockOutAmount();
							noOrder = false;
						}
					}
				}
				if(noOrder){
					table.addCell("0");
				}
			}
			table.addCell(totalHotelsAmnt.toString());
			table.addCell(beans.getFinalRetailAmount().toString());
			table.addCell(beans.getFinalInvestmentAmount().toString());
			table.addCell(String.valueOf(totalHotelsAmnt
					- beans.getFinalStockInAmount()
					+ beans.getFinalRetailAmount()
					- beans.getFinalInvestmentAmount()));
			PdfPCell[] finalcells = table.getRow(table.getRows().size()-1).getCells();
			for (int j = 0; j < finalcells.length; j++) {
				cells[j].setBackgroundColor(BaseColor.LIGHT_GRAY);
			}
			document.add(table);
		} else {
			
			Font font = new Font(FontFamily.TIMES_ROMAN, 14);
			Paragraph paragraph1 = new Paragraph("No data found in system.");
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			paragraph1.setFont(font);
			document.add(paragraph1);
		}
		return document;
	}

}
