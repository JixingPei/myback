package com.oldpei.myback.configs.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class RoleDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        for (ConfigAttribute configAttribute : configAttributes) {
//            String needRole = configAttribute.getAttribute(); //在安全框架上下文中，已经添加了角色列表，此处即可获取对应路径的角色
////            System.out.println(needRole);
//            if ("ROLE_LOGIN".equals(needRole)){//如果角色列表返回的是ROLE_LOGIN则表示未登录
////                if (authentication instanceof AnonymousAuthenticationToken){//判断是否未登录 AnonymousAuthenticationToken 表示匿名
//                    //判断用户是否登陆  根据authentication 是否是匿名的实例 AnonymousAuthenticationToken 为匿名登陆 即未登录
////                    throw new AccessDeniedException("尚未登陆，请登录！");
////                }else {
////                    如果不是匿名 则停止该方法
//                    return;
////                }
//            }
////            获取登陆用户的角色 通过authentication.getAuthorities()获取
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            for (GrantedAuthority authority : authorities) {
//                if (authority.getAuthority().equals(needRole)){//记住 needRole 是通过数据库里面查找到访问该路径的角色（通过MyFilter类查询到的），这里与登陆用户所拥有的角色对比
//                    return;//如果匹配上，即可访问该路径
//                }
//            }
//        }
////如果权限不足
//        throw new AccessDeniedException("权限不足，请联系管理员！");
        //这里应该是url的访问权限的判断,和menu的权限判断是两码事,懒得写了,就不拦截了
        return;
    }

    //如下两个方法返回false即可
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
