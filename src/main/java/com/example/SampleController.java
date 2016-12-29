package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.citigroup.ccp.session.util.CCPSessionConstants;

@RestController
public class SampleController {
	
	@Autowired(required=false)
	private LoadBalancerClient loadBalancer;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/route/call", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(HttpServletResponse response, HttpServletRequest request) {
		HttpSession sess= request.getSession(false);
		sess.setAttribute("cdcdcdc", "hbcdbcbdcbd");
		sess.setAttribute(CCPSessionConstants.SESSION_SAVE_IMMEDIATE, true);
		
		HttpHeaders header = new HttpHeaders();
		header.set("sid", request.getHeader("sid"));
		
		HttpEntity<Object> entity = new HttpEntity<Object>(null, header);
		ResponseEntity<String> entityResp = restTemplate.exchange("http://localhost:8089/api/retrieve", HttpMethod.GET,entity,String.class);
		sess.setAttribute(CCPSessionConstants.SESSION_REFRESH, "true");
		System.out.println(""+sess.getAttribute("ServiceToServiceCall"));
		
		return "{ \"token_type\":\"bearer\", \"access_token\":\"AAEFYy1hbGy6261FQZZY_Zr6lyz0nwmXB8sWaW4F3KK86EHMJAlfr7u5mYb7kh4Sd7pN8Fh8dwj4jfJl7exT_p2-SDDDJYJivg6JqvHS7uN0Rct8Wx1rj-Sl9IH5ZCV_H1LUhboCEej-v2nAHaHoWjcb1Q7GtbD\", \"expires_in\":3600, \"scope\":\"/private/v2\"}";
		
	}
	
	
	@RequestMapping(value = "/oauth/token", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public String oauth(HttpServletResponse response, HttpServletRequest request) {
		HttpSession sess= request.getSession(false);
		//sess.setAttribute("ccddcc", "cdcdcdcdc");
		//sess.getAttribute("cdcdcdc");
		return ""+sess.getAttribute("cdcdcdc");
		
	}

}
