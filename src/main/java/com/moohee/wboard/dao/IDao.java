package com.moohee.wboard.dao;

import com.moohee.wboard.dto.WMemberDto;

public interface IDao {
	
	//��� ����
	public void joinMemberDao(String mid, String mpw, String mname, String email); //ȸ�� ����
	public int checkIdDao(String mid); //ȸ�����Կ��� üũ(���̵� �ߺ����� üũ)
	public int checkIdPwDao(String mid, String mpw); //ȸ�����̵�� ��й�ȣ ��ġ���� üũ
	
	//�Խ��� ����
	public WMemberDto getMemberInfo(String mid); //���̵�� �˻��Ͽ� ȸ������ ��������
	public void writeDao(String mid, String mname, String wtitle, String wcontent); //�Խ��� �۾���
}
