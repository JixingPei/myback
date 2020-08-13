//package com.oldpei.myback.configs.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUser extends UserModel implements UserDetails {
//
//    private String nickName;
//
//    private List<RoleModel> roleModelList;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (RoleModel role : roleModelList) {
//            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return getUserId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public List<RoleModel> getRoleModelList() {
//        return roleModelList;
//    }
//
//    public void setRoleModelList(List<RoleModel> roleModelList) {
//        this.roleModelList = roleModelList;
//    }
//}
