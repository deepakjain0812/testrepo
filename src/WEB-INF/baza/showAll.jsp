<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl">
<title>Baza filmów</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link  rel="stylesheet" type="text/css" href="<c:url value="/resources/WEB-INF/baza/css/style.css" />" />
</head>
<body>

<table class="blueTable">
<thead>
	<tr>
		<th>Tytuł filmu</th>
		<th>Dane reżysera</th>
		<th>Czas trwania</th>
		<th>Rozmiar</th>
	</tr>
</thead>
<tbody>
<c: for items="Object" var="all">
	<tr>
		<td><c: out value="${all[0]}" /></td>
		<td><c: out value="${all[1]}" /></td>
		<td><c: out value="${all[4]}" /></td>
		<td><c: out value="${all[2]}" /></td>
		<td><c: out value="${all[3]}" /></td>
	</tr>
	</c>
</tbody>
</table>

</body>
</html>