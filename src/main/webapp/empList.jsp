<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 목록</title>
</head>
<body>
	${list }
	<h2>직책 목록</h2>
	<table   class="tbl_type" border="1">
		<thead>
			<tr>
				<td>사원 번호</td>
				<td>사원 이름</td>
				<td>사원 직책</td>
				<td>직속 상사</td>
				<td>사원 월급</td>
				<td>사원 부서</td>
				<td>입사일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${emp }">
				<tr>
					<td>${emp.empNo}</td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.empName}</a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.title.titleName }</a></td>
					<td>
					<a href="EmpGetServlet?empNo=${emp.empNo}">
					<c:if test="${emp.manager.empNo != 0 }">
						${emp.manager.empName}(${emp.manager.empNo})
					</c:if>
					<c:if test="${emp.manager.empNo == 0 }"></c:if>
					</a>
					</td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}"><fmt:formatNumber value = "${emp.salary}" pattern="\#,###" /></a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.dept.deptName }</a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}"><fmt:formatDate value="${emp.hiredate}" pattern="yyyy년 MM월 dd일" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>