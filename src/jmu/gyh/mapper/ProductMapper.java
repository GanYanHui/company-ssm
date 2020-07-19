package jmu.gyh.mapper;

import java.util.List;

import jmu.gyh.po.Product;

public interface ProductMapper {
	public Product findProByProductID(int productID);

	public List<Product> findAllPro();

	public void insertPro(Product product);

	public void updatePro(Product product);

	public void deleteProByProductID(int productID);
	
	public List<Product> findProByLike(String string);
}
