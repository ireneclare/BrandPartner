"use strict";

(function($){
	
	var cache			=	{},
		partner			=	{};
	
	cache["email-rx"]	=	/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	cache['form'] 		=   $('div#partner-scope');
	
	$(".custom_select_value_act").change(function(input) {
		
		input = $(this);
		
		input.parent().parent().removeClass("error");
		 
		input.closest('div').find('p').html($(this).find("option:selected").text());
		
	});
	
	cache['form'].find('#paypal_url').on('click',function(){
		window.open('https://www.paypal.com/signup/account','Paypal signUp', 'width=500, height=400');
	});
	
    cache['form'].find('a.dont_taxid').on('click', function(element) {
    	
    	element = $(this);
    	element.parent().siblings('.partner-id').children('input').val("");
    	element.parent().siblings('.partner-id').children('input').removeClass('tick');
    	element.parent().siblings('.partner-id').children('input').removeClass('error');
    	if(element.attr('whatId') === "tax-id")
    	{
    		element.attr('whatId',"social-security");
    		element.html("Use Tax ID Instead");
    		
    		element.parent().siblings('.partner-id').children('input').attr('placeholder','000000000').attr('ajaxOject','social_security')
    												.siblings('small').text('Social Security#');
    		
    	}
    	else if(element.attr('whatId') === "social-security")
    	{
    		element.attr('whatId',"tax-id");
    		element.html("I don't have a Tax ID");
    		
    		element.parent().siblings('.partner-id').children('input').attr('placeholder','000000000').attr('ajaxOject','tax_id')
													.siblings('small').text('Tax ID');
    		
    	}
    });
    
	cache['form'].find('input[type=text]').each(function(input){
		
		input = $(this);
		
		if((input.attr('name') === "text") || (input.attr('name') === "number"))
		{
			input.on('blur',function(){
				if($(this).data('format') === "date")
				{
					var dtRegex = new RegExp(/\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/);
					
					console.log(dtRegex.test($(this).val()));
					
					if(dtRegex.test($(this).val()))
					{
						$(this).attr("class", "tick");
					}
					else
					{
						$(this).attr('class','error');
					}
				}
				else
				{
					if($.trim($(this).val()))
					{
						$(this).attr("class", "tick");
					}
					else
					{
						$(this).attr('class','error');
					}
				}
				
			});
			
			
			input.on("keyup", function(temp, value, result){
			       
			       temp                  =    $(this);
			       value                 =    temp.val().replace(/[^\w\s]/gi, '');
			       result                =    "";
			       
			       if(temp.attr("ajaxOject") === "venmo_mob")
			       {
			           value              =     value.replace(/ /g, '').substr(0, 10);
			           
			           if(value.length > 3)
			           {
			               result = "("+value.substr(0,3)+") - ";
			               value   = value.substr(3);
			           }
			           
			           if(value.length > 3)
			           {
			               result     +=    value.substr(0,3)+" - ";
			               value      =     value.substr(3);
			           }
			       }
			       else if(temp.attr("ajaxOject") === "poc_dob")
			       {
			           value              =     value.replace(/ /g, '').substr(0, 8);
			           
			           if(value.length > 2)
			           {
			               result         =    value.substr(0,2)+" / ";
			               value          =    value.substr(2);
			           }
			           
			           if(value.length > 3)
			           {
			               result     +=    value.substr(0,2)+" / ";
			               value      =     value.substr(2);
			           }
			       }
			       
			       if(value.length > 0)
			           result     +=    value;
			       
			      $(this).val(result);
			   
			   });
		}
		
		if(input.attr('name') === "number")
		{
			input.on("keydown", function(evt){
				
				var charCode					=	evt.which ? evt.which :	event.keyCode;
				
				if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode < 37 || charCode > 40))
				{
					return false;
				}	
				else
				{
					return true;
				}
				
			});
			
			input.on('blur',function(temp){
				
				temp	=	$(this);
				
				if(!temp.val() || (!temp.attr('limit') && temp.attr("maxlength") && temp.val().length < temp.attr("maxlength") ) )
					temp.attr('class','error');
				else
					temp.attr("class", "tick");
				
			});
			
		}
		else if(input.attr('name') === "email")
		{
			input.on('blur',function(input){
				
				input = $(this);
				
				if(cache["email-rx"].test(input.val()))
				{
					input.attr("class", "tick");
				}
				else
				{
					input.attr('class','error');
				}
				
			});
		}	
		
	});
	
	cache['form'].find('span.partner_ship').click(function(business, funding, BandF, poc, temp, isValid,errorPosition){
		
		$('#backgroundPopup').fadeIn().width($(document).width()).height($(document).height()).css('left','0px').css('position','fixed');
		
		 business        	= {};
		 funding         	= {};
		 BandF 				= {};
		 poc				= {};
		 isValid 			= false;
		 
		cache['form'].find('input').each(function(input, value){
			
			console.log(this)
			
			input			=	$(this);
			
			value			=	input.val();
			
			console.log("maxlength::"+input.val().length === input.attr("maxlength"));

			if(input.attr("type") === "checkbox")
			{
				if(input.is(":checked"))
					return;
				else
				{
					alert("Please read and agree to the Terms");
				}
			}	
			else if(input.attr("type") === 'text' && $.trim(value) && !( !input.attr('limit') && input.val().length  < input.attr("maxlength")) && (input.attr('name') !== "email" || cache["email-rx"].test(value)) && !(input.attr('ajaxoject') === "venmo_mob" && input.val().length < 18) && !(input.attr('ajaxoject') === "poc_dob" && input.val().length < 14)) 
			{
				console.log("inside this two");
				console.log(input.attr('name')+" ::: "+input.attr('name') !== "email" || cache["email-rx"].test(value))
//				if(input.attr('name') !== "email" || cache["email-rx"].test(value))
//				{
					  input.removeClass('error');
					  
					  if(input.data().mode === "poc")
					    poc[input.attr("ajaxOject").toLowerCase()] 					= 	value;
					
					if(partner.type === "domestic")
					{
						if(input.data().mode === "business")
							business[input.attr("ajaxOject").toLowerCase()]			=	value;
						else if(input.data().mode === "funding")
							funding[input.attr("ajaxOject").toLowerCase()]  		=	value
						
						partner["business"] 										= 	business;
						partner["funding"] 											= 	funding;
						
					}
					else if(partner.type === "international")
					{
						if(input.data().mode === "BandF")
							BandF[input.attr("ajaxOject").toLowerCase()]			=	value;
						
						partner["BandF"] 											= 	BandF;
					}
					
					console.log("object-->"+JSON.stringify(partner));
					
					partner["poc"] 		= 	poc;
//				}
				return;
			}	
			else if(input.attr("type") === 'no-text')
				return;
			
			if(!errorPosition)
			{
				errorPosition = $(this).offset().top;
			}
			input.attr('class','error');
			
			isValid				=	true;
		
		});
		
		if(partner.type === "domestic")
		{	
			temp				=	$("#state");

			if(temp.val())
				poc["state"]	=	temp.val();
			else
			{
				temp.parent().parent().addClass("error");
				
				isValid			=	true;
			}	
		}	
		else if(partner.type === "international")
		{
			temp				=	$("#country");
			
			if(temp.val())
				poc["country"]	=	temp.val();
			else
			{
				temp.parent().parent().addClass("error");
				
				isValid			=	true;
			}	
		}	
		
		console.log("no ajax--->"+isValid);
		
		if(!isValid)
		{
			console.log(partner)
			$('.loading_icon').show();
			$.post("/post/partnerRegistration",{data : JSON.stringify(partner)}, function(resp) {
				
				      partner ={};
				      
				      $('#partner-scope').attr('style', 'display: block !important; opacity: 0;')
				      $('.loading_icon').hide();
				      $('.Thanks_holder').show();
				      $(window).scrollTop(0);
			});
		}
		else
		{
			$(window).scrollTop(errorPosition);
			errorPosition  = undefined;
		}
		
	});
	
	cache["type-switch"]						=	cache['form'].find("ul.tryathome_bankselect_form > li");
	
	cache["type-switch"].each(function(){
		
		$(this).click(function(input, data,zip,value){
			
			input 	   			= 	$(this);
			
			data				=	input.data();
			
			if(data.type === "scope")
			{
				partner["type"] 	= 	data.name;
				
				cache['form'].attr("class", partner["type"]);
				
				cache[data.type+'-holder'].html(cache[data.name+"-"+data.type].clone(true, true)).queue(function(next) {
					
					if(data.name === "domestic")
						$("div#account-holder").siblings("ul.tryathome_bankselect_form.tryathome_bankselect_form1").find("li").first().trigger("click");
					
					next();
				});
				
				if(partner["type"] === "domestic")
				{
					cache["form"].find('#zip_code').attr('type','text').val("");
					cache["form"].find('#postal_code').attr('type','no-text');
					
					cache["form"].find("#birth_date").attr("type", "text").attr('name','text');
				}	
				else if(partner["type"] === "international")
				{
					cache["form"].find('#postal_code').attr('type','text').val("");
					cache["form"].find('#zip_code').attr('type','no-text');
					
					cache["form"].find("#birth_date").attr("type", "no-text").attr('name','no-text');
				}	
			}	
			else if(data.type === "account")
			{
				$("div#"+data.type+'-holder').html(cache[data.name+"-"+data.type].clone(true, true));
			}	
			
			input.attr("class", "active").siblings("li").removeAttr("class");
			
		});
		
	});
	
	 var body_win_height = parseInt(document.body.clientHeight) ;
	   var win_height = parseInt(document.documentElement.clientHeight) ;

		   if( body_win_height > win_height) {
			$('.background_bg').height(body_win_height);
		   } else {
			$('.background_bg').height(win_height);
		   }

		$(window).resize(function(){
		   var body_win_height = parseInt(document.body.clientHeight) ;
		   var win_height = parseInt(document.documentElement.clientHeight) ;

		   if( body_win_height > win_height) {
			$('.background_bg').height(body_win_height);
		   } else {
			$('.background_bg').height(win_height);
		   }
		}); 	
		
	$('#step_1').click(function(){
		$(this).parent('div.tryathome_partners_form_holder').hide();

		if($(this).siblings('ul').find('li.active').data('name') === "domestic")
	    	$('.step2of4').show();
	    else if($(this).siblings('ul').find('li.active').data('name') === "international")
	    	$('.step2of3').show();
	});
	
	$('#back_3').click(function(){
		
		$(this).parent('div.step2of3').hide();
		$('#navigation').show();
	});
	
	$('#back_1').click(function(){
		
		$(this).parent('div.step2of4').hide();
		$('#navigation').show();
	});
	
	$('#step_2').click(function(input,show){
		
		show  = false;
		
		cache['form'].find('input').each(function(value){
			
			input = $(this);
			value = input.val();
			
			if(input.attr('step') === "two")
			{
				if($.trim(value) && !( !input.attr('limit') && input.val().length  < input.attr("maxlength")))
				{
					return;
				}

				show = true;

				input.attr('class','error');
			}
		});
		
		console.log("show-->"+show);
		
		if(!show)
		{
			$(this).parent('div.step2of4').hide();
			
			if(partner.type === "domestic")
				$('.step3of4').show();
			else
				$('.step2of3').show();
		}
		
		
	});
	
	$('#step_3').click(function(input,show,temp,attri){
		
		temp	 	=	$(this).siblings('ul').find('li.active').data('name');
		show	 	=   false;
		
		if(temp === 'bank')
			attri 	= "three_bank";
		else
			attri 	= "three_venmo";
		
		console.log("attri--->"+attri);
		
		cache['form'].find('input').each(function(value){
			
			input 	= $(this);
			value 	= input.val();
			
			if(input.attr('step') === attri)
			{
				if($.trim(value) && !( !input.attr('limit') && input.val().length  < input.attr("maxlength")) && (input.attr('name') !== "email" || cache["email-rx"].test(value)) && !(input.attr('ajaxoject') === "venmo_mob" && input.val().length < 18) && !(input.attr('ajaxoject') === "poc_dob" && input.val().length < 14))
				{
					return;
				}
				
				show = true;
				
				input.attr('class','error');
			}
		});
		
		console.log("step show--->"+show);
		
		if(!show)
		{
			$(this).parent('div.step3of4').hide();
			$('.step_final').show();
		}
	});
	
	$('#step_4').click(function(input,show){
		
		show  = false;
		
		cache['form'].find('input').each(function(value){
			
			input = $(this);
			value = input.val();
			
			if(input.attr('step') === "four")
			{
				if($.trim(value) && (input.attr('name') !== "email" || cache["email-rx"].test(value)) && !(input.attr('ajaxoject') === "venmo_mob" && input.val().length < 18) && !(input.attr('ajaxoject') === "poc_dob" && input.val().length < 14))
				{
					return;
				}

				show = true;

				input.attr('class','error');
			}
		});
		
		console.log("show-->"+show);
		
		if(!show)
		{
			$(this).parent('div.step2of3').hide();
			$('.step_final').show();
		}
	});
	
	$('#back_2').click(function(){
		
		$(this).parent('div.step3of4').hide();
		$(this).parent('div.step3of4').siblings('div.step2of4').show();
	});
	
	$('#final_back').click(function(){
		$(this).parent('div.step_final').hide();
		if(partner.type === "domestic")
			$('.step3of4').show();
		else
			$('.step2of3').show();
	});
	
	$('#terms_condn').click(function(){
		$('.background_bg').css('display','block');
		$(window).scrollTop(0);
		$('#terms_popup').show();	
	});
	
	$('.close_act').click(function(){
		$('.background_bg').css('display','none');
		$(this).parent().hide();
		$("html, body").animate({ scrollTop: $(document).height() }, 1000);
	});
	
	cache['scope-holder']				=	cache['form'].find("div#scope-holder");
	cache['domestic-scope']				=	cache['scope-holder'].children("div#domestic").clone(true, true);
	cache['international-scope']		=	cache['scope-holder'].children("div#international").clone(true, true);
	
	cache["account-holder"]				=	cache['domestic-scope'].find("div#account-holder");
	cache['bank-account']				=	cache["account-holder"].children("ul.bank-details").clone(true, true);
	cache['venmo-account']				=	cache["account-holder"].children("ul.venmo-details").clone(true, true);
	
	cache['scope-holder'].html("");
	cache["account-holder"].html("");
	
	cache["type-switch"].first().trigger("click");
	
})($);