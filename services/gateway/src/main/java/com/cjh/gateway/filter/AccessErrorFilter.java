package com.cjh.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * 网关代理过滤器
 * @author cjh
 */
@Log4j2
@Component
public class AccessErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        log.info("错误！！！");
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        log.error("出错啦,{}",throwable.getCause().getMessage());
        log.error("出错啦,{}",throwable.getCause());
        return null;
    }
}
