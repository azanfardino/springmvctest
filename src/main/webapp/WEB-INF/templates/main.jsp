<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
</head>
<body>
	<div id="header" class="center">
        <tiles:insertAttribute name="header" />
    </div>
    <div id="form" class="center">
         <tiles:insertAttribute name="form" />
    </div>
    <div id="result" class="center">
         <tiles:insertAttribute name="result" ignore="true"/>
    </div>
    <div id="footer" class="center">
         <tiles:insertAttribute name="footer" />
    </div>
	
</body>
</html>
</html>