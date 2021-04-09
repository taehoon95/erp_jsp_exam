<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 목록</title>
<link rel="stylesheet" href="css/empList.css">
</head>
<body>
	${list }
	<h2>사원 목록</h2>
	<table   class="tbl_type" border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>직책</td>
				<td>직속상사</td>
				<td>급여</td>
				<td>부서</td>
				<td>입사일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${emp }">
				<tr>
					<td>${emp.empNo}</td>
					<td>${emp.empName}</td>
					<td>${emp.title.titleName }</td>
					<td>
					<c:if test="${emp.manager.empNo != 0 }">
						${emp.manager.empName}(${emp.manager.empNo})
					</c:if>
					<c:if test="${emp.manager.empNo == 0 }"></c:if>
					</td>
					<td><fmt:formatNumber value = "${emp.salary}" pattern="#,###" /></td>
					<td>${emp.dept.deptName }</td>
					<td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy년 MM월 dd일" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>