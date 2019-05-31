package com.dub.spring.filters;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * This Zuul post filter is used to hide the actual URL of an uploaded photo and replace it by a proxy URL
 * */
@Component
public class ResponseFilter extends ZuulFilter{
    private static final int  FILTER_ORDER=1;
    private static final boolean  SHOULD_FILTER=true;
      
    @Value("${proxy-sharewood-url}")
    String proxySharewoodUrl;
   

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        
        List<Pair<String,String>> responseHeaders 
        		= ctx.getZuulResponseHeaders();
          
        String uri = "";
        String path = "";
        
        for (Pair<String,String> header : responseHeaders) {
        	if (header.first().equals("Location")) {
        		
        		uri = header.second();
        		
        		
        
        		String pattern = "(/api/photos/\\d+)$";	   
        		Pattern r = Pattern.compile(pattern);
        		
        		Matcher m = r.matcher(uri);
 
        		if (m.find()) {
        			
        		   	
        			path = m.group(1);
        		
        			
        			
        			// set final response header
         			header.setSecond(proxySharewoodUrl + path);
        		} else {

            			// do something
            		
            	
        		}      			
        	}
        }
        
        return null;
    }
}
