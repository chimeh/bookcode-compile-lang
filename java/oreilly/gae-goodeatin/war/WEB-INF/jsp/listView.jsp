<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" />

<div id="page">
	<div id="page-bgtop">
		<div id="page-bgbtm">
			<div id="content">
				<c:forEach var="restaurant" items="${restaurants}">
					<div class="post">
						<h2 class="title">
							<a href="#"><c:out value="${restaurant.name}" /></a>
						</h2>
						<p class="meta">
							${restaurant.address} - Added on
							<fmt:formatDate value="${restaurant.dateAdded}"
								pattern="dd MMM yyyy" />
								<c:if test="${restaurant.submitter != null}">
								    by ${restaurant.submitter.nickname}
								</c:if>
						</p>
						<div class="entry">
							<p>
								<c:out value="${restaurant.description}" />
							</p>
						</div>
						
						<a href="newComment?restaurantId=${restaurant.id.id}">Add a comment</a>
						
						<c:forEach var="comment" items="${restaurant.comments}">
						    <div class="comment">
						        <c:out value="${comment.commentText}"/>
						    </div>
						</c:forEach>
						
					</div>
				</c:forEach>

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
