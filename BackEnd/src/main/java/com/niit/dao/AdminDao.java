package com.niit.dao;

import java.util.List;

import com.niit.domain.Admin;

public interface AdminDao {
public boolean insert (Admin admin);
public boolean update(Admin admin);
public boolean validate(String id,String password);
public List<Admin> list();
public Admin get(String id);


}
