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
		product.setName("飞科电动剃须刀");
		product.setBrand("FLYCO飞科");
		product.setModel("FS373");
		product.setPrice(100.00);
		product.setPicture("飞科剃须刀.jpg");
		product.setDescription("智能系统，全身水洗，浮动贴面剃须系统");
		try {
			productService.insertPro(product);
			System.out.println("插入成功!");
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
		product.setName("飞科电动剃须刀");
		product.setBrand("FLYCO飞科");
		product.setModel("FS373");
		product.setPrice(100.00);
		product.setPicture("飞科剃须刀.jpg");
		product.setDescription("智能系统，全身水洗，浮动贴面剃须系统");
		try {
			productService.updatePro(product);
			System.out.println("修改成功!");
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
			System.out.println("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findProByLike(){
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ProductService productService = (ProductService) app.getBean("productServiceImpl");
		List<Product> listPro = productService.findProByLike("笔记本");
		for (Product product : listPro) {
			System.out.println(product);
		}
	}
}
