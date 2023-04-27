package com.moohee.wboard.dto;

import java.sql.Timestamp;

public class WMemberDto {
	
	private String mid; //ȸ�� ���̵�
	private String mpw; //ȸ�� ��й�ȣ
	private String mname; //ȸ�� �̸�
	private String memail; //ȸ�� �̸���
	private Timestamp mdate; //ȸ�� ����Ͻ�
	
	public WMemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WMemberDto(String mid, String mpw, String mname, String memail, Timestamp mdate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mdate = mdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Timestamp getMdate() {
		return mdate;
	}
	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}
	
}
