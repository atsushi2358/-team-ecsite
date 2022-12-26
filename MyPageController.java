package jp.co.internous.utopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.utopia.model.domain.MstUser;
import jp.co.internous.utopia.model.mapper.MstUserMapper;
import jp.co.internous.utopia.model.session.LoginSession;

@Controller
@RequestMapping("/utopia/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private  LoginSession loginSession;
		
	@RequestMapping("/")
	public String index(Model model) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
	
		model.addAttribute("user", user);
		model.addAttribute("loginSession", loginSession);
	
		return "my_page";
	}
}