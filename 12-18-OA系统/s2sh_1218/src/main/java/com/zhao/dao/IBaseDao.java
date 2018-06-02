package com.zhao.dao;

import java.io.Serializable;
import java.util.List;


public interface IBaseDao<T extends Serializable, ID extends Serializable> {
	
	T save(T record);
	T delete(T record);
	T load(ID id);
	T update(T record);
	
	List<T> selectByExample(T record,int...page);
	int selectByExampleRowsNum(T record);
}
