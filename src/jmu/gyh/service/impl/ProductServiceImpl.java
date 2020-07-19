package jmu.gyh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmu.gyh.mapper.ProductMapper;
import jmu.gyh.po.Product;
import jmu.gyh.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource(name = "productMapper")
	private ProductMapper productMapper;

	@Override
	public Product findProByProductID(int productID) {
		return this.productMapper.findProByProductID(productID);
	}

	@Override
	public List<Product> findAllPro() {
		return this.productMapper.findAllPro();
	}

	@Override
	public void insertPro(Product product) {
		this.productMapper.insertPro(product);
	}

	@Override
	public void updatePro(Product product) {
		this.productMapper.updatePro(product);
	}

	@Override
	public void deleteProByProductID(int productID) {
		this.productMapper.deleteProByProductID(productID);
	}

	@Override
	public List<Product> findProByLike(String string) {
		return this.productMapper.findProByLike(string);
	}

}
