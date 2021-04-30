<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>GastNet - Dashboard</title>
		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/AOLogo.png" />
		
		<!-- Custom fonts for this template-->
		<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/userProfile.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
	</head>
	
	<body id="page-top">
	
	<%
    	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
   		response.setHeader("Pragma","no-cache"); //HTTP 1.0
   		response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	%>
	
		<tiles:insertAttribute name="header" />
		
		<br/>
		
		<tiles:insertAttribute name="body" />
		
		<tiles:insertAttribute name="footer" />
	
		<tiles:insertAttribute name="functions"/>
		
	</body>
</html>