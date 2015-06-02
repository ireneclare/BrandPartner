package brand.services;

import java.io.StringWriter;
import java.util.logging.Logger;

import javax.mail.internet.InternetAddress;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONObject;

import brand.beans.Partner;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;


public class MailingService 
{
	private static final Logger log=Logger.getLogger(MailingService.class.getName());
	
	private MailingService() {};
	
	private static MailingService mailing		=	null;
	
	private static VelocityEngine ve			=	null;
	
	public static synchronized MailingService instance()
	{
		if(mailing == null)
			mailing				=	new MailingService();
		
		return mailing;
	}
	
	private static synchronized VelocityEngine ve()
	{
		if(ve == null)
		{
			ve					=	new VelocityEngine();
			ve.init();
		}
		
		return ve;
	}
	
	public static StringWriter setVelocityValues(JSONObject velocityObj)
	{
		 System.out.println("the velocity json--->"+velocityObj);
		 Template t 					= 	null;
		 VelocityContext context 	 	=	new VelocityContext();
		 
		 
		 try
		 {
			 String purpose   			= 	velocityObj.has("purpose")  ? velocityObj.getString("purpose")  : ""; 
			 String partnerID   			= 	velocityObj.has("PartnerID")  ? velocityObj.getString("PartnerID")  : "";
			 
			 if(purpose.equalsIgnoreCase("approved"))
			 {
				 System.out.println(("inside regirstration template"));
//				 t						=	ve().getTemplate( "/vm/template-widgets.vm" );
				 
				 context.put("type", purpose);
				 context.put("PartnerID", partnerID);
			 }	
			 else if(purpose.equalsIgnoreCase("docusign"))
			 {
				 System.out.println(("inside docusign template"));
//				 t						=	ve().getTemplate( "/vm/power_form.vm" );
			 }
			 
			 StringWriter writer 		=	new StringWriter();
			 
			 t.merge( context, writer );
			 System.out.println("after merging the context to the writer");
			 return writer;
			  
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 return null;
	}
	
	public static JSONObject setMailParameters(String mailName,String emailId)
	{
		if(mailName.equalsIgnoreCase("approved"))
		{
			String fromAddress  		= "ireneclare.irudayaraj@a-cti.com";
		  	String subject   			= "Your Registration has been approved";
		  	String toAddress			=  emailId;
		  	JSONObject mailObject		=  new JSONObject();
		  	
		  	try
		  	{
		  		mailObject.put("fromAddress", fromAddress);
			  	mailObject.put("subject", subject);
			  	mailObject.put("toAddress", toAddress);
		  	}
		  	catch(Exception e)
		  	{
		  		e.printStackTrace();
		  	}
		  	
		  	System.out.println("mail params added successfully");
		  	
		  	return mailObject;
		}
		else if(mailName.equalsIgnoreCase("docusign"))
		{
			String fromAddress  		= "ireneclare.irudayaraj@a-cti.com";
		  	String subject   			= "Solestruck Brand Partner Agreement";
		  	String toAddress			=  emailId;
		  	JSONObject mailObject		=  new JSONObject();
		  	
		  	try
		  	{
		  		mailObject.put("fromAddress", fromAddress);
			  	mailObject.put("subject", subject);
			  	mailObject.put("toAddress", toAddress);
		  	}
		  	catch(Exception e)
		  	{
		  		e.printStackTrace();
		  	}
		  	
		  	log.info("mail params added successfully");
		  	
		  	return mailObject;
		}
		
		return null;
	}
	
	public static void sendMail(String mailName,String emailId,Partner partner)
	{
			System.out.println("inside sending mail--"+mailName+"::emailId::"+emailId);
			MailService mailService 			= MailServiceFactory.getMailService();
			JSONObject velocityObj 				= new JSONObject();
			MailService.Message message 		= new MailService.Message();
		  
		  try
		  {
			  JSONObject mailParameters 		= setMailParameters(mailName,partner.getEmailID());
			  log.info("sender address-->"+mailParameters.getString("fromAddress"));
			  message.setSender(new InternetAddress("Bryce.Morrow@solestruck.com","Solestruck").toString());
			  velocityObj.put("purpose", mailName);
			  velocityObj.put("PartnerID", partner.getKey().getId());
			  StringWriter writer				=	setVelocityValues(velocityObj);
			  StringBuffer buffer 				=	new StringBuffer(writer.toString());
			  log.info("buffer-->"+buffer);
			  message.setTo(mailParameters.getString("toAddress"));
			  message.setSubject(mailParameters.getString("subject"));
			  message.setHtmlBody(buffer.toString());
			  
			  Boolean mailSent = false;
			  
			  try
			  {
				  mailService.send(message);  
				  mailSent = true;
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
				  mailSent = false;
			  }
			  
			  log.info("is mail sent-->"+mailSent);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	}
}
