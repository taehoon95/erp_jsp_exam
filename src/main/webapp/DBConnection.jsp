<%@page import="erp_jsp_exam.util.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
데이터베이스 연동확인
<br>
<%=JdbcUtil.getConnection() %>
</body>
</html>