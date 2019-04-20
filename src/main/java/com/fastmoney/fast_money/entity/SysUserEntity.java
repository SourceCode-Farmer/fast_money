package com.fastmoney.fast_money.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author 10990866
 */
public class SysUserEntity implements UserDetails {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 全名
     */
    private String full_name;

    /**
     * 密码
     */
    private String password;

    /**
     * 移动电话
     */
    private String mobile;
    /***
     * 使用状态
     */
    private Boolean state;
    /**
     * 可使用的时间
     */
    private Date using_time;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Date create_time;

    Collection<GrantedAuthority> auths= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Collection<GrantedAuthority> getAuths() {
        return auths;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getUsing_time() {
        return using_time;
    }

    public void setUsing_time(Date using_time) {
        this.using_time = using_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths;
    }

    public void setAuths(Collection<GrantedAuthority> auths) {
        this.auths = auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    /**
     * 账户未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return new Date().before(using_time);
    }

    /**
     * 账户没锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *凭据未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是使能的
     * @return
     */
    @Override
    public boolean isEnabled() {
        return this.state;
    }
}
