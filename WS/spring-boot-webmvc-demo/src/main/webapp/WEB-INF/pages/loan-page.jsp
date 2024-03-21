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
				<form:label path="principal">Capital Amount</form:label>
			    <form:input path="principal" type="number"/>
		    </div>
		    <div>
		        <form:label path="rateOfInterest">Rate of Interest (0 to 1): </form:label>
		        <form:input path="rateOfInterest" type="decimal"/>
		    </div>
		    <div>
		        <form:label path="timePeriod">Loan Tenure</form:label>
		        <form:input path="timePeriod" type="number"/>
		    </div>
			<div>
				<button>Compute</button>
			</div>
		</form:form>		
		
		<p>This attracts an EMI of <strong> Rupees. ${loan.emi }</strong> </p>
	</body>
</html>