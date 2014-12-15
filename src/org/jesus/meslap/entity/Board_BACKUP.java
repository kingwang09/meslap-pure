package org.jesus.meslap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

//@Entity
//@Table(name="CMM_BOARD")
public class Board_BACKUP implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String BOARD_FOLDER = "meslapFiles";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private int id;
	
	@Column(name="BOARD_CODE",nullable=false)
	@Getter @Setter
	private String boardCode;
	
	@Getter @Setter
	private String title;
	
	@Getter @Setter
	private String content;
	
	@Getter @Setter
	private Date wdate;
	
	@Getter @Setter
	private Date mdate;
	
	@Getter @Setter
	private String writer;
	
	//fetch=Eager 과 Lazy차이점 알아보기.
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy="board", fetch=FetchType.EAGER)
	@Getter @Setter
	private Set<BoardFile> files;
	
	@Transient
	@Getter @Setter
	private MultipartFile[] logicalFiles;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BOARD_CODE", insertable = false, updatable = false)
	@Getter @Setter
	private BoardAdmin boardAdmin;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("Board[boardCode=").append(boardCode)
			.append(", id=").append(id)
			.append(", title=").append(title)
			.append("]");
		ArrayList<String> a = new ArrayList<String>();
		return sb.toString();
	}
}
