package com.fastmoney.fast_money.security;

import com.fastmoney.fast_money.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取当前的用户
        if (object != null && object instanceof SysUserEntity) {
            UserDetails userDetails = (UserDetails) object;
            SysUserEntity sysUserEntity = (SysUserEntity) object;
            logger.info("用户登录，Name:{}", sysUserEntity.getName());
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("UserDetails", userDetails);
            httpSession.setAttribute("SysUserEntity", sysUserEntity);
            // DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) httpSession.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
            // if (defaultSavedRequest != null) {
            //     String url = defaultSavedRequest.getRequestURL();
            //     String address = defaultSavedRequest.getRequestURI();
            //     if (!address.equals("/login") && !address.equals("/")) {
            //         httpServletResponse.sendRedirect(url);
            //         return;
            //     }
            // }
            // httpServletResponse.sendRedirect("/index");
            httpServletResponse.getWriter().write("success");
            return;
        }
        throw new AccessDeniedException("no right");
    }
}
