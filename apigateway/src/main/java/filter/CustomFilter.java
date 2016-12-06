package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomFilter extends ZuulFilter {

	  private static Logger log = LoggerFactory.getLogger(CustomFilter.class);

	  @Override
	    public Object run() {
	        final RequestContext ctx = RequestContext.getCurrentContext();
	        
	        ctx.addZuulRequestHeader("ZuulToken", "TestSample");
	        
//	        String token = ctx.getRequest().getHeader("Token");
//	        
//	        log.info("first token: " + token);
//	        
	        
//	        if(token.equals("ABCDE")){
//	        	try {
//					ctx.setRouteHost((new URL("http://localhost:8090/*")));
//				} catch (MalformedURLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	        
	        return null;
	    }

	    @Override
	    public boolean shouldFilter() {
	        return true;
	    }

	    @Override
	    public int filterOrder() {
	        return 2;
	    }

	    @Override
	    public String filterType() {
	        return "pre";
	    }
}