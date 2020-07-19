package jmu.gyh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmu.gyh.po.Person;
import jmu.gyh.service.PersonService;

public class PersonTest {

	@Test
	public void findPerByPersonId() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PersonService personService = (PersonService) app.getBean("personServiceImpl");
		Person per = personService.findPerByPersonId("2017110116");
		System.out.println(per);
	}
}
