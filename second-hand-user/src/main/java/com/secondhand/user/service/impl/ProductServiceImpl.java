package com.secondhand.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhand.user.dao.ProductDao;
import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.Product;
import com.secondhand.user.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> findAllProducts() {
		List<Product> list = productDao.findAllProducts();
		return list;
	}

	@Override
	public ProductDto findProductsByScid(Integer scid,Integer start,Integer pieces) {
		ProductDto productDto = productDao.findProductsByScid(scid,start,pieces);
		int count = productDao.scProductCount(scid);
		int pageCount = 0;
		if(count%pieces==0){
			pageCount = count/pieces;
		}else{
			pageCount = count/pieces + 1;
		}
		productDto.setPageCount(pageCount);
		return productDto;
	}

	@Override
	public Product findProductByPid(Integer pid) {
		Product product = productDao.findProductByPid(pid);
		return product;
	}

	@Override
	public ProductDto findProductsLikePname(String pname,Integer start,Integer pieces) {
		List<Product> list = productDao.findProductsLikePname(pname,start,pieces);
		ProductDto productDto = new ProductDto();
		productDto.setpList(list);
		int count = productDao.nameLikeProductCount(pname);
		int pageCount = 0;
		if(count%pieces==0){
			pageCount = count/pieces;
		}else{
			pageCount = count/pieces + 1;
		}
		productDto.setPageCount(pageCount);
		return productDto;
	}

	@Override
	public List<Product> findProductsByFcid(Integer fcid) {
		List<Product> list = productDao.findProductsByFcid(fcid);
		return list;
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Integer pid) {
		productDao.deleteProduct(pid);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public ProductDto findProductsBySid(Integer sid,Integer page) {
		Integer pieces = 10;
		Integer start = (page-1)*pieces;
		List<Product> list = productDao.findProductsBySid(sid,start,pieces);
		ProductDto productDto = new ProductDto();
		productDto.setpList(list);
		Integer count = productDao.countProductsBySid(sid);
		productDto.setCount(count);
		Integer pageCount = null;
		if(count%pieces==0){
			pageCount = count/pieces;
		}else{
			pageCount = count/pieces + 1;
		}
		productDto.setPageCount(pageCount);
		productDto.setPieces(pieces);
		return productDto;
	}

	@Override
	public ProductDto findNameLikeProductsBySid(String pname, Integer sid,
			Integer page) {
		ProductDto productDto = new ProductDto();
		Integer pieces = 10;
		Integer start = (page-1)*pieces;
		Integer count = productDao.nameLikeProductCountBySid(pname,sid);
		productDto.setCount(count);
		Integer pageCount = null;
		if(count%pieces==0){
			pageCount = count/pieces;
		}else{
			pageCount = count/pieces + 1;
		}
		productDto.setPageCount(pageCount);
		productDto.setPieces(pieces);
		List<Product> pList = productDao.nameLikeProductBySid(sid,pname,start,pieces);
		productDto.setpList(pList);
		return productDto;
	}

	@Override
	public Product toUpdateProduct(Integer pid) {
		Product product = productDao.findProductByPid(pid);
		return product;
	}
}