package com.moohee.wboard.dao;

public interface IDao {
	
	public void joinMemberDao(String mid, String mpw, String mname, String email); //ȸ�� ����
	public int checkIdDao(String mid); //ȸ�����Կ��� üũ(���̵� �ߺ����� üũ)
	public int checkIdPwDao(String mid, String mpw); //ȸ�����̵�� ��й�ȣ ��ġ���� üũ
	
}
