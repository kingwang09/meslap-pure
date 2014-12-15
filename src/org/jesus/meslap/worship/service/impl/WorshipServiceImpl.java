package org.jesus.meslap.worship.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.jesus.meslap.entity.Worship;
import org.jesus.meslap.util.ExcelUtil;
import org.jesus.meslap.worship.dao.WorshipDAO;
import org.jesus.meslap.worship.service.WorshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WorshipServiceImpl implements WorshipService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WorshipDAO worshipDao;
	
	@Transactional
	public List<Worship> getWorships(Integer fRow, Integer pageSize){
		return worshipDao.getWorships(fRow, pageSize);
	}
	
	private String getSavedImageFileName(MultipartFile file){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(new Date());
		return currentDate+"_"+file.getOriginalFilename();
	}
	
	private String writeFile(String path, MultipartFile file) throws IllegalStateException, IOException{
		if(file!=null && file.getSize()>0){
			String savedFileName = getSavedImageFileName(file);
			//worship.setMainBibleImageFileName(savedImageFileName);
			file.transferTo(new File(path+File.separator+savedFileName));
			return savedFileName;
		}
		return null;
	}
	
	private String updateFile(String path, MultipartFile newfile, String oldFileName) throws IllegalStateException, IOException{
		if(newfile!=null && newfile.getSize()>0){
			deleteFile(path, oldFileName);
			String savedFileName = getSavedImageFileName(newfile);
			//worship.setMainBibleImageFileName(savedImageFileName);
			newfile.transferTo(new File(path+File.separator+savedFileName));
			return savedFileName;
		}
		return oldFileName;
	}
	
	@Transactional
	public void write(String path, Worship worship){
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdir();
		
		try {
			
			//Main Bible Image File
			MultipartFile mainBibleImageFile = worship.getMainBibleImage();
			worship.setMainBibleImageFileName(writeFile(path, mainBibleImageFile));
			
			
			//Main Video Image File
			MultipartFile mainVideoImageFile = worship.getMainVideoImage();
			worship.setMainVideoImageFileName(writeFile(path, mainVideoImageFile));
			
			
			//Video Image File
			MultipartFile videoImageFile = worship.getVideoImage();
			worship.setVideoImageFileName(writeFile(path, videoImageFile));
			
			//Audio File
			MultipartFile audioFile = worship.getAudioFile();
			worship.setAudioFileName(writeFile(path, audioFile));
			
			//Text File
			MultipartFile textFile = worship.getTextFile();
			worship.setTextFileName(writeFile(path, textFile));
			
			//Jubo File 1~3
			MultipartFile juboFile01 = worship.getJuboFile01();
			worship.setJuboFileName01(writeFile(path, juboFile01));
			
			MultipartFile juboFile02 = worship.getJuboFile02();
			worship.setJuboFileName01(writeFile(path, juboFile02));
			
			MultipartFile juboFile03 = worship.getJuboFile01();
			worship.setJuboFileName03(writeFile(path, juboFile03));
			
			//Main Image
			MultipartFile mainWorship = worship.getMainWorshipFile();
			worship.setMainWorshipFileName(writeFile(path, mainWorship));
			
			MultipartFile subWorship = worship.getSubWorshipFile();
			worship.setSubWorshipFileName(writeFile(path, subWorship));
			
			MultipartFile titleWorship = worship.getTitleWorshipFile();
			worship.setTitleWorshipFileName(writeFile(path, titleWorship));
			
			worship.setWdate(new Date());
			worshipDao.save(worship);
		} catch (IllegalStateException e) {
			log.error("WorshipService.write Error 01. \n"+e.getMessage());
		} catch (IOException e) {
			log.error("WorshipService.write Error 02. \n"+e.getMessage());
		}
	}
	
	
	
	@Transactional
	public void update(String path, Worship worship) {
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdir();
		Worship beforeWorship = getWorship(worship.getId());
		try {
			//Main Bible Image File
			MultipartFile mainBibleImageFile = worship.getMainBibleImage();
			String oldMainBibleImageFileName = beforeWorship.getMainBibleImageFileName();
			worship.setMainBibleImageFileName(updateFile(path, mainBibleImageFile, oldMainBibleImageFileName));
			
			//Main Video Image File
			worship.setMainVideoImageFileName(updateFile(path, worship.getMainVideoImage(), beforeWorship.getMainVideoImageFileName()));
			
			
			//Video Image File
			worship.setVideoImageFileName(updateFile(path, worship.getVideoImage(), beforeWorship.getVideoImageFileName()));
			
			
			//Audio File
			worship.setAudioFileName(updateFile(path, worship.getAudioFile(), beforeWorship.getAudioFileName()));
			
			//Text File
			worship.setAudioFileName(updateFile(path, worship.getTextFile(), beforeWorship.getTextFileName()));
			
			
			//Jubo File 1~3
			worship.setJuboFileName01(updateFile(path, worship.getJuboFile01(), beforeWorship.getJuboFileName01()));
			worship.setJuboFileName02(updateFile(path, worship.getJuboFile02(), beforeWorship.getJuboFileName02()));
			worship.setJuboFileName03(updateFile(path, worship.getJuboFile03(), beforeWorship.getJuboFileName03()));
			
			//Main
			worship.setMainWorshipFileName(updateFile(path, worship.getMainWorshipFile(), beforeWorship.getMainWorshipFileName()));
			worship.setSubWorshipFileName(updateFile(path, worship.getSubWorshipFile(), beforeWorship.getSubWorshipFileName()));
			worship.setTitleWorshipFileName(updateFile(path, worship.getTitleWorshipFile(), beforeWorship.getTitleWorshipFileName()));
			
			worship.setWdate(new Date());
			//worshipDao.save(worship);
			worshipDao.merge(worship);
		} catch (IllegalStateException e) {
			log.error("WorshipService.write Error 01. \n"+e.getMessage());
		} catch (IOException e) {
			log.error("WorshipService.write Error 02. \n"+e.getMessage());
		}
	}
	
	@Transactional
	public Worship getWorship(Integer id) {
		return worshipDao.getWorship(id);
	}
	
	private void deleteFile(String path, String fileName){
		if(fileName == null)
			return;
		
		File file = new File(path+File.separator+fileName);
		if(file!=null && file.exists()){
			file.delete();
		}
	}
	
	@Transactional
	public void delete(String path, Integer id) {
		Worship w = worshipDao.getWorship(id);
		//Main Bible Image File
		deleteFile(path, w.getMainBibleImageFileName());
		//Main Video Image File
		deleteFile(path, w.getMainVideoImageFileName());
		//Video Image File
		deleteFile(path, w.getVideoImageFileName());
		//Audio File
		deleteFile(path, w.getAudioFileName());
		//Text File
		deleteFile(path, w.getTextFileName());
		
		//Jubo File01
		deleteFile(path, w.getJuboFileName01());
		//Jubo File02
		deleteFile(path, w.getJuboFileName02());
		//Jubo File03
		deleteFile(path, w.getJuboFileName03());
		
		deleteFile(path, w.getMainWorshipFileName());
		deleteFile(path, w.getSubWorshipFileName());
		deleteFile(path, w.getTitleWorshipFileName());
		worshipDao.delete(id);
	}
	@Transactional
	public Integer getWorshipCount() {
		return worshipDao.getWorshipCount();
	}
	
	@Transactional
	public Worship getRecentWorship() {
		return worshipDao.getRecentWorship();
	}
	
	@Transactional
	public void importExcelToDB(String path, String fileName){
		// TODO Auto-generated method stub
		List<Worship> importWorships = new ArrayList<Worship>();
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		final int DATE_IDX = 0,CATEGORY_IDX = 1, TITLE_IDX = 2, BIBLE_INDEX_IDX = 3, BIBLE_IDX=4, REPEAT_INDEX_IDX=5, 
				REPEAT_IDX=6, JUBO01_IDX=7,JUBO02_IDX=8,JUBO03_IDX=9,YOUTUBE_IDX=10,
				AUDIO_IDX=11, TEXT_IDX=12, VIDEO_IDX=13, MAIN_VIDEO_IDX=14, MAIN_BIBLE_IDX=15;
		
		ExcelUtil eUtil = new ExcelUtil(path, fileName);
		int endRow = eUtil.getLastRowNum();
		for(int rowIndex=1; rowIndex<=endRow;rowIndex++){
			Row row = eUtil.getRow(rowIndex);
			int lastCellIndex = row.getLastCellNum();
			Worship worship = new Worship();
			for(int cellIndex=0;cellIndex<=lastCellIndex;cellIndex++){
				String value = null;
				value = eUtil.getCellStringValue(rowIndex, cellIndex);
				switch(cellIndex){
					case DATE_IDX : 
						//Date date = sdf.parse(value);
						Date date = eUtil.getCellDateValue(rowIndex,cellIndex);
						worship.setWdate(date);
						break;
					case CATEGORY_IDX :
						worship.setCategory(value);
						break;
					case TITLE_IDX :
						worship.setTitle(value);
						break;
					case BIBLE_INDEX_IDX :
						worship.setBibleIndex(value);
						break;
					case BIBLE_IDX :
						worship.setBible(value);
						break;
					case REPEAT_INDEX_IDX :
						worship.setRecitationBibleIndex(value);
						break;
					case REPEAT_IDX :
						worship.setRecitationBible(value);
						break;
					case JUBO01_IDX :
						worship.setJuboFileName01(value);
						break;
					case JUBO02_IDX :
						worship.setJuboFileName02(value);
						break;
					case JUBO03_IDX :
						worship.setJuboFileName03(value);
						break;
					case YOUTUBE_IDX :
						worship.setYoutubeUrl(value);
						break;
					case AUDIO_IDX :
						worship.setAudioFileName(value);
						break;
					case TEXT_IDX :
						worship.setTextFileName(value);
						break;
					case VIDEO_IDX :
						worship.setVideoImageFileName(value);
						break;
					case MAIN_VIDEO_IDX :
						worship.setMainVideoImageFileName(value);
						break;
					case MAIN_BIBLE_IDX :
						worship.setMainBibleImageFileName(value);
						break;
						
				}
			}//end Cell for
			importWorships.add(worship);//dev
		}
		log.info("Import worships : "+importWorships.size());
		for(Worship w : importWorships){
			log.debug(w.toString());
			worshipDao.save(w);
		}
	}
	
	@Transactional
	public Integer getRecentWorshipId() {
		return worshipDao.getRecentWorshipId();
	}
	
	@Transactional
	public List<String> getCateogrys() {
		return worshipDao.getCategorys();
	}

}
