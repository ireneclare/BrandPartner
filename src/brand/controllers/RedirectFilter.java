package brand.controllers;


import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 
 * @author SHI
 *
 * This filter is meant for switching from appspot domain to our custom domain for the URLs other than
 * taskQueue,Cron Services and URLs using HTTPS scheme
 * 
 * Currently we have implemented the switching from our custom domain to appspot domain 
 * for the URLs using HTTPS in javascript level.
 */
public class RedirectFilter implements Filter {

	private static Logger log=Logger.getLogger(RedirectFilter.class.getSimpleName());
	private static String mainDomainURL="";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("insiins");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		StringBuffer buf=new StringBuffer("");
		String absoluteURL=request.getRequestURL().toString();
		String currentPath=request.getRequestURI();
		
//		if("LIVE".equals(appMode)||"STAGING".equals(appMode)){						
//			if(absoluteURL.indexOf("taskQueue")<0 && absoluteURL.indexOf("appspot.com")>=0 && 
//					("http".equals(schema) || currentPath.indexOf("showThankyou")>=0)&&currentPath.indexOf("CronService")<0)
//			{
//				
//				if("/".equals(currentPath))
//					currentPath="";
//				String redirectURL=mainDomainURL+currentPath;
//				if(!"".equals(buf.toString()))
//					redirectURL=redirectURL+"?"+buf.toString();
//				if(absoluteURL.contains("appspot.com"))
//				{
//					//log.info("*************** >>>>>>>>>> Setting response Status(301) absoluteURL >>>>>>>>>>>>>> ****************** :"+absoluteURL);
//					response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//					response.setHeader( "Location", redirectURL);
//				}
//				else
//					response.sendRedirect(redirectURL);
//			}
//			else
//				chain.doFilter(req,res);
//		}

//		else
		if(System.getProperty("AppMode").equalsIgnoreCase("LIVE"))
		{
			if(absoluteURL.indexOf("appspot.com")>=0)
				response.sendRedirect("http://partner.solestruck.com");
			else
				chain.doFilter(req,res);
		}
		else
		{
			chain.doFilter(req,res);
		}
				
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		try{
			String appMode=System.getProperty("AppMode");
			String paramName=appMode+"_Domain";
			mainDomainURL=config.getInitParameter(paramName)==null?"":config.getInitParameter(paramName);
			System.out.println("mainDomainURL:"+mainDomainURL);

		}
		catch(Exception e){
			log.warning("Exception in init:"+e);
		}
	}
	
		
 /* private static String getAppspotURL(boolean secure)
	{
		String URL="";
		try{
			String applicationId = EnvironmentUtil.getEnvironmentValue("com.google.appengine.application.id");
		   // String version = EnvironmentUtil.getEnvironmentValue("com.google.appengine.application.version");
		    //URL = "http://"+version+"."+applicationId+".appspot.com/";
			if(secure)
				URL = "https://"+applicationId+".appspot.com/";
			else
				URL = "http://"+applicationId+".appspot.com/";
		    log.info("The constructed URL is :::"+URL);
		}
		catch(Exception e){
			log.warning("Exception in getAppspotURL "+e);
		}
		return URL;
	}*/
	 
}

