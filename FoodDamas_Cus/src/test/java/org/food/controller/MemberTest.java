package org.food.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.food.domain.MemberVO;
import org.food.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**.xml" })
public class MemberTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void insertMember() {
		MemberVO vo=new MemberVO();
		vo.setC_id("lk1y");
		vo.setC_pw("123123");
		vo.setC_name("131");
		vo.setC_phone("010999123999999");
		vo.setC_mail("lky-1991@hanmail.net");
		dao.insertMember(vo);
		
	}
	@Test
	public void insertkakaoMember() {
		MemberVO vo=new MemberVO();
		vo.setC_id("lky1234");
		vo.setC_pw("123");
		vo.setC_name("¿Ã∞°øµ123");
		vo.setC_phone("010999999999");
		vo.setC_mail("lky-1991@hanmail.net");
		vo.setK_id("1");
		vo.setK_nick("1");
		vo.setThumb_img("1");
		vo.setProfile_img("1");
		dao.insertKakaoMember(vo);
		
	}

}
