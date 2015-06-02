<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head><script async="" src="PAPERMAG_files/linksmart_2.js"></script><script src="PAPERMAG_files/widgets.js" id="twitter-wjs"></script> 
<link href="PAPERMAG_files/css.css" rel="stylesheet" type="text/css">
<meta charset="utf-8"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script src="//use.typekit.net/avn5kiy.js"></script>
  <script>try{Typekit.load();}catch(e){}</script>
<link rel="stylesheet" type="text/css" href="/partners_style.css">
<script type="text/javascript" src="/jquery.js"></script>
<script type="text/javascript" src="/jquery-ui.js"></script>
<link rel="icon" href="https://commondatastorage.googleapis.com/images2.solestruck.com/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  
  
</head>

<style type="text/css">
	
	#partner-scope {display : block !important;}

	.domestic, .international {display : none;}

	#partner-scope.domestic .domestic {display : block !important}
	#partner-scope.international .international {display : block !important}
	
	#funding_info.bank .bank {display : inline-block !important}
	#funding_info.venmo .venmo {display : inline-block !important}
	
	.state.domestic.error .custome_dropdown_holder{border : 0px !important;}
	
</style>
<body style="font-family:proxima-nova;">
	
	<div class="bfh-selectbox bfh-countries" data-country="US" data-flags="true"></div>
	
	<div class="tryathome_partner_header">
		<img src="https://storage.googleapis.com/images2.solestruck.com/gae/newdesign/logo_white_new.png" />
		<h4>Partner Application</h4>
	</div>
	<div class="background_bg" style="display:none"></div>
	<div class="popup" id="terms_popup">
		<code class="close_popup close_act"></code>
		<h3>Terms & Conditions</h3>
		<p>Solestruck uses Braintree, a division of Paypal, Inc. (Braintree) for payment processing. In order for you to use Braintree's payment processing services, you must enter into the Merchant Services Agreement (MSA) with Braintree and its sponsoring bank. The MSA is available at <a href="http://www.braintreepayments.com/agreements/merchant" target="blank">www.braintreepayments.com/agreements/merchant.</a></p>
		<p>By accepting this Agreement, you agree: (a) that you have downloaded or printed the MASA, and (b) that you have reviewed and agree to the MSA. Please note that Solestruck is not a party to the MSA and that you, Braintree and Braintree's sponsorting bank are the three parties to the MSA and that Solestruck has no obligations or liability to you under the MSA. If you have questions regarding the MSA, please contact Braintree at 877.434.2894.</p>
	</div>
	
	<div class="tryathome_partners_form_holder Thanks_holder" style="display:none;">
       <h3>Thank you!</h3>
       <p>Next, you'll receive an email to prompt you to digitally sign our Brand Partner Agreement. We'll also keep in touch about further steps for selling your products as a Solestruck Partner.</p>
       <p>If you have any questions in the meantime, please contact us via email or call (800) 494 - 1260.</p>
        <ul>
           <li><a style="text-decoration: none;" href="mailto:bryce@solestruck.com,alex.gallatin@solestruck.com?cc=sole.email@solestruck.com"><span>Contact Us</span></a><li>
       </ul> 
	</div><!-- Thanks_holder -->

	<div id="partner-scope" class="wrapper tryathome_partners_form_wrapper" holder="wrapper_holder">
	
		<div class="tryathome_partners_form_holder" id="navigation">
		
			<h5 class="domestic">STEP 1/4</h5>
			<h5 class="international">STEP 1/3</h5>
			
			<h3>Apply To Become A Partner</h3>
			<p>Is your bank located in the United States or is it<br/> outside of the USA?</p>
			<ul class="tryathome_bankselect_form">
				<li data-type="scope" data-name="domestic">
					Bank in the united states
				</li>
				<li data-type="scope" data-name="international">
					Bank outside of the usa
				</li>
			</ul>
			<h2 id="step_1" class="next_btn">Next</h2>
			<div class="clear_both"></div>
			
		</div>
		
		<hr>
		
		<div>
			
			<div id="scope-holder">
			
				<div id="domestic">
					
					<div id="Business_info" class="tryathome_partners_form_holder step2of4">
						<h5>STEP 2/4</h5>
						<h3>Business Info</h3>
						<p>This is how we verify you're a real business.</p>
						<ul>
							<li>
								<small>Legal Business Name </small>
								<input type="text" data-mode="business" name="text" placeholder="Business Name" ajaxOject="Business_Name" step="two"/>
		                    </li>
		                    <li class="taxid partner-id" >
		                        <small>Tax ID </small>
		                        <input type="text" data-mode="business" name="number" placeholder="000000000" ajaxOject="tax_id"  maxlength="9" step="two"/>
		                    </li>
		                    <li><a href="javascript:void(0);" class="dont_taxid" whatId="tax-id">I don't have a Tax ID</a><li>
		                </ul>
		                <h2 id="back_1" class="back_button">Back</h2>
		                <h2 id="step_2" class="next_button">Next</h2>
		                <div class="clear_both"></div>
	             	</div>
	             	
	             	<hr>
	             	
	             	<div class="tryathome_partners_form_holder step3of4" id="funding_info">
	             		<h5>STEP 3/4</h5>
	                	<h3>Funding Info</h3>
	                	<p>This is how we send money from sales to you. Either connect to your bank or Venmo account.</p>
	                	<ul class="tryathome_bankselect_form tryathome_bankselect_form1">
	                    	<li data-type="account" data-name="bank">
	                        	Bank
	                    	</li>
	                    	<li data-type="account" data-name="venmo">
	                        	Venmo
	                    	</li>
	                	</ul>
	                	
	                	<div class="clear_both"></div>
	                	
	                	<div id="account-holder">
	                		<ul class="bank-details bank">
		                    	<li>
		                        	<small>Bank Account Number </small>
		                        	<input type="text" limit="no-limit" name="number" maxlength="20" data-mode="funding" ajaxOject="account_number" placeholder="0000000000"  step="three_bank"/>
		                    	</li>
		                    	<li>
		                        	<small>Bank Routing Number </small>
		                        	<input type="text" name="number" data-mode="funding" ajaxOject="rounting_number" maxlength="9" placeholder="0000000000"  step="three_bank"/>
		                    	</li>
		                	</ul>
		                	<ul class="venmo-details venmo">
			                    <li>
			                        <small>Your Venmo Email </small>
			                        <input type="text" name="email" data-mode="funding" ajaxOject="venmo_email" placeholder="email@site.com"  step="three_venmo"/>
			                    </li>
			                    <li>
			                        <small>Your Mobile Phone Number </small>
			                        <input type="text"  name="number" data-mode="funding" ajaxOject="venmo_mob" placeholder="(xxx)-xxx-xxxx"  step="three_venmo"/>
			                    </li>
		                	</ul>
	                	</div>
	                	
	                	<div class="clear_both"></div>
	                	
	                	<h2 id="back_2" class="back_button">Back</h2>
	                	<h2 id="step_3" class="next_button">Next</h2>
	                	<div class="clear_both"></div>
	            	</div>
				</div>
				
		     	<div id="international" class="tryathome_partners_form_holder step2of3">
		     		<h5>STEP 2/3</h5>
	                <h3>Business & Funding Info</h3>
	                <p>For International Partners, we currently can only send funds to a paypal account where <b>you can then transfer funds to your bank.</b></p>
	                <ul>
	                    <li>
	                        <small>Legal Business Name </small>
	                        <input type="text" placeholder="Business Name"  ajaxOject="intl_business_name" name="text" data-mode="BandF" step="four"/>
	                    </li>
	                    <li>
	                        <small>Paypal Email </small>
	                        <input type="text" placeholder="example@site.com"  ajaxOject="intl_email" data-mode="BandF" name="email" step="four"/>
	                    </li>
	                    <li><a href id="paypal_url">Don't have Paypal? Create account here.</a><li>
	                </ul>
	                	<h2 id="back_3" class="back_button">Back</h2>
	                	<h2 id="step_4" class="next_button">Next</h2>
	                <div class="clear_both"></div>
	            </div>
	            
			</div>
			
        	<hr>
		
			<div class="tryathome_partners_form_holder step_final" id="point_of_contact">
			
                <h5 class="domestic">STEP 4/4</h5>
                <h5 class="international">STEP 3/3</h5>
                
                <h3>Point Of Contact</h3>
                <p>Contact info to know who we're talking to. We don't use this information for transactions.</p>
                <ul>
                    <li>
                        <small>First Name </small>
                        <input type="text" placeholder="John" ajaxOject="First_Name" data-mode="poc" name="text" />
                    </li>
                    <li>
                        <small>Last Name </small>
                        <input type="text" placeholder="Doe" ajaxOject="Last_Name" data-mode="poc" name="text" />
                    </li>
                    <li>
                        <small>Email </small>
                        <input type="text" placeholder="name@example.com" ajaxOject="poc_email" data-mode="poc" name="email" />
                    </li>
                    <li class="domestic">
                        <small>Date Of Birth  (for security purposes only) </small>
                        <input type="text" id="birth_date" ajaxOject="poc_dob" data-mode="poc" data-format="date" name="number" placeholder="MM / DD / YYYY" />
                    </li>
                    <li class="street ">
                        <small>Mailing Address </small>
                        <input type="text" ajaxOject="street" placeholder="123 Normal Street" data-mode="poc" name="text" />
                    </li>
                    <li>
                        <small>City </small>
                        <input type="text" placeholder="City Name" ajaxOject="city" data-mode="poc" name="text" />
                    </li>
                    <li class="state domestic" >
                        <small>State </small>
                        <div class="custome_dropdown_holder">
                        	<div>
                        		<p style="color: black;">Please Select ...</p>
                        		<code></code>
                        	</div>
                        	<select class="custom_select_value_act" name="state" id="state">
    							<option value="">Select State</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option>
							</select>
                        </div>
                    </li>
                   
                    <li class="country international">
                        <small>Country </small>
                        <div class="custome_dropdown_holder">
                        	<div>
                        		<p style="color: black;">Please Select ...</p>
                        		<code></code>
                        	</div>
                            <code></code>
                            <select class="custom_select_value_act" id="country" name="country">
								<option value="">Select Country</option><option value="Afghanistan">Afghanistan</option><option value="Albania">Albania</option><option value="Algeria">Algeria</option><option value="American Samoa">American Samoa</option><option value="Angola">Angola</option><option value="Anguilla">Anguilla</option><option value="Antartica">Antartica</option><option value="Antigua and Barbuda">Antigua and Barbuda</option><option value="Argentina">Argentina</option><option value="Armenia">Armenia</option><option value="Aruba">Aruba</option><option value="Ashmore and Cartier Island">Ashmore and Cartier Island</option><option value="Australia">Australia</option><option value="Austria">Austria</option><option value="Azerbaijan">Azerbaijan</option><option value="Bahamas">Bahamas</option><option value="Bahrain">Bahrain</option><option value="Bangladesh">Bangladesh</option><option value="Barbados">Barbados</option><option value="Belarus">Belarus</option><option value="Belgium">Belgium</option><option value="Belize">Belize</option><option value="Benin">Benin</option><option value="Bermuda">Bermuda</option><option value="Bhutan">Bhutan</option><option value="Bolivia">Bolivia</option><option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option><option value="Botswana">Botswana</option><option value="Brazil">Brazil</option><option value="British Virgin Islands">British Virgin Islands</option><option value="Brunei">Brunei</option><option value="Bulgaria">Bulgaria</option><option value="Burkina Faso">Burkina Faso</option><option value="Burma">Burma</option><option value="Burundi">Burundi</option><option value="Cambodia">Cambodia</option><option value="Cameroon">Cameroon</option><option value="Canada">Canada</option><option value="Cape Verde">Cape Verde</option><option value="Cayman Islands">Cayman Islands</option><option value="Central African Republic">Central African Republic</option><option value="Chad">Chad</option><option value="Chile">Chile</option><option value="China">China</option><option value="Christmas Island">Christmas Island</option><option value="Clipperton Island">Clipperton Island</option><option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option><option value="Colombia">Colombia</option><option value="Comoros">Comoros</option><option value="Congo, Democratic Republic of the">Congo, Democratic Republic of the</option><option value="Congo, Republic of the">Congo, Republic of the</option><option value="Cook Islands">Cook Islands</option><option value="Costa Rica">Costa Rica</option><option value="Cote d'Ivoire">Cote d'Ivoire</option><option value="Croatia">Croatia</option><option value="Cuba">Cuba</option><option value="Cyprus">Cyprus</option><option value="Czeck Republic">Czeck Republic</option><option value="Denmark">Denmark</option><option value="Djibouti">Djibouti</option><option value="Dominica">Dominica</option><option value="Dominican Republic">Dominican Republic</option><option value="Ecuador">Ecuador</option><option value="Egypt">Egypt</option><option value="El Salvador">El Salvador</option><option value="Equatorial Guinea">Equatorial Guinea</option><option value="Eritrea">Eritrea</option><option value="Estonia">Estonia</option><option value="Ethiopia">Ethiopia</option><option value="Europa Island">Europa Island</option><option value="Falkland Islands (Islas Malvinas)">Falkland Islands (Islas Malvinas)</option><option value="Faroe Islands">Faroe Islands</option><option value="Fiji">Fiji</option><option value="Finland">Finland</option><option value="France">France</option><option value="French Guiana">French Guiana</option><option value="French Polynesia">French Polynesia</option><option value="French Southern and Antarctic Lands">French Southern and Antarctic Lands</option><option value="Gabon">Gabon</option><option value="Gambia, The">Gambia, The</option><option value="Gaza Strip">Gaza Strip</option><option value="Georgia">Georgia</option><option value="Germany">Germany</option><option value="Ghana">Ghana</option><option value="Gibraltar">Gibraltar</option><option value="Glorioso Islands">Glorioso Islands</option><option value="Greece">Greece</option><option value="Greenland">Greenland</option><option value="Grenada">Grenada</option><option value="Guadeloupe">Guadeloupe</option><option value="Guam">Guam</option><option value="Guatemala">Guatemala</option><option value="Guernsey">Guernsey</option><option value="Guinea">Guinea</option><option value="Guinea-Bissau">Guinea-Bissau</option><option value="Guyana">Guyana</option><option value="Haiti">Haiti</option><option value="Heard Island and McDonald Islands">Heard Island and McDonald Islands</option><option value="Holy See (Vatican City)">Holy See (Vatican City)</option><option value="Honduras">Honduras</option><option value="Hong Kong">Hong Kong</option><option value="Howland Island">Howland Island</option><option value="Hungary">Hungary</option><option value="Iceland">Iceland</option><option value="India">India</option><option value="Indonesia">Indonesia</option><option value="Iran">Iran</option><option value="Iraq">Iraq</option><option value="Ireland">Ireland</option><option value="Ireland, Northern">Ireland, Northern</option><option value="Israel">Israel</option><option value="Italy">Italy</option><option value="Jamaica">Jamaica</option><option value="Jan Mayen">Jan Mayen</option><option value="Japan">Japan</option><option value="Jarvis Island">Jarvis Island</option><option value="Jersey">Jersey</option><option value="Johnston Atoll">Johnston Atoll</option><option value="Jordan">Jordan</option><option value="Juan de Nova Island">Juan de Nova Island</option><option value="Kazakhstan">Kazakhstan</option><option value="Kenya">Kenya</option><option value="Kiribati">Kiribati</option><option value="Korea, North">Korea, North</option><option value="Korea, South">Korea, South</option><option value="Kuwait">Kuwait</option><option value="Kyrgyzstan">Kyrgyzstan</option><option value="Laos">Laos</option><option value="Latvia">Latvia</option><option value="Lebanon">Lebanon</option><option value="Lesotho">Lesotho</option><option value="Liberia">Liberia</option><option value="Libya">Libya</option><option value="Liechtenstein">Liechtenstein</option><option value="Lithuania">Lithuania</option><option value="Luxembourg">Luxembourg</option><option value="Macau">Macau</option><option value="Macedonia, Former Yugoslav Republic of">Macedonia, Former Yugoslav Republic of</option><option value="Madagascar">Madagascar</option><option value="Malawi">Malawi</option><option value="Malaysia">Malaysia</option><option value="Maldives">Maldives</option><option value="Mali">Mali</option><option value="Malta">Malta</option><option value="Man, Isle of">Man, Isle of</option><option value="Marshall Islands">Marshall Islands</option><option value="Martinique">Martinique</option><option value="Mauritania">Mauritania</option><option value="Mauritius">Mauritius</option><option value="Mayotte">Mayotte</option><option value="Mexico">Mexico</option><option value="Micronesia, Federated States of">Micronesia, Federated States of</option><option value="Midway Islands">Midway Islands</option><option value="Moldova">Moldova</option><option value="Monaco">Monaco</option><option value="Mongolia">Mongolia</option><option value="Montserrat">Montserrat</option><option value="Morocco">Morocco</option><option value="Mozambique">Mozambique</option><option value="Namibia">Namibia</option><option value="Nauru">Nauru</option><option value="Nepal">Nepal</option><option value="Netherlands">Netherlands</option><option value="Netherlands Antilles">Netherlands Antilles</option><option value="New Caledonia">New Caledonia</option><option value="New Zealand">New Zealand</option><option value="Nicaragua">Nicaragua</option><option value="Niger">Niger</option><option value="Nigeria">Nigeria</option><option value="Niue">Niue</option><option value="Norfolk Island">Norfolk Island</option><option value="Northern Mariana Islands">Northern Mariana Islands</option><option value="Norway">Norway</option><option value="Oman">Oman</option><option value="Pakistan">Pakistan</option><option value="Palau">Palau</option><option value="Panama">Panama</option><option value="Papua New Guinea">Papua New Guinea</option><option value="Paraguay">Paraguay</option><option value="Peru">Peru</option><option value="Philippines">Philippines</option><option value="Pitcaim Islands">Pitcaim Islands</option><option value="Poland">Poland</option><option value="Portugal">Portugal</option><option value="Puerto Rico">Puerto Rico</option><option value="Qatar">Qatar</option><option value="Reunion">Reunion</option><option value="Romainia">Romainia</option><option value="Russia">Russia</option><option value="Rwanda">Rwanda</option><option value="Saint Helena">Saint Helena</option><option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option><option value="Saint Lucia">Saint Lucia</option><option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option><option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option><option value="Samoa">Samoa</option><option value="San Marino">San Marino</option><option value="Sao Tome and Principe">Sao Tome and Principe</option><option value="Saudi Arabia">Saudi Arabia</option><option value="Scotland">Scotland</option><option value="Senegal">Senegal</option><option value="Seychelles">Seychelles</option><option value="Sierra Leone">Sierra Leone</option><option value="Singapore">Singapore</option><option value="Slovakia">Slovakia</option><option value="Slovenia">Slovenia</option><option value="Solomon Islands">Solomon Islands</option><option value="Somalia">Somalia</option><option value="South Africa">South Africa</option><option value="South Georgia and South Sandwich Islands">South Georgia and South Sandwich Islands</option><option value="Spain">Spain</option><option value="Spratly Islands">Spratly Islands</option><option value="Sri Lanka">Sri Lanka</option><option value="Sudan">Sudan</option><option value="Suriname">Suriname</option><option value="Svalbard">Svalbard</option><option value="Swaziland">Swaziland</option><option value="Sweden">Sweden</option><option value="Switzerland">Switzerland</option><option value="Syria">Syria</option><option value="Taiwan">Taiwan</option><option value="Tajikistan">Tajikistan</option><option value="Tanzania">Tanzania</option><option value="Thailand">Thailand</option><option value="Tobago">Tobago</option><option value="Toga">Toga</option><option value="Tokelau">Tokelau</option><option value="Tonga">Tonga</option><option value="Trinidad">Trinidad</option><option value="Tunisia">Tunisia</option><option value="Turkey">Turkey</option><option value="Turkmenistan">Turkmenistan</option><option value="Tuvalu">Tuvalu</option><option value="Uganda">Uganda</option><option value="Ukraine">Ukraine</option><option value="United Arab Emirates">United Arab Emirates</option><option value="United Kingdom">United Kingdom</option><option value="Uruguay">Uruguay</option><option value="Uzbekistan">Uzbekistan</option><option value="Vanuatu">Vanuatu</option><option value="Venezuela">Venezuela</option><option value="Vietnam">Vietnam</option><option value="Virgin Islands">Virgin Islands</option><option value="Wales">Wales</option><option value="Wallis and Futuna">Wallis and Futuna</option><option value="West Bank">West Bank</option><option value="Western Sahara">Western Sahara</option><option value="Yemen">Yemen</option><option value="Yugoslavia">Yugoslavia</option><option value="Zambia">Zambia</option><option value="Zimbabwe">Zimbabwe</option>
							</select>
                        </div>
                    </li>
                    <li class="domestic">
                        <small>Zipcode </small>
                        <input id="zip_code" type="text" maxlength="5" placeholder="000000" ajaxOject="zip_code" data-mode="poc" name="number" />
                    </li>
                    <li class="international">
                        <small>Postal Code </small>
                        <input id="postal_code" type="text" placeholder="000000" limit="no-limit" maxlength="10" ajaxOject="postal_code" data-mode="poc" name="text" />
                    </li>
                    <li style="font-size:13px; padding:30px 0px;">
                    <input type="checkbox"> By checking, you agree to our <u id="terms_condn" style="color:#b2b2b2; cursor:pointer;">Terms</u></input>
					<span class="partner_ship">Submit</span>	
                    </li>
                </ul>
                <h2 id="final_back" class="back_btn">Back</h2>
            </div><!-- tryathome_partners_form_holder -->
	 	</div>	
	</div>

	<div class="loading_icon"></div>
	<script type="text/javascript" src="/formSumbit.js"></script>
	
</body>
</html>