package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.SurgicalDebugFilter;

@Component
public class GrayTestFilter extends SurgicalDebugFilter {

	private static Logger log = LoggerFactory.getLogger(GrayTestFilter.class);

	@Override
	public boolean patternMatches() {
		
		final RequestContext ctx = RequestContext.getCurrentContext();
		
		String zuulToken = ctx.getZuulRequestHeaders().get("ZuulToken");
		log.info("zuulToken: " + zuulToken);
		
		String token = ctx.getRequest().getHeader("Token");

		log.info("token: " + token);
        if(null != token){
        	return token.equals("1234567");
        }
        else{
        	return false;
        }
		
	}
}