package org.jesus.meslap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFChart;
import org.apache.poi.hssf.usermodel.HSSFChart.HSSFSeries;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * @author hejin
 *
 */
public class ExcelUtil {
	public final static String XLS = "xls";
	public final static String XLSX = "xlsx";
	
	public final static int LINE_CHART = 0;
	public final static int BAR_CHART = 1;
	public final static int DOUBLE_PIE_CHART = 2;
	public final static int SINGLE_PIE_CHART = 3;
	public final static int MULTIPLE_LINE_CHART = 4;
	public final static int LINE_CHART_MAX_PERCENT = 5;
	public final static int BAR_CHART_MTBF = 6;
	public final static int LINE_CHART_RELATION = 7;
	
	public final static int START_MULTIPLE_NUMERIC = 0;
	public final static int MAXSIZE_MULTIPLE_NUMERIC = 50;//50~99
	
	public final static int START_MULTIPLE_RATE = 50;
	public final static int MAXSIZE_MULTIPLE_RATE = 100;//0~49
	
	public final int MAX_LINE_CHART_CNT=100;
	public final int MAX_BAR_CHART_MTBF_CNT=50;
	
	protected final String ROOT_PATH = "";//CommonProperties.getProp("web.dir");
	private Workbook workbook;
	private Sheet sheet;
	private HSSFChart[] charts;
	
	private CellStyle GRAY_RIGHT;
	private CellStyle GRAY_CENTER;
	private CellStyle DEFAULT_CENTER;
	private CellStyle DEFAULT_LEFT;
	private CellStyle DEFAULT_RIGHT;
	private CellStyle DEFAULT_TITLE_CENTER;
	private Font BOLD_WHITE_FONT;
	private Font BOLD_TITLE_FONT;
	private Font DEFAULT_FONT;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public ExcelUtil() {
		workbook = new HSSFWorkbook();
	}
	
	public ExcelUtil(Workbook workbook) {
		this.workbook = workbook;
	}
	public ExcelUtil(String path,String fileName) {
		try {
			InputStream is = new FileInputStream(path+File.separator+fileName);
			workbook = new HSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize POIExcelUtil
	 * @param chartType
	 */
	public ExcelUtil(int chartType) {
		try {
			InputStream is = new FileInputStream(getChartTypeLayoutFilePath(chartType));
			workbook = new HSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);
			charts = HSSFChart.getSheetCharts((HSSFSheet) sheet);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * get Chart FilePath
	 * @param chartType
	 * @return
	 */
	private String getChartTypeLayoutFilePath(int chartType){
		String filepath = null;
		switch(chartType){
			case 0 : filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"line_chart.xls";
				break;
			case 1 : filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"bar_chart.xls";
				break;
			case DOUBLE_PIE_CHART :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"pie_chart.xls";
				break;
			case SINGLE_PIE_CHART :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"single_pie_chart.xls";
				break;
			case MULTIPLE_LINE_CHART :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"multiple_line_chart.xls";
				break;
			case LINE_CHART_MAX_PERCENT :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"line_chart_max_percent.xls";
				break;
			case BAR_CHART_MTBF :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"mtbf_chart.xls";
				break;
			case LINE_CHART_RELATION :
				filepath = ROOT_PATH+File.separator+"../../excel_layout"+File.separator+"line_relataion_chart.xls";
				break;
		}
		return filepath;
	}
	
	/**
	 * getRow
	 * @param rowIndex
	 * @return
	 */
	public Row getRow(int rowIndex){
		Row row = sheet.getRow(rowIndex);
		if(row==null)
			row = sheet.createRow(rowIndex);
		return row;
	}
	
	/**
	 * Cell 항목을 가져온다.
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	public Cell getCell(int rowIndex, int cellIndex){
		Row row = getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		if(cell==null)
			cell = row.createCell(cellIndex);
		return cell;
	}
	
	/**
	 * getCell
	 * @param row
	 * @param cellIndex
	 * @return
	 */
	public Cell getCell(Row row, int cellIndex){
		Cell cell = row.getCell(cellIndex);
		if(cell==null)
			cell = row.createCell(cellIndex);
		return cell;
	}
	
	/**
	 * make border for merge Cell
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 */
	public void makeBorderSet(int sRow, int eRow, int sCol, int eCol,CellStyle style){
		for(int rowIndex=sRow;rowIndex<=eRow;rowIndex++){
			Row row = getRow(rowIndex);
			for(int colIndex=sCol;colIndex<=eCol;colIndex++){
				Cell cell = getCell(row,colIndex);
				if(style!=null)
					cell.setCellStyle(style);
			}
		}
	}
	
	/**
	 * Simple get MergeCell
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 * @return
	 */
	public Cell getMergeCell(int sRow, int eRow, int sCol, int eCol){
		sheet.addMergedRegion(new CellRangeAddress(sRow, eRow, sCol, eCol));
		Row row = getRow(sRow);
		return getCell(row,sCol);
	}
	
	/**
	 * set Merge String CellValue 
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 * @param value
	 */
	public void setMergeCellValue(int sRow, int eRow, int sCol, int eCol,String value){
		makeBorderSet(sRow,eRow,sCol,eCol,getStyleDefaultCenter());
		sheet.addMergedRegion(new CellRangeAddress(sRow, eRow, sCol, eCol));
		Cell cell = getCell(getRow(sRow),sCol);
		cell.setCellValue(value);
		cell.setCellStyle(getStyleDefaultCenter());
	}
	
	/**
	 * set Merge String CellValue with CellStyle
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 * @param value
	 * @param style
	 */
	public void setMergeCellValue(int sRow, int eRow, int sCol, int eCol,String value,CellStyle style){
		makeBorderSet(sRow,eRow,sCol,eCol,style);
		sheet.addMergedRegion(new CellRangeAddress(sRow, eRow, sCol, eCol));
		Cell cell = getCell(getRow(sRow),sCol);
		cell.setCellValue(value);
		if(style!=null)
			cell.setCellStyle(style);
	}
	
	/**
	 * set Merge Double CellValue
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 * @param value
	 */
	public void setMergeCellValue(int sRow, int eRow, int sCol, int eCol,Double value){
		makeBorderSet(sRow,eRow,sCol,eCol,getStyleDefaultCenter());
		sheet.addMergedRegion(new CellRangeAddress(sRow, eRow, sCol, eCol));
		Cell cell = getCell(getRow(sRow),sCol);
		cell.setCellValue(value);
		cell.setCellStyle(getStyleDefaultCenter());
	}
	
	/**
	 * set Merge Double CellValue with CellStyle
	 * @param sRow
	 * @param eRow
	 * @param sCol
	 * @param eCol
	 * @param value
	 */
	public void setMergeCellValue(int sRow, int eRow, int sCol, int eCol,Double value,CellStyle style){
		makeBorderSet(sRow,eRow,sCol,eCol,style);
		sheet.addMergedRegion(new CellRangeAddress(sRow, eRow, sCol, eCol));
		Cell cell = getCell(getRow(sRow),sCol);
		cell.setCellValue(value);
		if(style!=null)
			cell.setCellStyle(style);
	}
	
	
	
	
	/**
	 * set Integer CellValue
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,Integer value){
		if(value==null)
			value = 0;
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		cell.setCellStyle(getStyleDefaultCenter());
	}
	
	/**
	 * set Integer CellValue with CellStyle
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,Integer value, CellStyle style){
		if(value==null)
			value = 0;
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		if(style!=null)
			cell.setCellStyle(style);
	}
	
	/**
	 * set String CellValue
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,String value){
		if(value==null)
			value = "";
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		cell.setCellStyle(getStyleDefaultCenter());
	}
	
	/**
	 * set String CellValue with CellStyle
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,String value,CellStyle style){
		if(value==null)
			value = "";
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		if(style!=null)
			cell.setCellStyle(style);
	}
	
	/**
	 * set Double Cell Value
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,Double value){
		if(value==null)
			value = 0.0;
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		cell.setCellStyle(getStyleDefaultCenter());
	}
	
	/**
	 * set Double Cell Value with CellStyle
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,Double value,CellStyle style){
		if(value==null)
			value = 0.0;
		Cell cell = getCell(getRow(rowIndex),colIndex);
		cell.setCellValue(value);
		if(style!=null)
			cell.setCellStyle(style);
	}
	
	/**
	 * SetCellValue for Object 
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public void setCellValue(int rowIndex,int colIndex,Object value){
		if(value instanceof String){
			setCellValue(rowIndex,colIndex,(String)value);
		}else if(value instanceof Integer){
			setCellValue(rowIndex,colIndex,(Integer)value);
		}else if(value instanceof Double){
			setCellValue(rowIndex,colIndex,(Double)value);
		}else{
			setCellValue(rowIndex,colIndex," ");
		}
	}
	
	/**
	 * SetCellValue for Object with CellStyle
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 * @param style
	 */
	public void setCellValue(int rowIndex,int colIndex,Object value, CellStyle style){
		if(value instanceof String){
			setCellValue(rowIndex,colIndex,(String)value, style);
		}else if(value instanceof Integer){
			setCellValue(rowIndex,colIndex,(Integer)value, style);
		}else if(value instanceof Double){
			setCellValue(rowIndex,colIndex,(Double)value, style);
		}else{
			setCellValue(rowIndex,colIndex,"unknown Type Value", style);
		}
	}
	
	/**
	 * 
	 * @param filepath
	 * @param excelFileName
	 */
	public void write(String excelFileName, OutputStream output){
		try {
			workbook.write(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String excelFileName){
		FileOutputStream fileOut=null;
		try {
			if(workbook instanceof XSSFWorkbook)
				excelFileName = excelFileName+"x";
			fileOut = new FileOutputStream(ROOT_PATH + excelFileName);
			workbook.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fileOut!=null)
					fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 단일항목 차트 생성.
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param column
	 */
	public void makeSingleChartData(int sCol,int eCol,int sRow,int eRow,String[] column){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			int seriesIndex = 0;
			for(int i=1;i<column.length;i++){
				//HSSFSeries serie = charts[0].createSeries();
				
				String seriesTitle = column[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[seriesIndex].setSeriesTitle(seriesTitle); 
				series[seriesIndex].setValuesCellRange(valueRange);
				series[seriesIndex].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				seriesIndex++;
			}
			removeEmptySeries(seriesIndex);
			for(int removeCellIndex = 0;removeCellIndex<=MAX_LINE_CHART_CNT+1;removeCellIndex++){
				removeCell(7, 7+6, removeCellIndex);
			}
			//for(int i=seriesIndex;i<series.length;i++){
				//charts[0].removeSeries(series[i]);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sSeriesIndex
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param column
	 */
	public void makeMultipleChartData(int sCol,int eCol,int sRow,int eRow,String[] column){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			int seriesIndex = 0;
			int maxSeriesIndex = MAX_LINE_CHART_CNT;
			for(int i=0;i<column.length;i++){
				//HSSFSeries serie = charts[0].createSeries();
				
				String seriesTitle = column[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[seriesIndex].setSeriesTitle(seriesTitle); 
				series[seriesIndex].setValuesCellRange(valueRange);
				series[seriesIndex].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				seriesIndex++;
			}
			
			removeEmptySeries(seriesIndex,maxSeriesIndex);
			
			for(int removeCellIndex = 0;removeCellIndex<=MAX_LINE_CHART_CNT+1;removeCellIndex++){
				removeCell(7, 7+6, removeCellIndex);
			}
			//for(int i=seriesIndex;i<series.length;i++){
				//charts[0].removeSeries(series[i]);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 다중항목 차트 생성.
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param column
	 */
	public void makeMultipleChartData(int sCol,int eCol,int sRow,int eRow,String[] numeric,String[] rate){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			int startNumeric = START_MULTIPLE_NUMERIC;
			int maxNumeric = MAXSIZE_MULTIPLE_NUMERIC;
			
			int startRate = START_MULTIPLE_RATE;
			int maxRate = MAXSIZE_MULTIPLE_RATE;
			for(int i=0;i<numeric.length;i++){
				String seriesTitle = numeric[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[startNumeric].setSeriesTitle(seriesTitle); 
				series[startNumeric].setValuesCellRange(valueRange);
				series[startNumeric].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				startNumeric++;
			}
			
			
			for(int i=0;i<rate.length;i++){
				String seriesTitle = rate[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[startRate].setSeriesTitle(seriesTitle); 
				series[startRate].setValuesCellRange(valueRange);
				series[startRate].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				startRate++;
			}
			
			removeEmptySeries(startNumeric,maxNumeric);
			removeEmptySeries(startRate,maxRate);
			
			for(int removeCellIndex = 0;removeCellIndex<=MAX_LINE_CHART_CNT+1;removeCellIndex++){
				removeCell(7, 7+6, removeCellIndex);
			}
			//for(int i=seriesIndex;i<series.length;i++){
				//charts[0].removeSeries(series[i]);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * Top N 
	 * @param chartIndex
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param chartTitle
	 */
	public void makeTopNChartData(int chartIndex,int sCol,int eCol,int sRow,int eRow,String chartTitle,List<Map> userRateList){
		try {
			String title = null;
			int row = sRow;
			double val = 0.0;
			double sumVal = 0.0;
			for(int i=0;i<userRateList.size();i++){
				Map userRateMap = userRateList.get(i);
				val = (Double)userRateMap.get("useRate");
				title = (String)userRateMap.get("pid") +" : "+(String)userRateMap.get("shortArgs");
				setCellValue(row, sCol, title);
				setCellValue(row, sCol+1, val);
				sumVal += val;
				row++;
			}
			//setCellValue(row,sCol,ResourceUtil.getApplicationMessage(StationConstants.RESOURCE_RES,"etc"));//resource등록.
			setCellValue(row,sCol+1,100.00-sumVal);//resource등록.
			
			HSSFSeries[] series = charts[chartIndex].getSeries();
			int seriesIndex = 0;
			CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, sCol, sCol);
			CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, eCol, eCol);
			series[seriesIndex].setSeriesTitle(chartTitle); 
			series[seriesIndex].setValuesCellRange(valueRange);
			series[seriesIndex].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
			charts[chartIndex].setChartTitle(chartTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 이벤트현황.
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param column
	 */
	public void makeEventStateChartData(int sCol,int eCol,int sRow,int eRow,String[] columns,int[] values){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			for(int i=0; i<series.length;i++){
				setCellValue(sRow+i,1,Double.valueOf(values[i]));
				series[i].setSeriesTitle(columns[i]);
				//series[i].setValuesCellRange(new CellRangeAddress(sRow+i, eRow+i, sCol, eCol));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeEmptySeries(int sRemoveIndex){
		HSSFSeries[] series = charts[0].getSeries();
		for(int i=sRemoveIndex;i<series.length;i++){
			charts[0].removeSeries(series[i]);
		}
	}
	
	public void removeEmptySeries(int sRemoveIndex, int maxRemoveIndex){
		HSSFSeries[] series = charts[0].getSeries();
		for(int i=sRemoveIndex;i<maxRemoveIndex;i++){
			boolean result = charts[0].removeSeries(series[i]);
		}
	}
	
	public void removeCell(int sRowIndex, int eRowIndex,int cellIndex){
		for(int i=sRowIndex;i<eRowIndex;i++){
			Row row = getRow(i);
			Cell cell = row.getCell(cellIndex);
			if(cell!=null)
				row.removeCell(cell);
		}
	}
	public void setChartTitle(String title){
		charts[0].setChartTitle(title);
	}
	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public Sheet getSheet() {
		return sheet;
	}
	
	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
	
	public void setSheet(int sheetIndex){
		if(workbook!=null)
			this.sheet = workbook.getSheetAt(sheetIndex);
	}
	
	public CellStyle createBorderCenterStyle(){
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setFont(getDefaultFont());
		return style;
	}
	
	/**
	 * BasicCenterBorderStyle
	 * @return
	 */
	public CellStyle getStyleDefaultCenter(){
		if(DEFAULT_CENTER==null)
			DEFAULT_CENTER = workbook.createCellStyle();
		DEFAULT_CENTER.setAlignment(CellStyle.ALIGN_CENTER);
		DEFAULT_CENTER.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		DEFAULT_CENTER.setBorderBottom(CellStyle.BORDER_THIN);
		DEFAULT_CENTER.setBorderLeft(CellStyle.BORDER_THIN);
		DEFAULT_CENTER.setBorderRight(CellStyle.BORDER_THIN);
		DEFAULT_CENTER.setBorderTop(CellStyle.BORDER_THIN);
		DEFAULT_CENTER.setFont(getDefaultFont());
		return DEFAULT_CENTER;
	}
	
	public Font getDefaultFont(){
		if(DEFAULT_FONT==null)
			DEFAULT_FONT = workbook.createFont();
		DEFAULT_FONT.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		DEFAULT_FONT.setFontName("돋움");
		DEFAULT_FONT.setFontHeightInPoints((short)(10));
		DEFAULT_FONT.setColor(HSSFColor.BLACK.index);
		return DEFAULT_FONT;
	}
	
	public Font getBoldWhiteFont(){
		if(BOLD_WHITE_FONT==null)
			BOLD_WHITE_FONT = workbook.createFont();
		BOLD_WHITE_FONT.setBoldweight(Font.BOLDWEIGHT_BOLD);
		BOLD_WHITE_FONT.setFontName("돋움");
		BOLD_WHITE_FONT.setFontHeightInPoints((short)10);
		BOLD_WHITE_FONT.setColor(HSSFColor.WHITE.index);
		return BOLD_WHITE_FONT;
	}
	
	public Font getBoldTitleFont(){
		if(BOLD_TITLE_FONT==null)
			BOLD_TITLE_FONT = workbook.createFont();
		BOLD_TITLE_FONT.setBoldweight(Font.BOLDWEIGHT_BOLD);
		BOLD_TITLE_FONT.setFontName("돋움");
		BOLD_TITLE_FONT.setFontHeightInPoints((short)16);
		BOLD_TITLE_FONT.setColor(HSSFColor.BLACK.index);
		return BOLD_TITLE_FONT;
	}
	
	/**
	 * BasicCenterBorderStyle
	 * @return
	 */
	public CellStyle getStyleDefaultLeft(){
		if(DEFAULT_LEFT==null)
			DEFAULT_LEFT = workbook.createCellStyle();
		DEFAULT_LEFT.setAlignment(CellStyle.ALIGN_LEFT);
		DEFAULT_LEFT.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		DEFAULT_LEFT.setBorderBottom(CellStyle.BORDER_THIN);
		DEFAULT_LEFT.setBorderLeft(CellStyle.BORDER_THIN);
		DEFAULT_LEFT.setBorderRight(CellStyle.BORDER_THIN);
		DEFAULT_LEFT.setBorderTop(CellStyle.BORDER_THIN);
		DEFAULT_LEFT.setFont(getDefaultFont());
		return DEFAULT_LEFT;
	}
	
	/**
	 * BasicCenterBorderStyle
	 * @return
	 */
	public CellStyle getStyleDefaultRight(){
		if(DEFAULT_RIGHT==null)
			DEFAULT_RIGHT = workbook.createCellStyle();
		DEFAULT_RIGHT.setAlignment(CellStyle.ALIGN_RIGHT);
		DEFAULT_RIGHT.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		DEFAULT_RIGHT.setBorderBottom(CellStyle.BORDER_THIN);
		DEFAULT_RIGHT.setBorderLeft(CellStyle.BORDER_THIN);
		DEFAULT_RIGHT.setBorderRight(CellStyle.BORDER_THIN);
		DEFAULT_RIGHT.setBorderTop(CellStyle.BORDER_THIN);
		DEFAULT_RIGHT.setFont(getDefaultFont());
		return DEFAULT_RIGHT;
	}
	
	/**
	 * GrayRightTitleStyle
	 * @return
	 */
	public CellStyle getStyleGrayRightTitle(){
		if(GRAY_RIGHT==null)
			GRAY_RIGHT = workbook.createCellStyle();
		GRAY_RIGHT.setAlignment(CellStyle.ALIGN_RIGHT);
		GRAY_RIGHT.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		GRAY_RIGHT.setBorderBottom(CellStyle.BORDER_MEDIUM);
		GRAY_RIGHT.setBorderLeft(CellStyle.BORDER_MEDIUM);
		GRAY_RIGHT.setBorderRight(CellStyle.BORDER_MEDIUM);
		GRAY_RIGHT.setBorderTop(CellStyle.BORDER_MEDIUM);
		
		GRAY_RIGHT.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		GRAY_RIGHT.setFillPattern(CellStyle.SOLID_FOREGROUND);
		GRAY_RIGHT.setFont(getBoldWhiteFont());
		return GRAY_RIGHT;
	}
	
	/**
	 * GrayRightTitleStyle
	 * @return
	 */
	public CellStyle getStyleGrayCenterTitle(){
		if(GRAY_CENTER==null)
			GRAY_CENTER = workbook.createCellStyle();
		GRAY_CENTER.setAlignment(CellStyle.ALIGN_CENTER);
		GRAY_CENTER.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		GRAY_CENTER.setBorderBottom(CellStyle.BORDER_MEDIUM);
		GRAY_CENTER.setBorderLeft(CellStyle.BORDER_MEDIUM);
		GRAY_CENTER.setBorderRight(CellStyle.BORDER_MEDIUM);
		GRAY_CENTER.setBorderTop(CellStyle.BORDER_MEDIUM);
		
		GRAY_CENTER.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		GRAY_CENTER.setFillPattern(CellStyle.SOLID_FOREGROUND);
		GRAY_CENTER.setFont(getBoldWhiteFont());
		return GRAY_CENTER;
	}
	
	/**
	 * getTopCenterTitleCellStyle
	 * @return
	 */
	public CellStyle getStyleTopCenterTitle(){
		if(DEFAULT_TITLE_CENTER==null)
			DEFAULT_TITLE_CENTER = workbook.createCellStyle();
		DEFAULT_TITLE_CENTER.setAlignment(CellStyle.ALIGN_CENTER);
		DEFAULT_TITLE_CENTER.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		DEFAULT_TITLE_CENTER.setBorderBottom(CellStyle.BORDER_THIN);
		DEFAULT_TITLE_CENTER.setBorderLeft(CellStyle.BORDER_THIN);
		DEFAULT_TITLE_CENTER.setBorderRight(CellStyle.BORDER_THIN);
		DEFAULT_TITLE_CENTER.setBorderTop(CellStyle.BORDER_THIN);
		
		DEFAULT_TITLE_CENTER.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		DEFAULT_TITLE_CENTER.setFont(getBoldTitleFont());
		return DEFAULT_TITLE_CENTER;
	}
	
	public Sheet createSheet(String sheetName){
		Sheet sheet = workbook.createSheet(sheetName);
		this.sheet = sheet;
		return sheet;
	}
	
	public void setColumnWidth(int sColIndex, int eColIndex,int width){
		if(sheet!=null){
			for(int i=sColIndex;i<=eColIndex;i++){
				sheet.setColumnWidth(i, width*256);
			}
		}
	}
	
	public void setColumnWidth(int colIndex, int width){
		if(sheet!=null){
			sheet.setColumnWidth(colIndex, width*256);
		}
	}
	
	public String getCellStringValue(int rowIndex, int cellIndex){
		String returnValue = null;
		Cell cell = getCell(rowIndex,cellIndex);
		int cellType = cell.getCellType();
		switch(cellType){
			case Cell.CELL_TYPE_BOOLEAN : returnValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC : returnValue = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING : returnValue = cell.getStringCellValue();
				break;
			//default :	returnValue = "";
					//break;
		}
		return returnValue;
	}
	
	public Date getCellDateValue(int rowIndex, int cellIndex){
		Cell cell = getCell(rowIndex,cellIndex);
		return cell.getDateCellValue();
	}
	
	public String getSheetName(){
		String sheetName = "";
		if(sheet!=null)
			sheetName = sheet.getSheetName();
		return sheetName;
	}
	
	public int getLastCellNum(int rowIndex){
		Row row = getRow(rowIndex);
		return row.getLastCellNum();
	}
	
	public int getLastRowNum(){
		int lastRowNum = 0;
		if(sheet!=null)
			lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}

	public int getNumberOfSheets() {
		int numberOfSheets = 0;
		if(workbook!=null)
			numberOfSheets = workbook.getNumberOfSheets();
		return numberOfSheets;
	}
	
	public void setSheetName(int sheetNumber, String sheetName){
		if(workbook!=null){
			workbook.setSheetName(sheetNumber, sheetName);
		}
	}
	public void setHiddenSheet(int sheetNumber){
		if(workbook!=null){
			workbook.setSheetHidden(sheetNumber, true);
		}
	}
	public void makeBarChartMTBFData(int row, int cC, int dC, List column){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			int seriesIndex = 0;
			int maxSeriesIndex = MAX_BAR_CHART_MTBF_CNT;
			for(int i=0;i<column.size();i++){
				//HSSFSeries serie = charts[0].createSeries();
				HSSFSeries s = series[seriesIndex];
				String seriesTitle = (String) column.get(i);
				CellRangeAddress categoryLabelRange = new CellRangeAddress(row, row, cC, cC);
				CellRangeAddress valueRange = new CellRangeAddress(row, row, dC, dC);
				s.setSeriesTitle(seriesTitle); 
				s.setValuesCellRange(valueRange);
				s.setCategoryLabelsCellRange(categoryLabelRange);
				row++;
				seriesIndex++;
			}
			
			removeEmptySeries(seriesIndex,maxSeriesIndex);
			
			for(int removeCellIndex = 0;removeCellIndex<=MAX_BAR_CHART_MTBF_CNT+1;removeCellIndex++){
				removeCell(7, 7+3, removeCellIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 다중항목 차트 생성.
	 * @param sCol
	 * @param eCol
	 * @param sRow
	 * @param eRow
	 * @param column
	 */
	public void makeRelatationChartData(int sCol,int eCol,int sRow,int eRow, String[] numeric,String[] rate){
		try {
			HSSFSeries[] series = charts[0].getSeries();
			
			//int startRate = START_MULTIPLE_RATE;
			//int maxRate = MAXSIZE_MULTIPLE_RATE;
			if(numeric.length > 50 || rate.length > 50)
				log.error("[POIExcelUtil.makeRelatationChartData] Chart Series Overflow - Numeric = "+numeric.length+", Rate = "+rate.length);
			int numericSeriesIndex = 0;
			for(int i=0;i<numeric.length;i++){
				String seriesTitle = numeric[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[numericSeriesIndex].setSeriesTitle(seriesTitle); 
				series[numericSeriesIndex].setValuesCellRange(valueRange);
				series[numericSeriesIndex].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				numericSeriesIndex++;
			}
			
			int rateSeriesIndex = 50;
			for(int i=0;i<rate.length;i++){
				String seriesTitle = rate[i];
				CellRangeAddress categoryLabelRange = new CellRangeAddress(sRow, eRow, 0, 0);
				CellRangeAddress valueRange = new CellRangeAddress(sRow, eRow, sCol, eCol);
				
				series[rateSeriesIndex].setSeriesTitle(seriesTitle); 
				series[rateSeriesIndex].setValuesCellRange(valueRange);
				series[rateSeriesIndex].setCategoryLabelsCellRange(categoryLabelRange);//가로축 설정.
				sCol++;
				eCol++;
				rateSeriesIndex++;
			}
			
			removeEmptySeries(numericSeriesIndex,50);
			removeEmptySeries(rateSeriesIndex,100);
			for(int removeCellIndex = 0;removeCellIndex<=MAX_LINE_CHART_CNT+1;removeCellIndex++){
				removeCell(7, 7+6, removeCellIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCellValue(int rowIndex, int cellIndex){
		Cell cell = getRow(rowIndex).getCell(cellIndex);
		return cell.getStringCellValue();
	}
	
}