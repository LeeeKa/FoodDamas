package org.food.persistence;

import javax.inject.Inject;

import org.food.domain.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSessionTemplate sqlsession;
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlsession.insert("org.food.persistence.MemberMapper.insertMember", vo);
		

	}

	@Override
	public String checkId(String c_id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("org.food.persistence.MemberMapper.checkId", c_id);

	}

	@Override
	public String checkKakao(String k_id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("org.food.persistence.MemberMapper.checkKakao", k_id);
	}

}
