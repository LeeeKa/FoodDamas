package org.food.service;

import org.food.domain.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO vo);
	
	public String checkId(String c_id);
	
	//īī���� ȸ������
	public String checkKakao(String k_id);


}
