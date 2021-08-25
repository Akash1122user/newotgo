<!doctype html>
<html lang="en" data-ng-app="myModule">


<head>

<title>OutGo | User-Home</title>

<link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<meta content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay" name="description">
<meta content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent." name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.min.css"
	media="screen">
<jsp:include page="shortcontaint/css.jsp"></jsp:include>
 <jsp:include page="shortcontaint/links.jsp"></jsp:include>
  

<jsp:include page="shortcontaint/analyticScript.jsp"></jsp:include>
<style>
.vl {
    border-left: 6px solid #eee;
    height: 80px;
}
.n{
	border-bottom-style: solid !important;
 border-bottom-color: #eee !important;
 }
 
 
 
</style>

<style type="text/css">
.bs-calltoaction{
    position: relative;
    width:auto;
    padding: 5px 15px;
    border: 1px solid black;
    margin-top: 10px;
    margin-bottom: 10px;
    border-radius: 5px;
}

    .bs-calltoaction > .row{
        display:table;
        width: calc(100% + 30px);
    }
     
        .bs-calltoaction > .row > [class^="col-"],
        .bs-calltoaction > .row > [class*=" col-"]{
            float:none;
            display:table-cell;
            vertical-align:middle;
        }

            .cta-contents{
                padding-top: 10px;
                padding-bottom: 10px;
            }

                .cta-title{
                    margin: 0 auto 15px;
                    padding: 0;
                }

                .cta-desc{
                    padding: 0;
                }

                .cta-desc p:last-child{
                    margin-bottom: 0;
                }

            .cta-button{
                padding-top: 10px;
                padding-bottom: 10px;
            }

@media (max-width: 991px){
    .bs-calltoaction > .row{
        display:block;
        width: auto;
    }

        .bs-calltoaction > .row > [class^="col-"],
        .bs-calltoaction > .row > [class*=" col-"]{
            float:none;
            display:block;
            vertical-align:middle;
            position: relative;
        }

        .cta-contents{
            text-align: center;
        }
}



.bs-calltoaction.bs-calltoaction-default{
    color: #333;
    background-color: #fff;
    border-color: #ccc;
}

.bs-calltoaction.bs-calltoaction-primary{
    color: #fff;
    background-color: #337ab7;
    border-color: #2e6da4;
}

.bs-calltoaction.bs-calltoaction-info{
    color: #fff;
    background-color: #5bc0de;
    border-color: #46b8da;
}

.bs-calltoaction.bs-calltoaction-success{
    color: #fff;
    background-color: #5cb85c;
    border-color: #4cae4c;
}

.bs-calltoaction.bs-calltoaction-warning{
    color: #fff;
    background-color: #f0ad4e;
    border-color: #eea236;
}

.bs-calltoaction.bs-calltoaction-danger{
    color: #fff;
    background-color: #d9534f;
    border-color: #d43f3a;
}

.bs-calltoaction.bs-calltoaction-primary .cta-button .btn,
.bs-calltoaction.bs-calltoaction-info .cta-button .btn,
.bs-calltoaction.bs-calltoaction-success .cta-button .btn,
.bs-calltoaction.bs-calltoaction-warning .cta-button .btn,
.bs-calltoaction.bs-calltoaction-danger .cta-button .btn{
    border-color:#fff;
}


</style>
</head>
<body  onload="javascript:chooseStyle('blue', 60);checkCookie()"  data-ng-controller="myController"  data-ng-init="city()">

	<div id="container">

		<header class="clearfix n" >

			<div class="top-bar">
			<jsp:include page="shortcontaint/top.jsp"></jsp:include>
			</div>


			<div class="navbar navbar-default navbar-top" role="navigation"
				data-spy="affix" data-offset-top="50">
				 
	<jsp:include page="shortcontaint/header.jsp"></jsp:include>

			</div>

		</header>


		<%-- <div class="page-banner"
			style="padding: 40px 0; background: url(<%=request.getContextPath()%>/assets/outgoAssets/images/banner2.jpg) center #f9f9f9;background-size: cover; opacity: 2.5;">
		
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h2 style="color: #fff">USER</h2>
					</div>
					<div class="col-md-6">
						<ul class="breadcrumbs">
							<li><a href="home" style="color: #fff">Home</a></li>
							<li style="color: #fff">User</li>
						</ul>
					</div>
				</div>
			</div>
		</div> --%>


		<div id="content" style="margin-top: -50px">
			<div class="container displayHidden" id="find-city" style="display: block;"> <!--! css  -->
				<div class="row sidebar-page">
				<div class="col-md-12">
							<div class="col-md-3 col-md-offset-3 image-service-box" style="margin-top: 10px;width: 180px;height: 68px;"> 
							<img alt="" class="responsive"
							src="<%=request.getContextPath()%>/assets/outgoAssets/images/outgo.png"  >
							</div>
							
					<div class="col-md-3 vl" style="margin-top: 5px;"> 
					<!-- <div class="vl"></div> -->
					<h1 style="font-weight: bold;color: #87c43c;font-size: xx-large;padding-top: 25px">
						Find Your City  
						</h1>
						
					</div>
					</div>
					<!-- forms  -->
					<div class="col-md-12" style="padding-top: 20px" >
					<div class="col-md-6 col-md-offset-3" style="padding-bottom: 10px" id="myCity">
					<div class="widget widget-search">
							<form action="#">
								<!-- <input type="text" id="" class="form-control" placeholder="Enter your City"> -->
								<select class="js-example-basic-single form-control" data-ng-model="city_id" id="cityID" name="city_id" data-ng-change="getArea()" id="city">
								 <option value="">Select City </option>
  							<option data-ng-repeat="obj in city | orderBy : 'city_name'" value="{{obj.city_id}}">{{obj.city_name}}</option>  
							</select>
							
							</form>
						</div>
						</div>
						<br>
						<div class="col-md-6 col-md-offset-3" style="padding-bottom: 10px;display: block;" id="myArea">
					<div class="widget widget-search">
							<form action="#">
							<!-- 	<input type="text" class="form-control" placeholder="Enter your Area"> -->
								<!-- <select class="js-example-basic-single form-control" name="area" id="yourArea">
  							
							</select> -->
								 <select class="js-example-basic-single form-control"  data-ng-modal="area_id" name="area_id"  id="area_id"  >
                                            	<option value="">Select Area </option>
                                            	<option data-ng-repeat="areaObj in areaText | orderBy:'area_name'" value="{{areaObj.area_id}}">{{areaObj.area_name}}</option> 
                                            </select>
							</form>
							
						</div>
						
					<!-- 	{{myCookieVal}}dfhdt<br>
						
						
						<input type="text" data-ng-model="userName"><br>
						<button type="button" data-ng-click="SetCookies()">set Cookies Value</button>&nbsp;
						<button type="button" data-ng-click="GetCookies()">get Cookies Value</button>&nbsp;
						<button type="button" data-ng-click="ClearCookies()">clear Cookies Value</button> -->
						</div>
						<div class="col-md-6 col-md-offset-3" style="padding-bottom: 10px">
					
						<input class="btn-system btn-large" type="button" value="find" style="max-width: 100%;display: block;" data-ng-click="getService()" id="findBtn">
						</div>
					</div>
				</div>
			</div>
			
			
			<!-- Display Content Search -->
			
			<div class="container display" id="display-services" style="padding-top: 20px;display: none;"><!--! css  -->





				<div class="row sidebar-page">

					<div class="col-md-3 sidebar left-sidebar">

						<div class="widget widget-search">
							<form action="#">
								<input type="search" placeholder="Enter Keywords...">
								<button class="search-btn" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>

						<div class="widget widget-categories">
							<h4>
								Services in <span class="head-line serviceArea" ></span>
							</h4>
							
							<ul  data-ng-repeat="item in serviceData ">
								<li><a href="#" data-ng-click="getMyService(item.service_id)">{{item.service_name}}</a></li>								
								
								</ul>
							
							
						
						</div>

						
						

						
					</div>


					<div class="col-md-9 page-content">

						<h4 class="classic-title">
							<span>Operators</span>
						</h4>

						<div class="col-sm-12" id="displayStrip" data-ng-repeat="mdata in allData" > <!-- Append Strip  -->

                <div class="bs-calltoaction bs-calltoaction-default">
                    <div class="row">
                        <div class="col-md-10 cta-contents">
                           
                            <div class="cta-desc">
                               <div class="col-md-12">
                               <div class="col-md-10">
                               <div class="col-md-4">
                               <img style="height: 114px" src="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/{{mdata.merchant_service_logo}}" alt="{{mdata.merchant_business_name}}">
                               </div>
                               <div class="col-md-8">
                             
                               <h1 class="cta-title businessName">{{mdata.merchant_business_name}}</h1>
                              <p id="serviceToPay">{{mdata.service_name}} </p>
                              <p id="businessArea">{{mdata.address_desc}}</p>
                               </div>
                               </div>
                                <!-- <div class="col-md-2 vl">
                                
                                </div> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2 vl cta-button">
                            <a  class="btn btn-lg btn-block btn-info" data-ng-click="payNow(mdata)">Pay Now!</a>
                             <a  class="btn btn-lg btn-block btn-default" data-ng-click="complaint(mdata)">Complaint!</a>
                        </div>
                     </div>
                </div>



            		</div>
						<div class="hr5" style="margin-top: 30px; margin-bottom: 45px;"></div>

	

					</div>

				</div>

			</div>
			
			
			
			</div>
		


		<footer>
			<jsp:include page="shortcontaint/footer.jsp"></jsp:include>
		</footer>

	</div>



	<jsp:include page="shortcontaint/models.jsp"></jsp:include>

	
	      <script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/angular.min.js"></script>  
	  <script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/angular-cookies.js"></script> 
    	 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-filter/0.5.8/angular-filter.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/angular/app.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/script.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui.js"></script>
	 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>
	

	<script type="text/javascript">
	
	$(document).ready(function() {
	    $('.js-example-basic-single').select2();
	});
	</script>
	
</body>


</html>