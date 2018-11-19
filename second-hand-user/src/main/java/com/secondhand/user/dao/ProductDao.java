package com.secondhand.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.Product;

/**
 * <p>Title: ProductDao</p>
*<p>Description: 商品dao</p>
*@author kid_way
*@date 2018-1-9 下午4:20:19
 */
public interface ProductDao {
	/**
	 * (1)根据卖家id，查找该卖家的所有商品
	 * @param sid 卖家id
	 * @return List<Product> 商品列表
	 */
	public List<Product> findProductsBySid(@Param("sid")Integer sid,@Param("start")Integer start,@Param("pieces")Integer pieces);
	
	/**
	 * (2)查找所有商品
	 * @return List<Product> 商品列表
	 */
	public List<Product> findAllProducts();
	
	/**
	 * (3)根据一级分类id查询商品
	 * @param fcid 一级分类id
	 * @return List<Product> 商品列表
	 */
	public List<Product> findProductsByFcid(Integer fcid);
	
	/**
	 * (4)根据二级分类id查询商品
	 * @param scid 二级分类id
	 * @return ProductDto 商品包装类
	 */
	public ProductDto findProductsByScid(@Param("scid") Integer scid,@Param("start") Integer start,@Param("pieces") Integer pieces);
	
	/**
	 * (5)根据商品id查询商品详情
	 * @param pid 商品id
	 * @return Product 商品
	 */
	public Product findProductByPid(Integer pid);
	
	/**
	 * (6)根据商品名称分页模糊查询商品
	 * @param pname 商品名称
	 * @param start 记录开始
	 * @param pieces 每页记录数
	 * @return List<Product> 商品列表
	 */
	public List<Product> findProductsLikePname(@Param("pname") String pname,@Param("start") Integer start,@Param("pieces") Integer pieces);
	
	/**
	 * (7)添加商品
	 * @param product 商品
	 */
	public void addProduct(Product product);
	
	/**
	 * (8)根据商品id删除该商品
	 * @param pid 商品id
	 */
	public void deleteProduct(Integer pid);
	
	/**
	 * (9)更新商品信息
	 * @param product 商品
	 */
	public void updateProduct(Product product);
	
	/**
	 * (10)对应的二级分类商品的数量
	 * @param scid
	 * @return Integer 数量
	 */
	public Integer scProductCount(Integer scid);
	
	/**
	 * 根据商品名称模糊查询对应的商品总数
	 * @param pname
	 * @return Integer 数量
	 */
	public Integer nameLikeProductCount(String pname);

	/**
	 * 根据卖家id查询其商品总数
	 * @param sid
	 * @return
	 */
	public Integer countProductsBySid(Integer sid);

	/**
	 * 根据卖家id和商品名模糊查询记录数
	 * @param pname
	 * @param sid
	 * @return
	 */
	public Integer nameLikeProductCountBySid(@Param("pname")String pname, @Param("sid")Integer sid);

	/**
	 * 根据卖家id和商品名模糊查询商品分页列表
	 * @param sid
	 * @param pname
	 * @param start
	 * @param pieces
	 * @return
	 */
	public List<Product> nameLikeProductBySid(@Param("sid") Integer sid,@Param("pname")String pname, @Param("start")Integer start,
			@Param("pieces")Integer pieces);
	
	public void updateStock(@Param("pid") Integer pid, @Param("count") Integer count);
}
