//package com.oldpei.myback.configs.security;
//
//import com.sbibits.springdemo.model.CustomMenuModel;
//import com.sbibits.springdemo.model.RoleModel;
//import com.sbibits.springdemo.service.IMenuService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class RoleFilter implements FilterInvocationSecurityMetadataSource {
//
//    IMenuService menuService;//注入菜单表，菜单表里面为后端方法路径
//
//    @Autowired
//    public void setMenuService(IMenuService menuService) {
//        this.menuService = menuService;
//    }
//
//    AntPathMatcher antPathMatcher = new AntPathMatcher();//路径匹配的工具类，spring security里面有，无需自己写
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        String requestUrl = ((FilterInvocation) o).getRequestUrl(); //获取用户的访问路径
//        List<CustomMenuModel> menus = menuService.selectAllMenuRole();//查询所有菜单以及对应的角色
//
//        for (CustomMenuModel menu : menus) {
//            if (antPathMatcher.match(menu.getPath(),requestUrl)){ //比较菜单路径和请求路径是否一致
//                List<RoleModel> roles = menu.getRoleModelList();//如果匹配到了，拿到该路径对应的角色
//                String[] str = new String[roles.size()];
//                for (int i = 0;i<roles.size();i++) {
//                    str[i] = roles.get(i).getRoleCode();//将角色名赋值给str
//                }
//                return SecurityConfig.createList(str);//创建角色属性列表
//            }
//        }
//        //1,如果所有请求地址都没有匹配上的话，可以return null
//        //2,返回SecurityConfig.createList("ROLE_LOGIN");
//        //ROLE_LOGIN 只是一个标记，后边判断返回值 如果是ROLE_LOGIN的话 则让用户登陆后访问
//        return SecurityConfig.createList("ROLE_LOGIN");
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null; //返回null即可
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;//返回true即可
//    }
//}
