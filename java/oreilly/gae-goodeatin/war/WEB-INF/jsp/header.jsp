<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Good Eatin'</title>
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<div id="wrapper">

		<div id="header">

			<div id="logo">
				<h1>
					<a href="#">Good Eatin'</a>
				</h1>
				<p>The food you wish you've already tried</p>
			</div>

			<div id="menu">
				<ul>
					<li class="first current_page_item"><a href="/">Home</a></li>
					<c:if test="${pageContext.request.userPrincipal != null}">
					    <li><a href="/newRestaurant">New Restaurant</a></li>
					</c:if>
					<li><a href="#">Contact</a></li>
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal == null}">
							<li><a href="<%=UserServiceFactory.getUserService().createLoginURL("/")%>">Sign
									In</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%=UserServiceFactory.getUserService().createLogoutURL("/")%>">Sign
									Out ${pageContext.request.userPrincipal.name}</a></li>
						</c:otherwise>
					</c:choose> 
				</ul>
			</div>

		<!-- 
        <div id="crumbs">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Eatings</a></li>
            </ul>
        </div>
         -->

		</div>
		<!-- end #header -->