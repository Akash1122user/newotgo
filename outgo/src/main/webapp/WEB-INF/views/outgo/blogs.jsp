<!doctype html>
<html lang="en" data-ng-app="myModule">
<head>

<title>OutGo | Blogs</title>
 <link rel="icon" href="https://s3.ap-south-1.amazonaws.com/outgo-images/Logo/OutGo-SmartBiz.png" >
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta content="www.outgo.co ,outgo payment solutions, all services at one place, landline payment, broadband payment,OutGo, Payment Simplified,Easy to pay" name="description">
<meta content="www.outgo.co is a  website to provide the payment solution for every user as per respective marchent." name="keywords">
<meta content="outgo" name="author">
<meta name="robots" content="index,follow">


<jsp:include page="shortcontaint/css.jsp"></jsp:include>
<jsp:include page="shortcontaint/links.jsp"></jsp:include>
<jsp:include page="shortcontaint/analyticScript.jsp"></jsp:include>

</head>
<body onload="javascript:chooseStyle('blue', 60)" data-ng-controller="myController">

	<div id="container">

		<header class="clearfix">

			<div class="top-bar">
			<jsp:include page="shortcontaint/top.jsp"></jsp:include>
			</div>


			<div class="navbar navbar-default navbar-top" role="navigation"
				data-spy="affix" data-offset-top="50">
				
	<jsp:include page="shortcontaint/header.jsp"></jsp:include>

			</div>

		</header>



		<div class="page-banner no-subtitle"
			style="padding: 40px 0; background: url(<%=request.getContextPath()%>/assets/outgoAssets/images/banner2.jpg) center #f9f9f9;background-size: cover; opacity: 2.5;">
		
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1 style="color: #fff">Blog</h1>
					</div>
					<div class="col-md-6">
						<ul class="breadcrumbs">
							<li><a href="index.html" style="color: #fff">Home</a></li>
							<li style="color: #fff">Blog</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div id="content">
			<div class="container">
				<div class="row blog-page">

					<div class="col-md-3 sidebar left-sidebar">

						<div class="widget widget-search">
							<form action="#">
								<input type="search" placeholder="Enter Keywords..." />
								<button class="search-btn" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>

						<div class="widget widget-categories">
							<h4>
								Quick Links <span class="head-line"></span>
							</h4>
							<ul>
								<li><a href="#">Brandign</a></li>
								<li><a href="#">Design</a></li>
								<li><a href="#">Development</a></li>
								<li><a href="#">Graphic</a></li>
							</ul>
						</div>

						
						

						
					</div>


					<div class="col-md-9 blog-box">

						<div class="blog-post image-post">

							<div class="post-head">
								<a class="lightbox" title="This is an image title"
									href="images/blog-01.jpg">
									<div class="thumb-overlay">
										<i class="fa fa-arrows-alt"></i>
									</div> <img alt="" src="images/blog-01.jpg">
								</a>
							</div>

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-picture-o"></i>
								</div>
								<h2>
									<a href="#">Image Box With Nice Lightbox</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post video-post">

							<div class="post-head">
							<!-- 	<iframe
									src="https://www.youtube.com/watch?v=zs3oLPqge0w"
									width="800" height="450"></iframe> -->
									<iframe width="800" height="450" src="https://www.youtube.com/watch?v=zs3oLPqge0w">
</iframe>
							</div>

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-play"></i>
								</div>
								<h2>
									<a href="#">Iframe Video Post</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post standard-post">

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-pencil"></i>
								</div>
								<h2>
									<a href="#">Standard Post Without Image</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post standard-post">

							<div class="post-head">
								<a href="#">
									<div class="thumb-overlay">
										<i class="fa fa-arrows-alt"></i>
									</div> <img alt="" src="images/blog-05.jpg">
								</a>
							</div>

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-picture-o"></i>
								</div>
								<h2>
									<a href="#">Standard Post With Image</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post link-post">

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-link"></i>
								</div>
								<h2>
									<a href="#">Link Post</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post gallery-post">

							<div class="post-head">
								<div class="post-slider touch-slider">
									<div class="item">
										<a class="lightbox" title="This is an image title"
											href="images/blog-02.jpg" data-lightbox-gallery="gallery1">
											<div class="thumb-overlay">
												<i class="fa fa-arrows-alt"></i>
											</div> <img alt="" src="images/blog-02.jpg">
										</a>
									</div>
									<div class="item">
										<a class="lightbox" title="This is an image title"
											href="images/blog-03.jpg" data-lightbox-gallery="gallery1">
											<div class="thumb-overlay">
												<i class="fa fa-arrows-alt"></i>
											</div> <img alt="" src="images/blog-03.jpg">
										</a>
									</div>
									<div class="item">
										<a class="lightbox" title="This is an image title"
											href="images/blog-04.jpg" data-lightbox-gallery="gallery1">
											<div class="thumb-overlay">
												<i class="fa fa-arrows-alt"></i>
											</div> <img alt="" src="images/blog-04.jpg">
										</a>
									</div>
								</div>
							</div>

							<div class="post-content">
								<div class="post-type">
									<i class=" fa fa-picture-o"></i>
								</div>
								<h2>
									<a href="#">Gallery Post With Nice Lightbox.</a>
								</h2>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni dolores eos qui ratione voluptatem
									sequi nesciunt.</p>
								<a class="main-button" href="#">Read More <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>


						<div class="blog-post quote-post">

							<div class="post-content">
								<div class="post-type">
									<i class="fa fa-quote-left"></i>
								</div>
								<div class="qoute-box">
									<a href="#">
										<h2>Throughout life people will make you mad, disrespect
											you and treat you bad. Let God deal with the things they do,
											cause hate in your heart will consume you too.</h2>
										<div class="qoute-author">John Kennedy</div>
									</a>
								</div>
								<ul class="post-meta">
									<li>By <a href="#">GrayGrids</a></li>
									<li>December 30, 2013</li>
									<li><a href="#">WordPress</a>, <a href="#">Graphic</a></li>
									<li><a href="#">4 Comments</a></li>
								</ul>
							</div>
						</div>


						<div id="pagination">
							<span class="all-pages">Page 1 of 3</span> <span
								class="current page-num">1</span> <a class="page-num" href="#">2</a>
							<a class="page-num" href="#">3</a> <a class="next-page" href="#">Next</a>
						</div>

					</div>

				</div>
			</div>
		</div>


		<footer>
			<jsp:include page="shortcontaint/footer.jsp"></jsp:include>
		</footer>

	</div>

<jsp:include page="shortcontaint/models.jsp"></jsp:include>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/outgoAssets/js/script.js"></script>
</body>


</html>