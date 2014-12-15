package org.jesus.meslap.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="CMM_WORSHIP")
public class Worship {
	public static final String WORSHIP_FOLDER = "worshipFiles";
	public static final String WORSHIP_IMPORT_FOLDER = "worshipImport";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer id;
	
	/**
	 * 본문말씀 index
	 */
	@Column(length=200)
	@Getter @Setter
	private String category;
	
	/**
	 * 설교제목
	 */
	@Column
	@Getter @Setter
	private String title;
	
	/**
	 * 본문말씀 index
	 */
	@Column(length=200)
	@Getter @Setter
	private String bibleIndex;
	
	/**
	 * 본문말씀
	 */
	@Column(length=2000)
	@Getter @Setter
	private String bible;
	
	/**
	 * 암송말씀 index
	 */
	@Column(length=200)
	@Getter @Setter
	private String recitationBibleIndex;
	
	/**
	 * 암송말씀
	 */
	@Column(length=2000)
	@Getter @Setter
	private String recitationBible;
	
	
	
	/**
	 * 파일 저장경로
	 */
	@Column(name="FILE_PATH")
	@Getter @Setter
	private String filePath;
	
	/**
	 * 오디오 파일명
	 */
	@Column(name="AUDIO_FILE_NAME")
	@Getter @Setter
	private String audioFileName;
	
	/**
	 * 오디오 파일(Logic)
	 */
	@Transient
	@Getter @Setter
	private MultipartFile audioFile;
	
	/**
	 * 텍스트 파일(PDF)명
	 */
	@Column(name="TEXT_FILE_NAME")
	@Getter @Setter
	private String textFileName;//PDF파일일거임.
	
	/**
	 * 텍스트파일(PDF) 실제파일
	 */
	@Transient
	@Getter @Setter
	private MultipartFile textFile;
	
	/**
	 * 주보 01 파일명
	 */
	@Column(name="JUBO_FILE_NAME01")
	@Getter @Setter
	private String juboFileName01;
	@Transient
	@Getter @Setter
	private MultipartFile juboFile01;
	
	@Column(name="JUBO_FILE_NAME02")
	@Getter @Setter
	private String juboFileName02;
	@Transient
	@Getter @Setter
	private MultipartFile juboFile02;
	
	@Column(name="JUBO_FILE_NAME03")
	@Getter @Setter
	private String juboFileName03;
	@Transient
	@Getter @Setter
	private MultipartFile juboFile03;
	
	@Column(name="YOUTUBE_URL")
	@Getter @Setter
	private String youtubeUrl;
	
	@Column(name="VIDEO_IMAGE_FILE_NAME")
	@Getter @Setter
	private String videoImageFileName;
	
	@Transient
	@Getter @Setter
	private MultipartFile videoImage;
	
	@Column(name="MAIN_VIDEO_IMAGE_FILE_NAME")
	@Getter @Setter
	private String mainVideoImageFileName;
	
	@Transient
	@Getter @Setter
	private MultipartFile mainVideoImage;
	
	@Column(name="MAIN_BIBLE_IMAGE_FILE_NAME")
	@Getter @Setter
	private String mainBibleImageFileName;
	
	@Transient
	@Getter @Setter
	private MultipartFile mainBibleImage;
	
	@Column
	@Getter @Setter
	private Date wdate;
	
	/**
	 * Title Image <NotUsed>
	 */
	@Column(name="TITLE_IMAGE_FILE_NAME")
	@Getter @Setter
	private String titleImageFileName;
	
	/**
	 * Title Image File<NotUsed>
	 */
	@Transient
	@Getter @Setter
	private MultipartFile titleImageFile; 
	
	public String getWdateStr(){
		if(wdate==null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(wdate);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("Worship("+id+")["+title+"]");
		return sb.toString();
	}
	
	@Column(name="MAIN_WORSHIP_FILE_NAME")
	@Getter @Setter
	private String mainWorshipFileName;
	@Transient
	@Getter @Setter
	private MultipartFile mainWorshipFile;
	
	@Column(name="SUB_WORSHIP_FILE_NAME")
	@Getter @Setter
	private String subWorshipFileName;
	@Transient
	@Getter @Setter
	private MultipartFile subWorshipFile;
	
	@Column(name="TITLE_WORSHIP_FILE_NAME")
	@Getter @Setter
	private String titleWorshipFileName;
	
	@Transient
	@Getter @Setter
	private MultipartFile titleWorshipFile;
}
