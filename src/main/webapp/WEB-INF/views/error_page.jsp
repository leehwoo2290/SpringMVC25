<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error_page</title>
</head>
	<h2>예외발생!!!</h2>
	
	<h4><c:out value= "${exception.getMessage()}"></c:out></h4>
	<!-- 표현식 모델 객체에 있는 데이터 출력 -->
	
	<ul>
		<c:forEach items="${exception.getStackTrace()}" var = "stack">
			<li>
				<c:out value= "${stack}"></c:out>
			</li>
		</c:forEach>
	</ul>
<body>

</body>
</html>