package org.food.service;

import javax.inject.Inject;

import org.food.domain.MemberVO;
import org.food.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO dao;
	@Override
	public void insertMember(MemberVO vo) {

		dao.insertMember(vo);
	}
	@Override
	public String checkId(String c_id) {
		// TODO Auto-generated method stub
		return dao.checkId(c_id);
	}
	@Override
	public String checkKakao(String k_id) {
		// TODO Auto-generated method stub
		return dao.checkKakao(k_id);
	}

}
