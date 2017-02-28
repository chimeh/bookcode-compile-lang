<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<jsp:include page="footer.jsp" />

<div id="page">
    <div id="page-bgtop">
        <div id="page-bgbtm">
            <div id="content">

                <div class="post">
                    <h2 class="title">Add a new Comment</h2>
                    <p class="meta"></p>
                    <div class="entry">
                        <form action="/asynchronousCommentMaker" method="post">
                            <label for="comment">Comment:</label><br />
                            <textarea rows="5" style="width: 200px;" name="comment"
                                id="description"></textarea>
                            <br /> <br />  
                            <input type="hidden" name="restaurantId" value="${param.restaurantId}"/>
                            <input type="submit" value="Post It" />
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
                     
                </ul>
            </div>
            <!-- end #sidebar -->
            <div style="clear: both;">&nbsp;</div>
        </div>
    </div>
</div>
<!-- end #page -->