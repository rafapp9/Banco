package com.banco.repository;

import java.util.List;

public interface GenericCRUD<T,V> {

	void create(T obj);
	
	List<T> readAll();
	
	T read(V id);
	
	T update(V id);
	
	void delete(V id);


	
}
