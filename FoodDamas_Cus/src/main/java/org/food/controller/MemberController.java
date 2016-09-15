package org.food.controller;

import java.awt.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.food.domain.MemberVO;
import org.food.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET( Model model) {
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerPOST( MemberVO vo ) {
		logger.info("회원가입 POST");
		System.out.println(vo);
		service.insertMember(vo);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public String checkIdPOST(@RequestBody String c_id) {//requestBody는 vo가아닐떄
		logger.info(""+service.checkId(c_id));
		return service.checkId(c_id);
		
	}
	
/*	
	@ResponseBody
	@RequestMapping(value = "/registerKakao", method = RequestMethod.POST)
	public String kakaoPOST(MemberVO vo) {
		logger.info(""+vo);
			String k_id=service.checkKakao(k_id)
		if(result==null){
			return "redirect:/member/register";
		}
		//return service.checkKakao(vo.getK_id());
		System.out.println(result);
		return service.checkKakao(vo.getK_id());
	}*/
	
	
	@ResponseBody
	@RequestMapping(value = "/registerKakao/", method = RequestMethod.GET)
	public void kakaoGET(MemberVO vo, Model model ) {
		logger.info("왜겟으로 안사라져");
	/*	logger.info("여기fff는 겟"+vo);
		
		service.checkId(vo.getK_id());

		//return service.checkKakao(vo.getK_id());
*/	}
}
