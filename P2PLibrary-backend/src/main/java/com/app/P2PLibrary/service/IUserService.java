package com.app.P2PLibrary.service;

import java.util.List;

import com.app.P2PLibrary.pojos.User;

public interface IUserService {
	
	public User login(User user);
	public boolean register(User user);
	public List<User> getAllUsers();
	public boolean removeUser(Integer userId);
	public boolean updateUser(String phone,Integer userid);
	public boolean suspendUser(Integer userid);
}
