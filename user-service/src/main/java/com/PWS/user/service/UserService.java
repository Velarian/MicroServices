package com.PWS.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.PWS.user.VO.Department;
import com.PWS.user.VO.ResponseTemplateVO;
import com.PWS.user.entity.User;
import com.PWS.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
 
  @SuppressWarnings("unchecked")
public List<User> getAllUserWithDepartment() {
  	// TODO Auto-generated method stub
	  log.info("Inside getUserWithDepartment of UserService");
	  ResponseTemplateVO vo = new ResponseTemplateVO();
  	     List<User> users=userRepository.findAll();
  	     for (User user : users) {
  	    	Department department =
  	                restTemplate.getForObject("http://localhost:9191/departments/" + user.getDepartmentId()
  	                        ,Department.class);
  	    	 vo.setUser(user);
  	        vo.setDepartment(department);
  	    	
  	    	 
			
		}
		return (List<User>) vo; 
  	}
  
//  		
    
  }

//@SuppressWarnings("unchecked")
//public List<User> getAllUserWithDepartment(User user) {
//	// TODO Auto-generated method stub
//	List<User> vo = (List<User>) new ResponseTemplateVO();
////	 List<User> user = userRepository.findAll();
//	List<User> user=userRepository.findAll();
//	for (User user2 : user) {
//		Department department =
//                restTemplate.getForObject("http://localhost:9191/departments/" + user2.getDepartmentId()
//                        ,Department.class);
//		 ((ResponseTemplateVO) vo).setUser(user2);
//	     ((ResponseTemplateVO) vo).setDepartment(department);
//	     
//	     
//	}
//	return vo;
//		
//		
//		
//		
//	}
	
	
	
	
	
	
	
	