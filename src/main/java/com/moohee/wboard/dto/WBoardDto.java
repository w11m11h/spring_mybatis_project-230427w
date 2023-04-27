package com.moohee.wboard.dto;

import java.sql.Timestamp;

public class WBoardDto {
	private int wnum; //게시글 번호(기본키)
	private String wid; //게시자 아이디
	private String wname; //게시자 이름
	private String wtitle; //게시글 제목
	private String wcontent; //게시글 내용
	private String whit; //게시글 조회수
	private Timestamp wdate; //게시물 등록일시
	
	public WBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WBoardDto(int wnum, String wid, String wname, String wtitle, String wcontent, String whit, Timestamp wdate) {
		super();
		this.wnum = wnum;
		this.wid = wid;
		this.wname = wname;
		this.wtitle = wtitle;
		this.wcontent = wcontent;
		this.whit = whit;
		this.wdate = wdate;
	}
	public int getWnum() {
		return wnum;
	}
	public void setWnum(int wnum) {
		this.wnum = wnum;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWtitle() {
		return wtitle;
	}
	public void setWtitle(String wtitle) {
		this.wtitle = wtitle;
	}
	public String getWcontent() {
		return wcontent;
	}
	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}
	public String getWhit() {
		return whit;
	}
	public void setWhit(String whit) {
		this.whit = whit;
	}
	public Timestamp getWdate() {
		return wdate;
	}
	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	
	
}
