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
�����ͺ��̽� ����Ȯ��
<br>
<%=JdbcUtil.getConnection() %>
</body>
</html>