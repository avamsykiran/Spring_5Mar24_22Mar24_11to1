<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<header style="border-bottom:1px solid black;">
	<h2> ${appName } </h2>
</header>
<nav style="border-bottom:1px solid black;padding:5px;">

	<c:forEach var="link" items="${links }">
		<a href="${link[1] }">${link[0] }</a> 
	</c:forEach>
</nav>