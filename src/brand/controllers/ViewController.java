package brand.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import brand.beans.PMF;
import brand.beans.Partner;
import brand.services.CommonService;
import brand.services.MailingService;
import brand.utils.Response;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.MerchantAccount;
import com.braintreegateway.MerchantAccountRequest;
import com.braintreegateway.Result;
import com.braintreegateway.ValidationError;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@Controller
public class ViewController {

	private static final Logger log=Logger.getLogger(ViewController.class.getName());
	
	@RequestMapping("/")
	String home(HttpServletRequest request, HttpServletResponse response)
	{
	 	 try 
	 	 {
			response.sendRedirect("/signup");
		 }
	 	 catch (IOException e) 
	 	 {
			e.printStackTrace();
		 }
		return "FormSubmit";
	}
	
	@RequestMapping("/signup")
	String formSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		return "FormSubmit";
	}
	
	@RequestMapping(value = "/post/{what}", method = RequestMethod.POST)
	protected @ResponseBody Response post(@PathVariable("what") String what, @RequestParam("data") String data, HttpServletRequest request, HttpServletResponse response)
	{
		Response resp						=	new Response();
		
		System.out.println("inside the registration");
		
		try
		{
			JSONObject extract				=	null;
			
			if(data != null)
				extract						=	new JSONObject(data);
			
			if("partnerRegistration".equalsIgnoreCase(what))
			{
				 CommonService.instance().partnerRegistration(request,resp, extract);
			}
		}
		catch(Exception e)
		{
			resp							=	resp.change(500, resp, null);
		}
		
		return resp;
	}
	
	@RequestMapping(value = "/getAllBrandPartnersList")
	public @ResponseBody List<Partner> getAllBrandPartnersList(@RequestParam(value="type")String type,HttpServletResponse resp,HttpServletRequest req)
	{
		System.out.println("inside getAllBrandPartnersList");
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
        resp.setHeader("Access-Control-Max-Age", "3600");
        
        resp.setContentType("application/json");
        
		List<Partner> partnerList   = null;
		PersistenceManager pm 		= null;
		List<Partner> retval		= null;
		
		try
		{
			pm						= PMF.get().getPersistenceManager();
			Query q  				= pm.newQuery("select from "+Partner.class.getName()+" where status == '"+type+"'");				
//			q.setOrdering("dateRegistered desc");
			partnerList = (List<Partner>)q.execute();
			retval=(List<Partner>)pm.detachCopyAll(partnerList);
			
			log.info("the result-->"+retval.size());
		}
		catch(Exception e)
		{
			System.out.println("error-->"+e.getMessage());
			e.printStackTrace();
		}
		
		return partnerList;
	}

	@RequestMapping(value = "/approveOrDenyPartner")
	public @ResponseBody Boolean approveOrDenyPartner(@RequestParam(value="type")String type,@RequestParam(value="id")Long id,HttpServletResponse resp,HttpServletRequest req)
	{
		System.out.println("approveOrDenyPartner");
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
        resp.setHeader("Access-Control-Max-Age", "3600");
		Boolean action = false;
		PersistenceManager pm= null;
		try
		{
			
			Key key = KeyFactory.createKey(Partner.class.getSimpleName(), id);
			pm=PMF.get().getPersistenceManager();
			Partner partner=pm.getObjectById(Partner.class,key);
			if(type.equalsIgnoreCase("Approve"))
				partner.setStatus("approved");
			else if(type.equalsIgnoreCase("Deny"))
				partner.setStatus("denied");
			pm.makePersistent(partner);
			
//			MailingService.sendMail(type,"development@solestruck.com",partner);
			
			action = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return action;
	}
	
	@RequestMapping(value="/createSubMerchantAccount")
	public @ResponseBody void createSubMerchantAccount(HttpServletRequest req,HttpServletResponse resp,@RequestParam(value="id")Long id)
	{
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
        resp.setHeader("Access-Control-Max-Age", "3600");
        
        System.out.println("createSubMerchantAccount");
        
        Boolean smAccountCreated = false;
		PersistenceManager pm= null;
		BraintreeGateway gateway = null;
		MerchantAccountRequest request = null;
		try
		{
			Key key = KeyFactory.createKey(Partner.class.getSimpleName(), id);
			pm=PMF.get().getPersistenceManager();
			Partner partner=pm.getObjectById(Partner.class,key);
			
			
			if(partner!=null && partner.getType().equalsIgnoreCase("domestic") && !(partner.getSubMerchantAccCreated()))
			{
				System.out.println("inside partner");
				
				try
				{
					gateway = new BraintreeGateway(
							  Environment.SANDBOX,
							  "842f9ky698ykkp76",
							  "kdcxkrwppfbny6q3",
							  "6bd490438a4ccbccbf6c27587ca19361"
							);
					
					//individuals not collecting phone number
//					if(partner.getVenmoMobileNumber() !=0 || partner.getVenmoEmailID()!=null)
//					{
//						System.out.println("one");
//						request = new MerchantAccountRequest().individual()
//								 .firstName(partner.getFirstName())
//								 .lastName(partner.getLastName())
//								 .email(partner.getEmailID())
//								 .dateOfBirth(partner.getDOB().replace(" / ","-"))
//								 .address().streetAddress(partner.getAddress()).locality(partner.getCity()).region(partner.getState()).postalCode(partner.getZipCode().toString()).done().done()
//								 
//								 
//								 .funding()
//								 .destination(MerchantAccount.FundingDestination.BANK)
//								 .email(partner.getVenmoEmailID())
//								 .mobilePhone(partner.getVenmoMobileNumber().toString()).done()
//								 
//								 .masterMerchantAccountId("mh464nx9x38qz729").tosAccepted(true);
//					}
//					else
//					{
//						System.out.println("two");
//						request = new MerchantAccountRequest().individual()
//								 .firstName(partner.getFirstName())
//								 .lastName(partner.getLastName())
//								 .email(partner.getEmailID())
//								 .dateOfBirth(partner.getDOB().replace(" / ","-"))
//								 .address().streetAddress(partner.getAddress()).locality(partner.getCity()).region(partner.getState()).postalCode(partner.getZipCode().toString()).done().done()
//								 
//								 
//								 .funding()
//								 .destination(MerchantAccount.FundingDestination.BANK)
//								 .routingNumber(partner.getBankRoutingNo().toString())
//								 .accountNumber(partner.getBankAccountNo().toString()).done()
//								 
//								 .masterMerchantAccountId("mh464nx9x38qz729").tosAccepted(true);
//					}
					
					 request = new MerchantAccountRequest().individual().firstName("IreneC").lastName("ClareI").email("ireneclare.irudayaraj@a-cti.com").phone("6188065955").dateOfBirth("23-05-1992").address().streetAddress("350 5th Avenue, New York, New York").locality("Chennai").region("TN").postalCode("10118").done().done().funding().destination(MerchantAccount.FundingDestination.BANK).email("ireneclare.irudayaraj@a-cti.com").mobilePhone("6188065955").routingNumber("021000021").accountNumber("4003830171874018").done().masterMerchantAccountId("mh464nx9x38qz729").tosAccepted(true);
					
					Result<MerchantAccount> result = gateway.merchantAccount().create(request);
					System.out.println("status--->"+result.isSuccess());
					
					MerchantAccount ma = result.getTarget();
					
//					System.out.println("Merchant Status"+ma.getStatus()+"id::"+ma.getId()+"<---MM Id-->"+ma.getMasterMerchantAccount().getId()+"<--MMStatus-->"+ma.getMasterMerchantAccount().getStatus());
					
					if(result.isSuccess())
					{
						smAccountCreated = true;
					}
					
					if(result.getErrors() !=null)
					{
						for(ValidationError error:result.getErrors().getAllDeepValidationErrors())
						{
							System.out.println("what error-->"+error.getCode()+"::"+error.getMessage());
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/robots.txt")
	public @ResponseBody String robots(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String serverName=req.getServerName();
		System.out.println("********* serverName is ----->>>>>>>   :  "  +  serverName);

		if(System.getProperties().get("AppMode").equals("LIVE"))
		{
			StringBuffer buf=new StringBuffer();
			buf.append("User-agent: appspot\n");
			buf.append("Disallow: / \n");
			buf.append("User-agent: *\n");
			buf.append("Disallow: / \n");
			res.setContentType("text/plain");
			res.getOutputStream().write(buf.toString().getBytes());
			res.flushBuffer();
		}
		else if(System.getProperties().get("AppMode").equals("STAGING"))
		{
			StringBuffer buf=new StringBuffer();
			buf.append("User-agent: appspot\n");
			buf.append("Disallow: / \n");
			buf.append("User-agent: *\n");
			buf.append("Disallow: / \n");
			res.setContentType("text/plain");
			res.getOutputStream().write(buf.toString().getBytes());
			res.flushBuffer();
		}
		
		return null;
		
	}
	
	@RequestMapping(value="/thankyou")
	public String thankyou(HttpServletRequest req,HttpServletResponse resp)
	{
		return "thankyou";
	}
	
}

