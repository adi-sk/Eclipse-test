package com.zycusBank.aditya;

import java.util.*;

public interface CommonDAO<T> {

	void create(T object, String pass);
	List<T> findAll();
	T findByName(String name);
}
