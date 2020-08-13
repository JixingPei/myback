//package com.oldpei.myback.configs.security;
//
//import com.sbibits.springdemo.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private IUserService userService;
//
//    @Autowired
//    public void setUserService(IUserService userService) {
//        this.userService = userService;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//
//        if (userId == null || "".equals(userId)) {
//            throw new RuntimeException("用户不能为空");
//        }
//        //根据用户名查询用户
//        CustomUser customUser = userService.selectByUserId(userId);
//        if (customUser == null) {
//            throw new RuntimeException("用户不存在");
//        }
//        return customUser;
//    }
//
//}
