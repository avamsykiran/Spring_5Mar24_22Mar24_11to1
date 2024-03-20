<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<title>Spring WebApp</title>
	</head>
	<body>
	
		<jsp:include page="/header" />
	
		<h3>Contact Us</h3>
		
		<form:form method="POST" modelAttribute="visitor">
			<div>
				<form:label path="title">Title </form:label>
				<form:select path="title">
					<form:options items="${titles}"/>
				</form:select>
			</div>
			<div>
				<form:label path="fullName">Full Name</form:label>
				<form:input path="fullName"/>
			</div>
			<div>
				<form:label path="mailId">Mail Id</form:label>
				<form:input path="mailId"/>
			</div>
			<div>
				<button>Please Contact Me</button>
			</div>
		</form:form>
		
	</body>
</html>