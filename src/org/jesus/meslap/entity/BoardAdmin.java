package org.jesus.meslap.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name="CMM_BOARD_ADMIN")
public class BoardAdmin {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Getter @Setter
//	private int id;
	
	@Column(name="BOARD_TITLE")
	@Getter @Setter
	private String boardTitle;
	
	@Id
	@Column(name="BOARD_CODE")
	@Getter @Setter
	private String boardCode;
	
	@Column(length=2000)
	@Getter @Setter
	private String description;
	
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy="boardAdmin")
	@Getter @Setter
	private List<Board> boards;
	
	@Getter @Setter
	private Date wdate;
	
	@Transient
	@Getter @Setter
	private String errorMessage;
	
}
