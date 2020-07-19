package jmu.gyh.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmu.gyh.po.Message;
import jmu.gyh.service.MessageService;

public class MessageTest {

	@Test
	public void findMesByMesID() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");
		Message mes = messageService.findMesByMesID(1);
		System.out.println(mes);
	}

	@Test
	public void findAllMes() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");
		List<Message> listMes = messageService.findAllMes();
		for (Message message : listMes) {
			System.out.println(message);
		}
	}

	@Test
	public void insertMes() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");

		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		Message message = new Message();
		message.setTitle("标题");
		message.setContent("内容");
		message.setWriter("GYH");
		message.setWriteDate(df.format(now));
		message.setCount(0);

		try {
			messageService.insertMes(message);
			System.out.println("插入成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateMesCountAdd() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");
		messageService.updateMesCountAdd(1);
	}

	@Test
	public void updateMesCountSub() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");
		messageService.updateMesCountSub(1);
	}

	@Test
	public void findMesByLike() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageService messageService = (MessageService) app.getBean("messageServiceImpl");
		List<Message> listMes = messageService.findMesByLike("谢亚飞");
		for (Message message : listMes) {
			System.out.println(message);
		}
	}
}
