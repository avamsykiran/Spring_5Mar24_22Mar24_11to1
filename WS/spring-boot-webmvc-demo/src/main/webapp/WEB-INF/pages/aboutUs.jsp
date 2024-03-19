<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Spring WebApp</title>
	</head>
	<body>
	
		<jsp:include page="/header" />
	
		<h3>My Team</h3>
		<ul>
			<c:forEach var="x" items="${team }">
				<li> ${x} </li>
			</c:forEach>
		</ul>
		
		<form>
			<label>User Name: <input type="text" name="unm" /> </label>
			<button>Wish to join your team</button>
		</form>
		
		<c:if test="${msg ne null }">
			<p><strong>${msg }</strong></p>
		</c:if>
	</body>
</html>