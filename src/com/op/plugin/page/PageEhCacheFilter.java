package com.op.plugin.page;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.constructs.blocking.LockTimeoutException;
import net.sf.ehcache.constructs.web.AlreadyCommittedException;
import net.sf.ehcache.constructs.web.AlreadyGzippedException;
import net.sf.ehcache.constructs.web.filter.FilterNonReentrantException;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

 /**
  * 
 *    
 * 项目名称：outdoorPortal   
 * 类名称：PageEhCacheFilter   
 * 类描述：   页面缓存过滤器
 * 创建人：Win Zhong   
 * 创建时间：2015年12月16日 下午3:00:19   
 * 修改人：Win Zhong   
 * 修改时间：2015年12月16日 下午3:00:19   
 * 修改备注：   
 * @version    
 *
  */
public class PageEhCacheFilter extends SimplePageCachingFilter {

    private final static Logger log = Logger.getLogger(PageEhCacheFilter.class);
    private final static String FILTER_URL_PATTERNS = "patterns";
    private static String[] cacheURLs;

    private void init() throws CacheException {
        String patterns = filterConfig.getInitParameter(FILTER_URL_PATTERNS);
        cacheURLs = StringUtils.split(patterns, ",");
    }

    @Override
	protected void doFilter(final HttpServletRequest request,
			final HttpServletResponse response, final FilterChain chain)
			throws AlreadyGzippedException, AlreadyCommittedException,
			FilterNonReentrantException, LockTimeoutException, Exception {
		if (cacheURLs == null) {
			init();
		}
		String url = request.getRequestURI();
		log.info("请求路径："+ url);
		log.info("过滤路径："+ Arrays.toString(cacheURLs));	
		boolean flag = true;
		if (cacheURLs != null && cacheURLs.length > 0) {
			for (String cacheURL : cacheURLs) {
				if (url.contains(cacheURL.trim())) {
					flag = true;
					break;
				}
			}
		}
		// 如果包含我们要缓存的url 就缓存该页面，否则执行正常的页面转向
		if (flag) {
			String query = request.getQueryString();
			if (query != null) {
				query = "?" + query;
			}
			log.info("当前请求被缓存：" + url + " == " + query);
			super.doFilter(request, response, chain);
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean headerContains(final HttpServletRequest request, final String header, final String value) {
        logRequestHeaders(request);
		final Enumeration<String> accepted = request.getHeaders(header);
        while (accepted.hasMoreElements()) {
            final String headerValue = (String) accepted.nextElement();
            if (headerValue.indexOf(value) != -1) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected boolean acceptsGzipEncoding(HttpServletRequest request) {
    	//兼容ie6/7 gzip压缩
        boolean ie6 = headerContains(request, "User-Agent", "MSIE 6.0");
        boolean ie7 = headerContains(request, "User-Agent", "MSIE 7.0");
        return acceptsEncoding(request, "gzip") || ie6 || ie7;
    }
}
