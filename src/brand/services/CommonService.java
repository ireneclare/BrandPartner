package brand.services;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import brand.beans.PMF;
import brand.beans.Partner;
import brand.utils.Response;


public class CommonService {

	
	private CommonService(){}
		
	private static CommonService	instance;
	
	public static synchronized CommonService instance()
	{
		if(instance == null)
			instance					=	new CommonService();
		
		return instance;
	}
	
	public void partnerRegistration(HttpServletRequest request,Response resp, JSONObject data)
	{
		System.out.println("inside the registration service::"+data);
		
		Partner partner = new Partner();
		
		try
		{
			PersistenceManager pm		=	PMF.get().getPersistenceManager();
			JSONObject poc 				= new JSONObject(data.getString("poc"));
			System.out.println("poc-->"+poc);
			partner.setStatus("new");
			partner.setDateRegistered(new Date());
			partner.setType(data.getString("type"));
			partner.setFirstName(poc.getString("first_name"));
			partner.setLastName(poc.getString("last_name"));
			partner.setEmailID(poc.getString("poc_email"));
			partner.setSubMerchantAccCreated(false);
			
			if(poc.has("state"))
			    partner.setState(poc.getString("state"));
			
			partner.setCity(poc.getString("city"));
			
			if(poc.has("zip_code"))
				partner.setZipCode(poc.getString("zip_code"));
			
			if(poc.has("postal_code"))
				partner.setZipCode(poc.getString("postal_code"));
			
			if(poc.has("country"))
				partner.setIntlCountry(poc.getString("country"));
					
			partner.setAddress(poc.getString("street"));
			
			if(data.getString("type").equalsIgnoreCase("domestic"))
			{
				JSONObject business = new JSONObject(data.getString("business"));
				JSONObject funding = new JSONObject(data.getString("funding"));
				
				System.out.println("business-->"+business+"--funding--"+funding+"poc"+poc);
			
				partner.setBusinessName(business.getString("business_name"));
				
				if(business.has("tax_id"))
					partner.setTaxID(business.getLong("tax_id"));
				if(business.has("social_security"))
					partner.setSocialSecurityID(business.getLong("social_security"));
				if(funding.has("account_number"))
					partner.setBankAccountNo(funding.getLong("account_number"));
				if(funding.has("rounting_number"))
					partner.setBankRoutingNo(funding.getLong("rounting_number"));
				if(poc.has("poc_dob"))
					partner.setDOB(poc.getString("poc_dob"));
				if(funding.has("venmo_email"))
					partner.setVenmoEmailID(funding.getString("venmo_email"));
				
				if(funding.has("venmo_mob"))
				{
					String venMob  = funding.getString("venmo_mob").replaceAll("\\D+","");
					System.out.println("venMob-->"+venMob.trim());
					partner.setVenmoMobileNumber(Long.parseLong(venMob.trim()));
				}
			}
			else if(data.getString("type").equalsIgnoreCase("international"))
			{
				JSONObject businessAndFund = new JSONObject(data.getString("BandF"));
				
				if(businessAndFund.has("intl_business_name"))
					partner.setBandfName(businessAndFund.getString("intl_business_name"));
				
				if(businessAndFund.has("intl_email"))
				    partner.setBandFpayPalEmailID(businessAndFund.getString("intl_email"));
			}
			
			
			if(request.getHeader("X-AppEngine-Country") != null)
			{
				partner.setPlace(request.getHeader("X-AppEngine-Country"));
			}
			
			pm.makePersistent(partner);
			
			System.out.println("after persisting");
			String name = "docusign";
			
//			MailingService.sendMail(name,"development@solestruck.com",partner);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
