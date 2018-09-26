package com.fanxl.dynamic.filter;


import com.fanxl.dynamic.datasource.RoutingDataSourceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 13:36
 */
@Slf4j
@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        log.info("filter start");

        String as = request.getParameter("as");
        log.info("as: {}", as);
        if (as == null) {
            throw new InvalidParameterException("as不能为空");
        } else {
            RoutingDataSourceContext.setThreadLocalDataSourceKey(as);
            filterChain.doFilter(request, response);
        }
        log.info("filter end, time=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        log.info("filter销毁");
    }
}
