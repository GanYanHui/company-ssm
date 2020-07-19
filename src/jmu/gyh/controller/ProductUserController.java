package jmu.gyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jmu.gyh.po.Message;
import jmu.gyh.po.Product;
import jmu.gyh.po.Revert;
import jmu.gyh.service.MessageService;
import jmu.gyh.service.ProductService;
import jmu.gyh.service.RevertService;

@Controller
@RequestMapping(value = "/user")
public class ProductUserController {
	
	@Resource(name = "productServiceImpl")
	private ProductService productService;

	@Resource(name = "messageServiceImpl")
	private MessageService messageService;

	@Resource(name = "revertServiceImpl")
	private RevertService revertService;

	@RequestMapping(value = "/findProByProductID.do")
	public String findProByProductID(int productID, Model model) {
		Product pro = this.productService.findProByProductID(productID);
		model.addAttribute("product", pro);
		return "detailProduct";
	}

	@RequestMapping(value = "/findAllPro.do")
	public String findAllPro(Model model) {
		List<Product> listPro = this.productService.findAllPro();
		List<Message> listMes = this.messageService.findAllMes();
		model.addAttribute("listPro", listPro);
		model.addAttribute("listMes", listMes);
		return "allProducts";
	}
	
	@RequestMapping(value = "/findRevByMesID.do")
	public String findRevByMesID(int messageID, Model model) {
		// 因为留言和回复都要显示，所以都要找到
		Message mes = messageService.findMesByMesID(messageID);
		List<Revert> listRev = revertService.findRevByMesID(messageID);
		model.addAttribute("message", mes);
		model.addAttribute("listRev", listRev);
		return "revertMessage";
	}

	@RequestMapping(value = "/insertMes.do")
	public String insertMes(String title, String content, String writer, Model model) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		Message mes = new Message();
		mes.setTitle(title);
		mes.setContent(content);
		mes.setWriter(writer);
		mes.setWriteDate(df.format(now));
		mes.setCount(0);
		boolean flag = false;
		try {
			this.messageService.insertMes(mes);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("flag", new Boolean(flag));
		return "saveMessage";
	}

	@RequestMapping(value = "/insertRev.do")
	public String insertRev(int messageID, String content, String writer, Model model) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		Revert rev = new Revert();
		rev.setMessageID(messageID);
		rev.setContent(content);
		rev.setWriter(writer);
		rev.setWriteDate(df.format(now));
		boolean flag = false;
		try {
			this.revertService.insertRev(rev);
			this.messageService.updateMesCountAdd(messageID);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("flag", new Boolean(flag));
		model.addAttribute("messageID", messageID);
		return "saveRevert";
	}
}
