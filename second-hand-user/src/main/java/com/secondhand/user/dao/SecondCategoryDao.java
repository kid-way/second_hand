package com.secondhand.user.dao;

import java.util.List;

import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.SecondCategory;

/**
 * <p>Title: SecondCategoryDao</p>
*<p>Description: 根据二级分类id查询对应的商品列表</p>
*@author kid_way
*@date 2018-1-14 下午1:44:12
 */
public interface SecondCategoryDao {
	public List<Product> findProductByScid(Integer scid);
	
	public List<SecondCategory> findSecondCategorysByFcid(Integer fcid);
}
