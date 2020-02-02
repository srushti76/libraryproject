package com.app.P2PLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.P2PLibrary.dao.IUserDao;
import com.app.P2PLibrary.pojos.User;

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	IUserDao dao;
	
	@Override
	public User login(User user) {
		User temp =new User();
		temp.setEmail(user.getEmail());
		temp.setPassword(user.getPassword());
		
		System.out.println(temp);
		
		Example<User> exUser=Example.of(temp);
		Optional<User> optional = dao.findOne(exUser);
		
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public boolean register(User user) {
		try {
			dao.save(user);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			List<User> books=dao.findAll();
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean removeUser(Integer userId) {
		
		try{
			dao.deleteById(userId);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateUser(String phone, Integer userid) {
		Optional<User> opt=dao.findById(userid);
		if(opt.isPresent()) {
			User u=opt.get();
			u.setPhone(phone);
			try {
				dao.save(u);
				return true;
			}catch (Exception e) {
				System.out.println(e);
			}
		}			
		return false;
	}

	@Override
	public boolean suspendUser(Integer userid) {
		Optional<User> opt=dao.findById(userid);
		if(opt.isPresent()) {
			User user=opt.get();
			user.setInactive(true);
			try {
				dao.save(user);
				return true;
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		return false;
	}
	

}
