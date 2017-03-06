//package com.smart.web;
//
//import com.smart.cons.CommonConstant;
//import com.smart.domain.User;
//import org.apache.commons.lang.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * @author: wuchao
// * @date： 2017/2/21
// */
//public class ViewSpaceFilter implements Filter {
//
//
//    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
//
//
//    private static final String[] INHERENT_URIS = {"/add", "/save", "/edit", "/update", "/delete"};
//
//
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        if (servletRequest != null && servletRequest.getAttribute(FILTERED_REQUEST) != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            servletRequest.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
//            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//            User user = getSessionUser(httpServletRequest);
//            if (user == null && isURILogin(httpServletRequest.getRequestURI(), httpServletRequest)) {
//                String toURl = httpServletRequest.getRequestURI().toString();
//                if (!StringUtils.isEmpty(httpServletRequest.getQueryString())) {
//                    toURl += "?" + httpServletRequest.getQueryString();
//                }
//                httpServletRequest.getSession().setAttribute(CommonConstant.LOGIN_TO_URL, toURl);
//                servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
//                return;
//            }
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//    }
//
//    public void destroy() {
//
//    }
//
//    private boolean isURILogin(String requestURI, HttpServletRequest request) {
//        for (String url : INHERENT_URIS) {
//            if (requestURI != null && requestURI.indexOf(url) >= 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private User getSessionUser(HttpServletRequest request) {
//        return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
//    }
//
//}
