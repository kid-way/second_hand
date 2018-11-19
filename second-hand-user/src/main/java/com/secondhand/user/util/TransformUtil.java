package com.secondhand.user.util;

public class TransformUtil {
	public static Integer[] transform(String [] attr){
		int lenth = attr.length;
		Integer[] in = new Integer[lenth];
		for(int m = 0;m < lenth;m++){
			in[m] = Integer.parseInt(attr[m]);
		}
		return in;
	}
}
