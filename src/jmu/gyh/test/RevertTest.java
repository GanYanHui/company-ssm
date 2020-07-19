package jmu.gyh.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmu.gyh.po.Revert;
import jmu.gyh.service.RevertService;

public class RevertTest {

	@Test
	public void findRevByMesID() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RevertService revertService = (RevertService) app.getBean("revertServiceImpl");
		List<Revert> listRev = revertService.findRevByMesID(1);
		for (Revert revert : listRev) {
			System.out.println(revert);
		}
	}
	
	@Test
	public void insertRev(){
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RevertService revertService = (RevertService) app.getBean("revertServiceImpl");
		
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		Revert revert = new Revert();
		revert.setMessageID(1);
		revert.setWriter("GYH");
		revert.setContent("回复内容");
		revert.setWriteDate(df.format(now));
		
		try {
			revertService.insertRev(revert);
			System.out.println("插入成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteRev(){
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RevertService revertService = (RevertService) app.getBean("revertServiceImpl");
		
		revertService.deleteRev(16);
	}
	
}
