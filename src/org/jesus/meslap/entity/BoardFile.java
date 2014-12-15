package org.jesus.meslap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name="CMM_BOARD_FILE")
public class BoardFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BoardFile() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardFile(String path, String fileName, Board board) {
		// TODO Auto-generated constructor stub
		this.filePath = path;
		this.fileName = fileName;
		this.board = board;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String filePath;
	
	@Getter @Setter
	private String fileName;
	
	@ManyToOne
	private Board board;
	
}
