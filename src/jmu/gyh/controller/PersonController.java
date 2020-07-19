package jmu.gyh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jmu.gyh.po.Person;
import jmu.gyh.service.PersonService;

@Controller
public class PersonController {

	@Resource(name = "personServiceImpl")
	private PersonService personService;

	@RequestMapping(value = "/findPerByPersonId.do")
	public String findPerByPersonId(String personId, Model model) {
		Person per = this.personService.findPerByPersonId(personId);
		model.addAttribute("person", per);
		return "perShow";
	}

	@RequestMapping(value = "/adminLoginCheck.do")
	public String adminLoginCheck(String personId, String password, Model model) {
		String path = "admin";
		try {
			Person per = this.personService.findPerByPersonId(personId);
			if (per.getPassword().equals(password)) {
				path = "admin/queryProduct";
				model.addAttribute("admin", per);
			} else {
				model.addAttribute("err", "错误的管理员ID及密码!!!");
			}
		} catch (Exception e) {
			model.addAttribute("err", "错误的管理员ID及密码!!!");
			e.printStackTrace();
		}
		return path;
	}
	
	@RequestMapping(value = "/userLoginCheck.do")
	public String userLoginCheck(String personId, String password, Model model) {
		String path = "mainPage";
		try {
			Person per = this.personService.findPerByPersonId(personId);
			if (per.getPassword().equals(password)) {
				path = "queryProduct";
				model.addAttribute("daoliancheck", "OK");
				model.addAttribute("user", per);
			} else {
				model.addAttribute("err", "错误的用户ID及密码!!!");
			}
		} catch (Exception e) {
			model.addAttribute("err", "错误的用户ID及密码!!!");
			e.printStackTrace();
		}
		return path;
	}
}
