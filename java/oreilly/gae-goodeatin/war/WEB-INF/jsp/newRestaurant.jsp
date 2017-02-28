<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div id="page">
	<div id="page-bgtop">
		<div id="page-bgbtm">
			<div id="content">

				<div class="post">
					<h2 class="title">Insert a new Restaurant</h2>
					<p class="meta"></p>
					<div class="entry">
						<form action="/restaurantCreator" method="post">
							<label for="name">Restaurant name:</label><br /> <input
								name="name" id="name" type="text" style="width: 200px;" /><br />
							<br /> <label for="description">Description:</label><br />
							<textarea rows="5" style="width: 200px;" name="description"
								id="description">Enter your description</textarea>
							<br /> <br /> <label for="address">Address:</label><br /> <input
								name="address" id="address" type="text" style="width: 200px;" /><br />
							<br /> <input type="submit" value="Post It" />
						</form>
					</div>
				</div>


				<div style="clear: both;">&nbsp;</div>
			</div>

			<!-- end #content -->
			<div id="sidebar">
				<ul>
					<li>
						<div id="search">
							<form method="get" action="#">
								<div>
									<input type="text" name="s" id="search-text" value="" /> <input
										type="submit" id="search-submit" value="GO" />
								</div>
							</form>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</li>
					<li>
						<h2>Good Eatin'</h2>
						<p>The guide you've always been looking for, to find
							restaurants with good food. Seriously, I'm just trying to learn
							Google App Engine.
						<p>
					</li>

					<!--
                        <li>
                            <h2>Categories</h2>
                            <ul>
                                <li><a href="#">Aliquam libero</a></li>
                                <li><a href="#">Consectetuer adipiscing elit</a></li>
                                <li><a href="#">Metus aliquam pellentesque</a></li>
                                <li><a href="#">Suspendisse iaculis mauris</a></li>
                                <li><a href="#">Urnanet non molestie semper</a></li>
                                <li><a href="#">Proin gravida orci porttitor</a></li>
                            </ul>
                        </li>
                        <li>
                            <h2>Blogroll</h2>
                            <ul>
                                <li><a href="#">Aliquam libero</a></li>
                                <li><a href="#">Consectetuer adipiscing elit</a></li>
                                <li><a href="#">Metus aliquam pellentesque</a></li>
                                <li><a href="#">Suspendisse iaculis mauris</a></li>
                                <li><a href="#">Urnanet non molestie semper</a></li>
                                <li><a href="#">Proin gravida orci porttitor</a></li>
                            </ul>
                        </li>
                        <li>
                            <h2>Archives</h2>
                            <ul>
                                <li><a href="#">Aliquam libero</a></li>
                                <li><a href="#">Consectetuer adipiscing elit</a></li>
                                <li><a href="#">Metus aliquam pellentesque</a></li>
                                <li><a href="#">Suspendisse iaculis mauris</a></li>
                                <li><a href="#">Urnanet non molestie semper</a></li>
                                <li><a href="#">Proin gravida orci porttitor</a></li>
                            </ul>
                        </li>
                        -->
				</ul>
			</div>
			<!-- end #sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
</div>
<!-- end #page -->

<jsp:include page="footer.jsp" />