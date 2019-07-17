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
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        log.info("启用！！！");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rct = RequestContext.getCurrentContext();
//        rct.setSendZuulResponse(false);
//        rct.setResponseStatusCode(4011);
        return null;
    }
}
