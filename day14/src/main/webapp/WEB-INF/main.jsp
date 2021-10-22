<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<c:forEach var="v" items="datas">
		<tr>
			<td>${v.pk}</td>
			<td>${v.title}</td>
			<td>${v.id}</td>
			<td>${v.content}</td>			
			<td>${v.wdate}</td>
		</tr>
	</c:forEach>

</body>
</html>