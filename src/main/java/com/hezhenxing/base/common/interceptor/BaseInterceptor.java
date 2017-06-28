package com.hezhenxing.base.common.interceptor;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xing on 15/9/10.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

	public static Logger logger = Logger.getLogger(BaseInterceptor.class);

	protected static String[] verifyPath;

	protected static String[] excludeUrls;

	protected boolean isVerifyPath;

	/**
	 * 执行html js 代码
	 *
	 * @param response
	 * @param html
	 * @throws IOException
	 */
	protected void html(HttpServletResponse response, String html)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.close();
	}

	/**
	 * 需要验证的URL
	 *
	 * @param paths
	 */
	public void setVerifyPath(String[] paths) {

		verifyPath = (String[]) ArrayUtils.addAll(paths, verifyPath);
	}

	/**
	 * 需要验证的URL中的验证例外
	 *
	 * @param excludeUrls
	 */
	public void setExcludeUrls(String[] excludeUrls) {

		this.excludeUrls = excludeUrls;
	}

	/**
	 * 请求是否是验证列表中的例外部分
	 *
	 * @param requestUrl
	 * @return
	 */
	protected boolean isExcludeUrl(String requestUrl) {
		for (String excludeUrl : excludeUrls) {
			if (requestUrl.startsWith(excludeUrl)) {
				return true;
			}
		}
		return false;
	}

	protected void OutScrpit(HttpServletResponse response, String msg) throws IOException {
		//未经授权
//		logger.debug(msg);

		StringBuffer builder = new StringBuffer();
		builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
		builder.append("alert('" + msg + "');");
		builder.append("window.top.location.href='/';");
		builder.append("</script>");
		html(response, builder.toString());
	}
}
