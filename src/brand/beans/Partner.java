package brand.beans;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author irene
 *
 */
@PersistenceCapable(detachable = "true")
public class Partner implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String type ;
	
	@Persistent
	private String businessName ;
	
	@Persistent
	private Long taxID  = 0l;  
	
	@Persistent
	private Long socialSecurityID ;
	
	@Persistent
	private Long bankAccountNo = 0l;
	
	@Persistent
	private Long bankRoutingNo = 0l;
	
	@Persistent
	private String firstName ;
	
	@Persistent
	private String lastName ;
	
	@Persistent
	private String emailID ;
	
	@Persistent
	private String city ;
	
	@Persistent
	private String state ;
	
	@Persistent
	private String zipCode ;
	
	@Persistent
	private String venmoEmailID ;
	
	@Persistent
	private Long venmoMobileNumber = 0l;
	
	@Persistent
	private String bandfName ;
	
	@Persistent
	private String bandFpayPalEmailID ;
	
	@Persistent
	private String intlCountry ;

	@Persistent
	private String status;
	
	@Persistent
	private Date dateRegistered;
	
	@Persistent
	private String DOB;

	public Boolean getSubMerchantAccCreated() {
		return subMerchantAccCreated;
	}

	public void setSubMerchantAccCreated(Boolean subMerchantAccCreated) {
		this.subMerchantAccCreated = subMerchantAccCreated;
	}

	@Persistent
	private String address;
	
	@Persistent
	private String ipAddress;
	
	@Persistent
	private String place;
	
	@Persistent
	private Boolean subMerchantAccCreated;
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTaxID() {
		return taxID;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Long getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(Long bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public Long getBankRoutingNo() {
		return bankRoutingNo;
	}

	public void setBankRoutingNo(Long bankRoutingNo) {
		this.bankRoutingNo = bankRoutingNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTaxID(Long taxID) {
		this.taxID = taxID;
	}

	public Long getSocialSecurityID() {
		return socialSecurityID;
	}

	public void setSocialSecurityID(Long socialSecurityID) {
		this.socialSecurityID = socialSecurityID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVenmoEmailID() {
		return venmoEmailID;
	}

	public void setVenmoEmailID(String venmoEmailID) {
		this.venmoEmailID = venmoEmailID;
	}

	public Long getVenmoMobileNumber() {
		return venmoMobileNumber;
	}

	public void setVenmoMobileNumber(Long venmoMobileNumber) {
		this.venmoMobileNumber = venmoMobileNumber;
	}

	public String getBandfName() {
		return bandfName;
	}

	public void setBandfName(String bandfName) {
		this.bandfName = bandfName;
	}

	public String getBandFpayPalEmailID() {
		return bandFpayPalEmailID;
	}

	public void setBandFpayPalEmailID(String bandFpayPalEmailID) {
		this.bandFpayPalEmailID = bandFpayPalEmailID;
	}

	public String getIntlCountry() {
		return intlCountry;
	}

	public void setIntlCountry(String intlCountry) {
		this.intlCountry = intlCountry;
	}

		
	

}

