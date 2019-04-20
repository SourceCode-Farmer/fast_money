package com.fastmoney.fast_money.security;

import com.fastmoney.fast_money.entity.SysPermissionEntity;
import com.fastmoney.fast_money.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限，在调用授权管理器AccessDecisionManager，
 * 这个授权管理器会通过spring的全局缓存SecurityContextHolder获取用户的权限信息，还会获取被拦截的url和被拦截url所需的全部权限，
 * 然后根据所配的策略（有：一票决定，一票否定，少数服从多数等），如果权限足够，则返回，权限不够则报错并调用权限不足页面
 * ---------------------
 * 作者：二当家的黑板报
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u012367513/article/details/38866465
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**
     * 路径对应所需要的权限
     * key：antMatch,用来匹配当前请求
     * value:权限
     */
    Map<AntPathRequestMatcher, List<ConfigAttribute>> map ;


    @Autowired
    SysPermissionService sysPermissionService;

    /**
     * 公共资源路径
     */
    AntPathRequestMatcher publicPath = new AntPathRequestMatcher("/public/**");
    /**
     * 登入路径
     */
    AntPathRequestMatcher loginPath = new AntPathRequestMatcher("/login");
    /**
     * 登出路径
     */
    AntPathRequestMatcher logoutPath = new AntPathRequestMatcher("/logout");
    /**
     * 错误路径
     */
    AntPathRequestMatcher errorPath = new AntPathRequestMatcher("/error/**");

    /**
     * 启动时加载所有URL的权限
     */
    private void loadResurceDefine() {
        map = new HashMap<>();
        List<ConfigAttribute> arry ;
        List<SysPermissionEntity> sysPermissionEntities = sysPermissionService.findPathPermission();
        for (SysPermissionEntity entity : sysPermissionEntities) {
            if (entity == null || entity.getUrl() == null || entity.getUrl().isEmpty()) {
                continue;
            }
            if (entity.getSys_permission() == null || entity.getSys_permission().isEmpty()) {
                continue;
            }
            arry = new ArrayList<>();
            //多个权限使用分号隔开
            for(String str : entity.getSys_permission().split(";")){
                if (str != null && !str.trim().isEmpty()) {
                    arry.add(new SecurityConfig(str.trim()));
                }
            }
            map.put(new AntPathRequestMatcher(entity.getUrl()), arry);
        }
    }

    /**
     * 每次访问时，此方法获取路径所需的权限
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (map == null) {
            loadResurceDefine();
        }
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        HttpServletResponse response = ((FilterInvocation) o).getHttpResponse();
        Set<ConfigAttribute> set = new HashSet<>();
        boolean isMatch = false;
        for (AntPathRequestMatcher key : map.keySet()) {
            if (key.matches(request)) {
                isMatch = true;
                set.addAll(map.get(key));
            }
        }
        if (isMatch && set.size() > 0) {
            return set;
        }
        if (loginPath.matches(request)) {
            return null;
        }
        if (logoutPath.matches(request)) {
            return null;
        }
        if (errorPath.matches(request)) {
            return null;
        }
        if (publicPath.matches(request)) {
            return null;
        }
        throw new AccessDeniedException("no right");
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
