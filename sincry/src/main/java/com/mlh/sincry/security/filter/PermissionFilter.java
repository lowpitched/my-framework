package com.mlh.sincry.security.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 权限校验过滤器
 * Created by menglihao on 2017/6/13.
 */
public class PermissionFilter extends AccessControlFilter {

    /*校验是否有权限*/
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        if(isLoginRequest(servletRequest,servletResponse)){
            return true;
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        Subject subject = getSubject(request, servletResponse);
        return subject.isPermitted(uri);
    }

    /*如果没有权限此处处理*/
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        WebUtils.issueRedirect(servletRequest,servletResponse,"/login/toLogin.do");
        return true;
    }


}
