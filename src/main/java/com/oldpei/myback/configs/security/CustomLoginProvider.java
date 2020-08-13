package com.oldpei.myback.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

//public class CustomLoginProvider extends AbstractUserDetailsAuthenticationProvider {
//
//    private LdapService ldapService;
//
//    private IUserService userService;
//
//
//    @Autowired
//    public void setUserService(IUserService userService) {
//        this.userService = userService;
//    }
//
//
//    @Autowired
//    public void setLdapService(LdapService ldapService) {
//        this.ldapService = ldapService;
//    }
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//        String password = usernamePasswordAuthenticationToken.getCredentials().toString();
//        if (username == null || "".equals(username)) {
//            throw new UsernameNotFoundException("用户不能为空");
//        }
//        //根据用户名查询用户
//        CustomUser customUser =  userService.selectByUserId(username);
//
//        if (customUser == null) {
//
//            LdapPerson ldapPerson = ldapService.ldapLoginCheck(username, password);
//            if(null == ldapPerson) {
//                throw new BadCredentialsException("用户不存在或密码错误");
//            } else {
//
//                UserModel userModel = new UserModel();
//                userModel.setUserId(username);
//                userModel.setUserName(ldapPerson.getName());
//                userModel.setPassword(CommonUtils.createSecurity(password));
//                userModel.setUseLdap(CommonUtils.TRUE_STR_1);
//                userModel.setLockFlg(CommonUtils.FALSE_STR_0);
//                userModel.setActiveFlg(CommonUtils.TRUE_STR_1);
//                userModel.setPwdFailedCount(0);
//                userModel.setSysInsertId(CommonUtils.USER_SYSTEM);
//                userModel.setSysUpdateId(CommonUtils.USER_SYSTEM);
//
//                UserRoleModel userRoleModel = new UserRoleModel();
//                userRoleModel.setUserId(username);
//                userRoleModel.setRoleCode(CommonUtils.ROLE_DEFAULT);
//                userRoleModel.setActiveFlg(CommonUtils.TRUE_STR_1);
//                userRoleModel.setSysInsertId(CommonUtils.USER_SYSTEM);
//                userRoleModel.setSysUpdateId(CommonUtils.USER_SYSTEM);
//
//                List<UserRoleModel> userRoleModelList = new ArrayList<>();
//                userRoleModelList.add(userRoleModel);
//
//                userService.insertUser(userModel, userRoleModelList);
//                customUser = userService.selectByUserId(username);
//            }
//
//        } else {
//            if(CommonUtils.TRUE_STR_1.equals(customUser.getUseLdap())){
//                LdapPerson ldapPerson = ldapService.ldapLoginCheck(username, password);
//                if(null == ldapPerson) {
//                    throw new BadCredentialsException("用户不存在或密码错误");
//                }
//            } else {
//                BCryptPasswordEncoder bcEncoder = new BCryptPasswordEncoder();
//                if(!bcEncoder.matches(password,customUser.getPassword())){
//
//                    throw new BadCredentialsException("密码错误");
//                }
//            }
//
//        }
//        return customUser;
//    }
//}
