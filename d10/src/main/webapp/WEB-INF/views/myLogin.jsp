<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> In MyLogin Page ... </h2>

<c:if test="${param.error != null}">
	<h2> ID or PASSWORD is Failed </h2>
</c:if>

<form action="/login" method="post">
	<input type='text' name='username'>
	<input type='password' name='password'>
	<input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}'>
	<input type='checkbox' name='remember-me'>
	<button>LOGIN</button>
</form>

<ul>
<%
	Enumeration<String> en = request.getAttributeNames();
	while(en.hasMoreElements()){
		String key = en.nextElement();
		Object value = request.getAttribute(key);
		%>
		<li><%=key %> ----- <%=value %></li>
		<%
	}
%>
</ul>
</body>
</html>