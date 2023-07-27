package jp.co.internous.sunflower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sunflower.model.domain.MstUser;
import jp.co.internous.sunflower.model.mapper.MstUserMapper;
import jp.co.internous.sunflower.model.session.LoginSession;

/**
 * マイページに関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/sunflower/mypage")
public class MyPageController {
	
	/*
	 * フィールド定義
	 */
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * マイページ画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return マイページ画面
	 */
	
	@RequestMapping("/")
	public String index(Model m) {
		
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		//マイページにユーザー情報を表示
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		
		return "my_page";
		
	}
	
}
