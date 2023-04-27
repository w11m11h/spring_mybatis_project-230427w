package com.moohee.wboard.dto;

import java.sql.Timestamp;

public class WBoardDto {
	private int wnum; //�Խñ� ��ȣ(�⺻Ű)
	private String wid; //�Խ��� ���̵�
	private String wname; //�Խ��� �̸�
	private String wtitle; //�Խñ� ����
	private String wcontent; //�Խñ� ����
	private String whit; //�Խñ� ��ȸ��
	private Timestamp wdate; //�Խù� ����Ͻ�
	
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
