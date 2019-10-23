package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	@Autowired
	DBMapper dbMapper;
	
	public String getDual() throws Exception{
		return dbMapper.getDual();
	}
	
	public Human getHuman(String name) throws Exception{
		return dbMapper.getHuman(name);
	}
	
}
