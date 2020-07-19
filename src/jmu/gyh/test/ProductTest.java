package jmu.gyh.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmu.gyh.po.Product;
import jmu.gyh.service.ProductService;

public class ProductTest {

	@Test
	public void findProByProductID() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		Product pro = productService.findProByProductID(1);
		System.out.println(pro);
	}

	@Test
	public void findAllPro() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		List<Product> listPro = productService.findAllPro();
		for (Product product : listPro) {
			System.out.println(product);
		}
	}

	@Test
	public void insertPro() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		Product product = new Product();
		product.setSerialNumber("001");
		product.setName("�ɿƵ綯���뵶");
		product.setBrand("FLYCO�ɿ�");
		product.setModel("FS373");
		product.setPrice(100.00);
		product.setPicture("�ɿ����뵶.jpg");
		product.setDescription("����ϵͳ��ȫ��ˮϴ��������������ϵͳ");
		try {
			productService.insertPro(product);
			System.out.println("����ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateProByProductID() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		Product product = new Product();
		product.setProductID(14);
		product.setSerialNumber("002");
		product.setName("�ɿƵ綯���뵶");
		product.setBrand("FLYCO�ɿ�");
		product.setModel("FS373");
		product.setPrice(100.00);
		product.setPicture("�ɿ����뵶.jpg");
		product.setDescription("����ϵͳ��ȫ��ˮϴ��������������ϵͳ");
		try {
			productService.updatePro(product);
			System.out.println("�޸ĳɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteProByProductId() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		try {
			productService.deleteProByProductID(1);
			System.out.println("ɾ���ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findProByLike(){
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		List<Product> listPro = productService.findProByLike("�ʼǱ�");
		for (Product product : listPro) {
			System.out.println(product);
		}
	}
}
