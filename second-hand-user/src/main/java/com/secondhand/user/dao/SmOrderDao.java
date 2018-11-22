package com.secondhand.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.secondhand.user.entity.Receiver;
import com.secondhand.user.entity.SmOrder;

public interface SmOrderDao {
	
	/**
	 * 批量添加小订单
	 * @param smOrders
	 */
	public void addSmOrders(List<SmOrder> smOrders);
	
	/**
	 * 根据oid改变对应的小订单的状态（取消订单或支付）
	 * @param oid 大订单id
	 * @param state 大订单状态
	 */
	public void changeStateByOid(@Param("oid")String oid,@Param("state")Integer state);

	/**
	 * 根据大订单id删除小订单
	 * @param oid
	 */
	public void deleteSmOrders(String oid);
	
	/**
	 * 根据小订单id更改小订单状态
	 * @param soid
	 * @param state
	 */
	public void changeStateBySoid(@Param("soid")String soid, @Param("state")Integer state);
	
	/**
	 * 根据卖家id查询卖家的订单
	 * @param sid
	 * @return
	 */
	public List<SmOrder> findSmOrdersBySid(Integer sid);
	
	/**
	 * 根据订单状态和卖家id查询相对应的订单
	 * @param sid 卖家id
	 * @param state 订单状态
	 * @return
	 */
	public List<SmOrder> findSmOrdersByState(@Param("sid") Integer sid,@Param("state") Integer state);

	public Receiver findReceiverBySoid(String soid);
	
}
