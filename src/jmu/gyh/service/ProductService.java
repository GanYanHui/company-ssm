package jmu.gyh.service;

import java.util.List;

import jmu.gyh.po.Product;

public interface ProductService {
	public Product findProByProductID(int productID);

	public List<Product> findAllPro();

	public void insertPro(Product product);

	public void updatePro(Product product);

	public void deleteProByProductID(int productID);
	
	public List<Product> findProByLike(String string);
}
