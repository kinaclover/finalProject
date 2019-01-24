<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="d-block">

<div class="mt-5 text-center">
	<H3>Oops, sorry.111</H3>
	<p class="mt-5">Something is wrong.. :(</p>
	<p>Please give us some time to fix it.</p>
	<h2>Exception : ${exception.message}</h2>
</div>

<div class="mt-5 text-center">
	<button class="btn-md btn-dark" onclick="history.back()">Go back</button>
</div>

<!-- for bootstrap -->
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>