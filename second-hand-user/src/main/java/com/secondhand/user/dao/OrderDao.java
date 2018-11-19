package com.secondhand.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.secondhand.user.dto.ProductStockDto;
import com.secondhand.user.entity.Orders;
import com.secondhand.user.entity.Product;
/**
 * <p>Title: OrderDao</p>
*<p>Description: 大订单Dao</p>
*@author kid_way
*@date 2018-1-18 上午12:28:15
 */
public interface OrderDao {
	/**
	 * 添加大订单
	 * @param order
	 */
	public void addOrder(Orders order);
	
	/**
	 * 改变订单状态
	 * @param oid
	 * @param state
	 */
	public void changeOrderState(@Param("oid")String oid,@Param("state")Integer state);
	
	/**
	 * 查找用户订单
	 * @param uid
	 * @return
	 */
	public List<Orders> findAllOrders(Integer uid);
	
	/**
	 * 根据用户id及订单状态查询订单列表
	 * @param uid
	 * @param state
	 * @return
	 */
	public List<Orders> findOrdersByState(@Param("uid")Integer uid,@Param("state") Integer state);

	/**
	 * 根据大订单id删除大订单
	 * @param oid
	 */
	public void deleteOrder(String oid);
	
	/**
	 * 根据大订单id查询订单详情
	 * @param oid
	 * @return
	 */
	public Orders findOrderByOid(String oid);
	
	/**
	 * 通过用户id和订单状态查询相应的商品
	 * @param uid
	 * @param state
	 * @return
	 */
	public List<Product> findProductsByState(@Param("uid")Integer uid, @Param("state")Integer state);

	public List<ProductStockDto> getProductStockDto(String oid);
}
