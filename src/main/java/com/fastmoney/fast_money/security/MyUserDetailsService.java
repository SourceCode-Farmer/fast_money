package com.fastmoney.fast_money.security;

import com.fastmoney.fast_money.entity.SysUserEntity;
import com.fastmoney.fast_money.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 登录时，获取用户的权限
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    /**
     *   //登陆验证时，通过s获取用户的所有权限信息，
     *         //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUserEntity sysUserEntity = sysUserService.findUserByName(s);
        if (sysUserEntity == null) {
            throw new UsernameNotFoundException("Not found user");
        }
        List<String> permissions = sysUserService.findUserPermissionByUserId(sysUserEntity.getId());
        List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
        grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_LOGIN"));
        if (permissions != null && !permissions.isEmpty()) {
            for (String per : permissions) {
                grantedAuthoritys.add(new SimpleGrantedAuthority(per));
            }
        }
        sysUserEntity.setAuths(grantedAuthoritys);
        return sysUserEntity;
    }
}
