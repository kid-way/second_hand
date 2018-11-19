package com.secondhand.user.dao;

import java.util.List;

import com.secondhand.user.entity.FirstCategory;
/**
 * <p>Title: FirstCategoryDao</p>
*<p>Description: 一级分类dao </p>
*@author kid_way
*@date 2018-1-6 下午9:06:53
 */
public interface FirstCategoryDao {
	/**
	 * 查询所有一级分类及其对应的二级分类
	 * @return
	 */
	public List<FirstCategory> findAllCategory();
}
