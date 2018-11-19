package com.secondhand.user.service;

import java.util.List;

import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.Product;

/**
 * <p>Title: ProductService</p>
*<p>Description: 商品service</p>
*@author kid_way
*@date 2018-1-9 下午8:23:10
 */
public interface ProductService {
	/**
	 * (1)查找所有商品
	 * @return List<Product> 商品列表
	 */
	public List<Product> findAllProducts();
	
	/**
	 * (2)根据二级分类查询对应的商品
	 * @param scid 二级分类id
	 * @return List<Product> 商品列表
	 */
	public ProductDto findProductsByScid(Integer scid,Integer start,Integer pieces);
	
	/**
	 * (3)根据商品id查询商品详情
	 * @param pid 商品id
	 * @return Product 商品
	 */
	public Product findProductByPid(Integer pid);

	/**
	 * (4)根据商品名模糊查询商品
	 * @param pname 商品名称
	 * @return List<Product> 商品列表
	 */
	public ProductDto findProductsLikePname(String pname,Integer start,Integer pieces);
	
	/**
	 * (5)根据一级分类id查询对应的商品
	 * @param fcid 一级分类id
	 * @return List<Product> 商品列表
	 */
	public List<Product> findProductsByFcid(Integer fcid);
	
	/**
	 * (6)发布商品
	 * @param product 商品
	 */
	public void addProduct(Product product);
	
	/**
	 * 根据商品id删除商品
	 * @param pid 商品id
	 */
	public void deleteProduct(Integer pid);

	/**
	 * (8)更新商品信息
	 * @param product 商品
	 */
	public void updateProduct(Product product);
	
	/**
	 * (9)根据卖家id查询对应的商品
	 * @param sid 卖家id
	 * @return ProductDto 商品包装类
	 */
	public ProductDto findProductsBySid(Integer sid,Integer page);
	
	/**
	 * (10)根据商品名和卖家id查找商品分页列表
	 * @param pname
	 * @param sid
	 * @param page
	 * @return ProductDto 商品包装类
	 */
	public ProductDto findNameLikeProductsBySid(String pname, Integer sid,
			Integer page);
	
	/**
	 * (11)根据商品id查找商品
	 * @param pid
	 * @return
	 */
	public Product toUpdateProduct(Integer pid);
}
