////<reference path="angular.min.js">

var app = angular.module('myModule', ['ngCookies']);	
	app.controller('myController',[ '$scope', '$http','$filter', function($scope, $http, $filter) {
			$scope.list = [];
			$scope.headerText = 'AngularJS Post Form Spring MVC example My Form:Auther--Pranal Sawarkar';
			  $scope.data = {};// Form Data put it in 
			  $scope.que = {};// Form Data put it in 
			  $scope.arr = [];// Form Data put it in 
			  
			  // ------cookies section
			  
			//  $scope.myCookieVal=$cookies.get('cookie');
			 /* $scope.SetCookies=function(){
				  $cookieStore.put("userName",$cookies.userName);
			  };
			  $scope.GetCookies=function(){
				  $window.alert($cookieStore.get("userName"));
			  };
			  $scope.ClearCookies=function(){
				  $cookieStore.remove("userName");
			  };*/
			  
			  //----!end of cookies
			  var city,area;
				var cityName,areaName;
	
							$scope.city = function() {
							$http({ method: 'POST', url: 'getMyCityArea'}).success(function(data, status, headers, config) {					
			        			console.log("mydata--->"+data)
			        			var response =  angular.fromJson(data);
								 $scope.city = response;
								 console.log("response--->"+response);			        			
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
					        	    if(data){ var response =  angular.fromJson(data);		        	    
					        	    $scope.areaText = response; 	
					        	  		        	   
					 					  console.log(response);					        	          	    	
					        	    }else{
					        	   
					        	    }
					         });		
						
					};
					$scope.getService=function(){
					$(".displayHidden").css("display","none");
					$(".display").css("display","block");
					var city_id=$scope.city_id;	
					var cityName=$("#cityID option:selected").text();
						var area_id = $("#area_id option:selected").val(); // getting from cookies
						var area_Name = $("#area_id option:selected").text();
						$http.post('getServicesWIthMerchant?area_id='+area_id+'&s_id=0&mode=0').
						  success(function(data, status, headers){						  
					        	    if(data){
					        	    	var response =  angular.fromJson(data);	
					        	    	
					        	    	  if(response.length==0){
											  //alert("nodata"); // sweet alert// appear Choose City and Area
					        	    		  $(".displayHidden").css("display","block");
					        	    		  $(".display").css("display","none");
										  }else{
											  $scope.allData = response;
											 // alert(allData.merchant_service_id)
							        		    setCookie("areaName", area_Name, 90);
								        	    setCookie("areaID", area_id, 90);
								        	    setCookie("cityName", cityName, 90);
								        	    setCookie("cityID", city_id, 90);
										  }
					        		     console.log("all data"+response);					        	          	    	
					        	    }else{
					        	     alert(data+"nodata1")
					        	    }
					        	    $scope.getMerchantService();
					         });
						
					};
				   $scope.getMerchantService=function(){ 
					   var area_id=getCookie("areaID"); // getting from cookies
					   $http.post('getServiceToPay?area_id='+area_id).
						  success(function(data, status, headers){
					        	    if(data){ var response =  angular.fromJson(data);		        	    
					        	    $scope.serviceData = response; 	    			        	    
					 					  console.log(response);
					 					
					        	    }else{
					        	    	alert(data+"nodata2")
					        	    }
					         });	
				   };
				   $scope.getMyService=function(s_id){
					   //alert(data);
					   var area_id=getCookie("areaID");
					   //var area_id = $("#area_id option:selected").val();// please getting from cookies
					   $http.post('getServicesWIthMerchant?area_id='+area_id+'&s_id='+s_id+'&mode=1').
						  success(function(data, status, headers){
					        	    if(data){ var response =  angular.fromJson(data);	   
					        		    $scope.allData = response; 	    			        	    
					 					  console.log("all data"+response);
					 					 setCookie("sId", s_id, 90);
					        	    }else{
					        	   
					        	    }
					         });
					   
				   };
				   
				   $scope.payNow=function(data){
					   alert(data.gst_tax+" PayNow")
				   };
				   $scope.complaint=function(data){
					   alert(data.gst_tax+" comp")
				   };
				   
				   

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
	    var areaName=getCookie("areaName");
	    var areaID=getCookie("areaID");
	    var cityName=getCookie("cityName");
	    var cityID=getCookie("cityID");
	    var sId=getCookie("sId");
	    
	    if (cityID != "" && cityName !="" && areaID != "" && areaName != "") {       
	    	$(".displayHidden").css("display","none");
			$(".display").css("display","block");
			 var scope = angular.element(document.getElementById("area_id")).scope();
			    scope.$apply(function () {
			    scope.getMyService(sId);
			    });//you can call angular function like this.
			
		    } else {
		    	alert("null cookie")
		    }
	    
/*	    var cityName=getCookie("cityName");
	    var areaName=getCookie("areaName");
	    var serviceCode1,areaCode1;
	    serviceCode1=getCookie("serviceCode");;//seting the values
	    areaCode1=getCookie("areaCode");;
	    if (city != "") {       
	      $('#demo').html(cityName);//seting the values
	      $('#areaLbl').html(areaName);
	       
	    } else {
	      
	    $('#myModal').modal({
	            backdrop: 'static',
	            keyboard: false
	        });
	       if (city != "" && city != null) {
	    	   //alert("1")
	           setCookie("city", city, 90);
	           setCookie("area", area, 90);
	           setCookie("cityName", cityName, 90);
	           setCookie("areaName", areaName, 90);
	       }if(areaCode1 != "" && areaCode1 != null){
	    	   
	    	   //alert("2")
	    	   setCookie("serviceCode",serviceCode1 , 90);
				setCookie("areaCode",areaCode1 , 90);
	    	   
	       }if(serviceCode1 != "" && serviceCode1 != null){
	    	  // alert("3")
	    	   setCookie("serviceCode",serviceCode1 , 90);
				setCookie("areaCode",areaCode1 , 90);
	    	   
	       }
	    }*/
	}

	