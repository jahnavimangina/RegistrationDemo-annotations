<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	overflow: hidden;
}

.page {
	min-height: 100%;
	position: relative;
}

.header {
	padding: 10px;
	width: 100%;
	text-align: center;
}

.content {
	padding: 10px;
	padding-bottom: 20px; /* Height of the footer element */
	overflow: hidden;
}

.menu {
	padding: 50px 10px 0px 10px;
	width: 200px;
	float: left;
}

.body {
	margin: 50px 10px 0px 250px;
}

.footer {
	clear: both;
	position: absolute;
	bottom: 0;
	left: 0;
	text-align: center;
	width: 100%;
	height: 20px;
}
</style>
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<div class="content">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>

	</div>
</body>
</html>