<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<title>Spring WebApp</title>
	</head>
	<body>
	
		<jsp:include page="/header" />
	
		<h3>Loan Us</h3>
		
		<form:form method="POST" modelAttribute="loan">
			<div>
				<button>Please Contact Me</button>
			</div>
		</form:form>		
		
		<p>This attracts an EMI of <strong> Rupees. ${loan.emi }</strong> </p>
	</body>
</html>