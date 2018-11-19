package com.secondhand.user.service;

import java.util.List;

import com.secondhand.user.entity.FirstCategory;
import com.secondhand.user.entity.SecondCategory;

public interface CategoryService {
	public List<FirstCategory> findAllCategory();

	public List<SecondCategory> getSecondCategory(Integer fcid);

}
