package org.food.persistence;

import org.food.domain.MemberVO;

public interface MemberDAO {
	
	public void insertMember(MemberVO vo);
	
	public String checkId(String c_id);
	
	public String checkKakao(String k_id);
	
	

}
