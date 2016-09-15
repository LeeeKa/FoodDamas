package org.food.service;

import org.food.domain.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO vo);
	
	public String checkId(String c_id);
	
	//카카오톡 회원가입
	public String checkKakao(String k_id);


}
