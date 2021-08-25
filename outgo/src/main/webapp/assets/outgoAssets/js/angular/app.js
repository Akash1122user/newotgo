////<reference path="angular.min.js">

var app = angular.module('myModule', ['ngCookies']);	
	app.controller('myController',[ '$scope', '$http','$filter', function($scope, $http, $filter) {
			$scope.list = [];
			$scope.headerText = 'AngularJS Post Form Spring MVC example My Form:Auther--Pranal Sawarkar';
			  $scope.data = {};// Form Data put it in 
			  $scope.que = {};// Form Data put it in 
			  $scope.arr = [];// Form Data put it in 			 
			  var city,area;
				var cityName,areaName;
	
							$scope.city = function() {
							$http({ method: 'POST', url: 'getMyCityArea'}).success(function(data, status, headers, config) {					
			        			//console.log("mydata--->"+data)
			        			var response =  angular.fromJson(data);
								 $scope.city = response;
								 //console.log("response--->"+response);			        			
							      }).error(function(data, status, headers, config) {				
							        if(status == 400) {					
							          $scope.messages = data;							
							        } else {							
							          alert('Unexpected server error.');    
							        }
							
							      });	
							};	
					$scope.getArea=function(){	
						
						var city_id=$scope.city_id;	
						var cityName=$("#cityID option:selected").text();
						$http.post('getMyCityArea?city_id='+city_id).
						  success(function(data, status, headers){
					        	    if(data){ 
					        	    	var response =  angular.fromJson(data);		        	    
					        	    $scope.areaText = response; 	
					        	  		        	   
					 					  //console.log(response);					        	          	    	
					        	    }else{
					        	   
					        	    }
					         });		
						
					};
					$scope.getAllMerchant=function(){
					$(".displayHidden").css("display","none");
					$(".display").css("display","block");
					var city_id=$scope.city_id;					
					var cityName=$("#cityID option:selected").text();	
					var area_Name = $("#area_id option:selected").text();					
					var area_id = $("#area_id option:selected").val(); // getting from cookies
					//alert("area_id all m--->"+area_id)
						if(typeof area_id === undefined || area_id == null || area_id==""){							
								area_id=null;
								city_id=null;				
								cityName=null;	
								area_Name =null;	
								 //var ucode=atob(b64)
							 	var areaID=atob(getCookie("areaID"));// getting cookie
							 	var areaName=atob(getCookie("areaName"));// getting cookie							    
							    var cityName=atob(getCookie("cityName"));// getting cookie
							    var cityID=atob(getCookie("cityID"));// getting cookie
								area_id = areaID;
								city_id = cityID;
								cityName = cityName;
								area_Name = areaName;
								
									//alert("undefined"+area_id);
							}
						
						$http.post('getServicesWIthMerchant?area_id='+area_id+'&s_id=0&mode=0').
						  success(function(data, status, headers){						  
					        	    if(data){
					        	    	var response =  angular.fromJson(data);	
					        	    	
					        	    	  if(response.length==0){
											  //alert("nodata"); // sweet alert// appear Choose City and Area
					        	    		  swal("Worning !", "No data found !", "error");
					        	    		  
					        	    		  //$(".displayHidden").css("display","block");
					        	    		 // $(".display").css("display","none");
										  }else{
											  $scope.allData = response;
											 // alert(allData.merchant_service_id)
											  var aName=btoa(area_Name)
											  var aId=btoa(area_id)
											  var cId=btoa(city_id)
											  var cName=btoa(cityName)
											  
											 /* var b64=btoa(string);
												 var ucode=atob(b64);*/
												 
												 
							        		    setCookie("areaName", aName, 90);// setting cookie
								        	    setCookie("areaID", aId, 90);// setting cookie
								        	    setCookie("cityName", cName, 90);// setting cookie
								        	    setCookie("cityID", cId, 90);// setting cookie
								        	    $('.myCityName').html(cityName);
								        	    $('.serviceArea').html(cityName+" ("+area_Name+")");
								        	    $('#squarespaceModalCityAndArea').modal('hide');
										  }
					        		     //console.log("all data merchant---"+response);					        	          	    	
					        	    }else{
					        	    // alert(data+"nodata1")
					        	    }
					        	    $scope.getMerchantService();
					         });
						
					};
				   $scope.getMerchantService=function(){ 
					   var area_id=atob(getCookie("areaID")); // getting from cookies Side Navebar
					  
					   $http.post('getServiceToPay?area_id='+area_id).
						  success(function(data, status, headers){
					        	    if(data){ var response =  angular.fromJson(data);		        	    
					        	    $scope.serviceData = response; 	    			        	    
					 					  //console.log(response);
					 					
					        	    }else{
					        	    	alert(data+"nodata2")
					        	    }
					         });	
				   };
				   $scope.getMyService=function(s_id){
					   //alert(data);
					   var area_id=atob(getCookie("areaID")); //get cookies
					   //var area_id = $("#area_id option:selected").val();// please getting from cookies
					   $http.post('getServicesWIthMerchant?area_id='+area_id+'&s_id='+s_id+'&mode=1').
						  success(function(data, status, headers){
					        	    if(data){ 
					        	    	var response =  angular.fromJson(data);	
					        	    	
					        	    	if(response==null || response==""){
					        	    		$('#myMsg').css("display","block");
					        	    		$('#displayStrip').css("display","none");
					        	    	} else{
					        	    		$('#myMsg').css("display","none");
					        	    		$('#displayStrip').css("display","block");
					        	    		$scope.allData = response;
					        	    	}	  
					 					 setCookie("sId", s_id, 90);//get cookies
					        	    }else{
					        	   
					        	    }
					         });
					   
				   };
				   
				  
				   $scope.complaint=function(data){
					  // alert(data.gst_tax+" comp")//
					   $('#access_key_com').val(data.access_key);
					   $('#url_com').val(data.merchant_key_url);
					   $('#Compservice').val(data.merchant_service_id);
					   
					    $('#squarespaceModalComp').modal({
					         backdrop: 'static',
					         keyboard: false
					     });
					 
					   
				   };
				   
				   $scope.logcomplain=function() {// validation
					   var url=$('#url_com').val();
					   var CompMobile=$('#CompMobile').val();
					    var CompName=$('#CompName').val();
						var Compemail=$('#Compemail').val();
						
						var CompDesc=$('#CompDesc').val();
						
					
					
					var flag=true;
					if(IsValidateMob(CompMobile)==false){
						$('[data-toggle="CompMobile"]').tooltip(); 
						$('#CompMobile').focus();
						flag=false;
					}
					else if(!CompName){
						$('[data-toggle="CompName"]').tooltip(); 
						$('#CompName').focus();
						flag=false;
					}
					
					else if(IsvalidEmail(Compemail)==false){
						$('[data-toggle="Compemail"]').tooltip(); 
						$('#Compemail').focus();
						flag=false;
						} 
					
					
					else if(!CompDesc){
						$('[data-toggle="CompDesc"]').tooltip(); 
						$('#CompDesc').focus();
						flag=false;
					}
					if(flag){
					   
					   
					   var form = $('#comp')[0];
					   //console.log(form)
					   var data = new FormData(form);					  
					    var ajaxReq = $.ajax({
						    type        : 'POST',
						    url         : 'newMessage/'+url,//access_key,customer_mobile,customer_email
						    data        : data,//$("#comp").serialize()
						    dataType    : 'json',
						    cache       : false,
						    contentType : false,
						    processData : false,						   
						    		 xhr: function(){						       	
							         var xhr = $.ajaxSettings.xhr() ;						       	
							         xhr.upload.onprogress = function(event){
							         };
							         return xhr ;
							    	},
							    	beforeSend: function( xhr ) { }
							    });						 
							    ajaxReq.done(function(jqXHR) {
							    	 $('#comp')[0].reset();						 
							    	  	alert("success "+jqXHR)	//sweet alert	     
							   
							    });						   
							    ajaxReq.fail(function(jqXHR) {
							    	
							    	 $('#comp')[0].reset();	
							      if(jqXHR.status==200){
							    	  //alert("success-->")//sweet alert
							    	    $('#squarespaceModalComp').modal('hide');
							      }							    	
							    	
							    });
							   
					}
					   
				   };
				   
				   $scope.funtush=function(){
					   $('#squarespaceModalCityAndArea').modal({
					         backdrop: 'static',
					         keyboard: false
					     });
				   };
				   $scope.search=function(mode){
					   var searchKey=$scope.customer_mobile;
					   
					   if(mode=="msg"){
					   var url=$('#url_com').val();
					   var s_id=$('#Compservice').val();
					   var access_key=$('#access_key_com').val();
					   
					   
					   //alert("msg--->"+url+"----"+s_id+"---"+access_key+"---"+searchKey);
					   }
					   if(mode=="pay"){
						   var url=$('#url_ld01').val();
						   var s_id=$('#merchant_service_id_ld01').val();
						   var access_key=$('#access_key_ld01').val();
						  // alert("msg--->"+url+"----"+s_id+"---"+access_key+"---"+searchKey);
					   }
					   
					   
						 $http({method:'POST',url:'searchUser/'+url+'?access_key='+access_key+'&service_code='+s_id+'&user_key='+searchKey}).success(function(data,status,header,config){
					   
							 var response =  angular.fromJson(data);							 
							 if(response.length!="0"){
								 if(mode=="msg"){
								 $('#Compemail').val(response.merchant_customer_email).trigger("change");
								 $('#CompName').val(response.merchant_customer_name).trigger("change");
								 $('#ref_id_com').val(response.merchant_customer_id).trigger("change");
								 //console.log("if-->"+response);
								 }
								 if(mode=="pay"){
									 $('#email_ld01').val(response.merchant_customer_email).trigger("change");
									 $('#name_ld01').val(response.merchant_customer_name).trigger("change");
									 $('#ref_id_ld01').val(response.merchant_customer_id).trigger("change");
									 $('#mobile_ld01').val(response.merchant_customer_mobile).trigger("change");
									 $('#address_ld01').val(response.merchant_customer_address).trigger("change");
									 $('#amount_ld01').val(response.merchant_customer_amount).trigger("change");
									// $('#amount_ld01').val(response.merchant_customer_id).trigger("change");
									 //console.log("if-->"+response); 
								 }
							 }else{
								 $scope.myArray = "";
								 //console.log("else-->"+response);
							 }
							 
							 
							
							 }).error(function (data,status,header,config) {
								 //swal("User not found!", " ", "error");
								
							 });
					   
				   };
				   $scope.enquiry=function(){ // make it validate client side
						//alert('ok')
						
					   var EnqName=$("#EnqName").val();
					   var EnqMobile=$("#EnqMobile").val();
					   var Enqemail=$("#Enqemail").val();
					   var EnqDesc=$("#EnqDesc").val();
					  
					   
					   //var name=$("#EnqMobile").val();
					   
					   var flag=true;
					   if(!EnqName){
							$('[data-toggle="EnqName"]').tooltip(); 
							$('#EnqName').focus();
							flag=false;
						}
						
						else if(IsValidateMob(EnqMobile)==false){
							$('[data-toggle="EnqMobile"]').tooltip(); 
							$('#EnqMobile').focus();
							flag=false;
						}
						
						else if(IsvalidEmail(Enqemail)==false){
							$('[data-toggle="Enqemail"]').tooltip(); 
							$('#Enqemail').focus();
							flag=false;
							} 
						
						
						else if(!EnqDesc){
							$('[data-toggle="EnqDesc"]').tooltip(); 
							$('#EnqDesc').focus();
							flag=false;
					}
						
						if(flag){
					   
						 $.ajax({
						    type        : 'POST',
						    url         : 'outgoEnq',
						    data        : $("#enq").serialize(),
						    dataType    : 'json',
						    success     : function(data) {
						    	if(data){
						    		//console.log(data.msg);
						    		swal({
						    			  title: "Good job!",
						    			  text: "Enquiry has been successfully sent!",
						    			  icon: "success",
						    			  button: "OK !",
						    			});
						    		// use sweet alert enqFrm
						    		 $('#enq')[0].reset();
						    	}else{
						    		 swal("Sorry Something Wrong!", " ", "error");
						    	}
						    	
						    	
						    	
						    }
						 });
						}
				   };

				   $scope.payNowModel=function(data){
						  // alert(data.gst_tax+" PayNow")
					   $('#payBillFrmBr')[0].reset();
					   
					   $('.serviceToPayDisplay').html("-"+data.merchant_business_name);
						   	var urlLocal="paybillOutgo/"+data.merchant_key_url;
							//var urlLive=""https://www.outgo.co/pay/"+data.merchant_key_url;						   	
						   //	$("#payBillFrmBr").attr("action",urlLive);
						  	$("#payBillFrmBr").attr("action",urlLocal);
						   	$('#merchant_id_ld01').val(data.merchant_id);
						 	$('#access_key_ld01').val(data.access_key);
						 	$('#merchant_service_id_ld01').val(data.merchant_service_id);
						 	$('#url_ld01').val(data.merchant_key_url);
						 	
							$('#payBillFrmBr').val(urlLocal);
							//$('#gst_pr').val(data.gst_tax)
						   	if(data.service_name!="Broadband"){
						   		
						   	 	if(data.merchant_id=="80" && data.merchant_service_id=="46"){
						   	 	
						   	  $('#myModalLD01').modal({
							         backdrop: 'static',
							         keyboard: false
							     });
							   	}else{
						   		
						   		$(".plan").css("display","none");
								  $("#amount_ld01").css("width","100%");	
								  $("#amount_ld01").css("margin-bottom","12px");	
								  $("#space").css("display","none");
								  $("#planName_ld01").attr("placeholder","Remark");
								  $("#userId_ld01").attr("placeholder","SubscriberId/LandlineNo/IntercomNo");
								  $('#squarespaceModalPay').modal({
								         backdrop: 'static',
								         keyboard: false
								     });
							   	}
						   	}else{
						   		$(".plan").css("display","block");
								  $("#amount_ld01").css("width","70%");	
								  $("#amount_ld01").css("margin-top","0px");	
								  $("#space").css("display","block");
								  $("#planName_ld01").attr("placeholder","Plan Name");
								  $("#userId_ld01").attr("placeholder","User Id");
								  $('#squarespaceModalPay').modal({
								         backdrop: 'static',
								         keyboard: false
								     });
						   	
						   	}
						   	
						 
							
							
						 
					   };
					   $scope.payNow=function(mode){
						   
						   var userId=$('#userId_ld01').val();
						   	var name=$('#name_ld01').val();
							var email=$('#email_ld01').val();
							var mobile=$('#mobile_ld01').val();
							var amount=$('#amount_ld01').val();
							var address=$('#address_ld01').val();
							var planName=$('#planName_ld01').val();
						
						var flag=true;
						
						if(!userId){
							$('[data-toggle="userId_ld01"]').tooltip(); 
							$('#userId_ld01').focus();
							flag=false;
						}
						else if(!name){
							 $('[data-toggle="name_ld01"]').tooltip(); 
					 		$('#name_ld01').focus();
					 		flag=false;
						 }
						 
						else if(IsvalidEmail(email)==false){
							$('[data-toggle="email_ld01"]').tooltip(); 
							$('#email_ld01').focus();
							flag=false;
							} 
						else if(IsValidateMob(mobile)==false){
							$('[data-toggle="mobile_ld01"]').tooltip(); 
							$('#mobile_ld01').focus();
							flag=false;
						}
						else if(!address){
							 $('[data-toggle="address_ld01"]').tooltip(); 
					 		$('#address_ld01').focus();
					 		flag=false;
						 }
						else if(!amount){
							$('[data-toggle="amount_ld01"]').tooltip(); 
							$('#amount_ld01').focus();
							flag=false;
						}
						
						else if(!planName){
							$('[data-toggle="planName_ld01"]').tooltip(); 
							$('#planName_ld01').focus();
							flag=false;
						}
						if(flag){
						   
						   
				
							   $('#payBillFrmBr').submit();
				
						   
						}
					   };
					   $scope.selectPlan=function(plan,json){
						   	
						  
						 /*  $scope.gst=parseInt($('#gst_pr').val());
						   $scope.amount=parseInt(plan.amount);						   
						  $scope.gstAmt= $scope.amount*$scope.gst/100;
						  $scope.tot=$scope.gstAmt+$scope.amount;*/
						   //alert("data plan-->"+plan.amount+"--v-"+json.validity+"--gst--"+$scope.gst)
						  //alert($scope.tot)						   
						   $('#validity_ld01').val(json.validity).trigger("change");
						   $('#amount_ld01').val(plan.amount).trigger("change");
						   $('#planName_ld01').val(plan.subcategory).trigger("change");						   
						   $('#myModalPlan').modal('hide');
					   };					   
					   $scope.getPlan=function(type){
						   $scope.plan = ""; 
						   var mid=$('#merchant_id_ld01').val();
						   var s_id=$('#merchant_service_id_ld01').val();
						   $scope.getPlanType();
						   $('#myModalPlan').modal({
						         backdrop: 'static',
						         keyboard: false
						     });
						   $http({method:'POST',url:'getPlan?merchant_key='+mid+'&service_code='+s_id+'&type='+type}).success(function(data,status,header,config){
							   var response =  angular.fromJson(data);	
							   //console.log("data pTy-->"+data); 
								 if(response.length!="0"){
									  $scope.plan = response; 	    	
										 //console.log("if plan-->"+response); 
									
								 }else{
									  $scope.plan = response; 
									 $scope.myArray = "";
									 //console.log("else plan-->"+response);
								 }
						   
					   })
					   
						   
					   };
					   $scope.getPlanType=function(){
						   var mid=$('#merchant_id_ld01').val();
						   var s_id=$('#merchant_service_id_ld01').val();
						  // var access_key=$('#access_key_ld01').val();
						   $scope.planType ="";  
						   $http({method:'POST',url:'getType?merchant_key='+mid+'&service_code='+s_id}).success(function(data,status,header,config){
							   var response =  angular.fromJson(data);	
							   //console.log("data pTy-->"+data); 
								 if(response.length!="0"){
									  $scope.planType = response; 	    	
										 //console.log("if pTy-->"+response); 
									
								 }else{
									 $scope.myArray = "";
									 //console.log("else PTY-->"+response);
								 }
						   
					   })
					  
					   };
				   
				   //Allow Number Only
				   $scope.filterValue = function($event){
				        if(isNaN(String.fromCharCode($event.keyCode))){
				            $event.preventDefault();
				        }
				   };
				   // parsing nested  json
				   $scope.parJson = function(json) {
					      return angular.fromJson(json);
					    }
					}]);
	
	
	
	
	// Avoid Duplication
	/*app.filter('unique', function() {
		 
		   return function(collection, keyname) {
		      
		      var output = [], 
		          keys = [];
		      
		      
		      angular.forEach(collection, function(item) {
		          
		          var key = item[keyname];
		          
		          if(keys.indexOf(key) === -1) {
		            
		              keys.push(key); 
		             
		              output.push(item);
		          }
		      });
		     
		      return output;
		   };
		});
	*/
	
	
	function setCookie(cname,cvalue,exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires=" + d.toGMTString();
	    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

	function getCookie(cname) {
	    var name = cname + "=";
	    var decodedCookie = decodeURIComponent(document.cookie);
	    var ca = decodedCookie.split(';');
	    for(var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	}
	function checkCookie() {
		  var areaName=atob(getCookie("areaName"));
		    var areaID=atob(getCookie("areaID"));
		    var cityName=atob(getCookie("cityName"));
		    var cityID=atob(getCookie("cityID"));
	    //var sId=atob(getCookie("sId"));
	    //alert("areaId--checkcookie---"+areaID+"--aname-"+areaName);
	   // alert("cityID--checkcookie---"+cityID+"--cityName-"+cityName);    
	    
	    if (cityID != "" && cityName !="" && areaID != "" && areaName != "") {       
	    	$(".displayHidden").css("display","none");
			$(".display").css("display","block");
			 var aName=btoa(areaName)
			  var aId=btoa(areaID)
			  var cId=btoa(cityID)
			  var cName=btoa(cityName)
			 setCookie("areaName", aName, 90);
			 setCookie("areaID", aId, 90);
			 setCookie("cityName", cName, 90);
			 setCookie("cityID", cId, 90);
			 //setCookie("sId", sId, 90);
			 $('.serviceArea').html(cityName+" ("+areaName+")");
			 $('.myCityName').html(cityName);
			 var scope = angular.element(document.getElementById("area_id")).scope();
			    scope.$apply(function () {
			    scope.getAllMerchant();
			    });//you can call angular function like this.
			
		    } else {
		    	//alert("null cookie")
		    	 $('.myCityName').html("Select City");
		    	 $('#squarespaceModalCityAndArea').modal({
			         backdrop: 'static',
			         keyboard: false
			     });
		    }
	    

	}
	//mobile validation
	function IsValidateMob(mobno){
		
		var mobno=mobno.trim();
		var flag=true;
		if(!(mobno.length==10))  
		 	flag=false;
		if(isNaN(mobno))
			flag=false;
		if (!flag){
			 return false;
		 }
		}
	//email validation
	function IsvalidEmail(mailid) {
		 //console.log("call"+mailid)
		var str = mailid
		 var flag = true;
		 var at = "@";
		 var dot = ".";
		 var lat = str.indexOf(at)
		 var lstr = str.length
		 var ldot = str.indexOf(dot)
		 var lastDotPos = str.lastIndexOf('.');
		 var outputString = '';
		 
		 for(var i=parseInt(lastDotPos)+1; i<str.length;i++)
		 { 
		   outputString = outputString + str[i];
		 }
		 
		 if (str.indexOf(at) == -1)
		  flag = false;
		 if (str.indexOf(at) == -1 || str.indexOf(at) == 0
		   || str.indexOf(at) == lstr)
		  flag = false;
		 if (str.indexOf(dot) == -1 || str.indexOf(dot) == 0
		   || str.indexOf(dot) == lstr)
		  flag = false;
		 if (str.indexOf(at, (lat + 1)) != -1)
		  flag = false;
		 if (str.substring(lat - 1, lat) == dot
		   || str.substring(lat + 1, lat + 2) == dot)
		  flag = false;
		 if (str.indexOf(dot, (lat + 2)) == -1)
		  flag = false;
		 if (str.indexOf(" ") != -1)
		  flag = false;
		 
		 if(!(outputString=="com"||outputString=="in"||outputString=="co"||outputString=="shiksha"||outputString=="info"||outputString=="org"||outputString=="net"||outputString=="edu"||outputString=="ac"||outputString=="gen"||outputString=="tel"||outputString=="biz"))
			 flag=false;
		
		 if (!flag){
				//console.log(flag)
				 return false;
			  
			 }
		}
