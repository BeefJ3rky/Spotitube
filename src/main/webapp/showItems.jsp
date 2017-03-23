<%@ page import="nl.tomvangrinsven.dea.domain.Track" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tom van Grinsven
  Date: 3/23/2017
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>all tracks</h1>
<%
    List<Track> allTracks = (List<Track>) request.getAttribute("ALL_TRACKS");
    for (Track track :
            allTracks) {
        out.println(track.getTitle() + "<br />");
    }
%>
</body>
</html>
