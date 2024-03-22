<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:url value="/css/bootstrap.css"  var="cssUrl" />
<c:url value="/js/bootstrap.js"  var="jsUrl" />

<html>
	<head>
		<title>Spring WebApp</title>
		<link href="${cssUrl }" rel="stylesheet" />
		<script src="${jsUrl }"></script>
	</head>
	<body>
	
		<jsp:include page="/header" />
		
		<div class="container-fluid p-4">
			<section class="border border-primary p-4 col-sm-4 mx-auto">
				<h3>Contact Form</h3>
				
				<form:form modelAttribute="contact" method="POST">
					<div>
						<form:label path="contactId">Contact Id: </form:label>
						<form:input path="contactId" class="form-control" readonly="true"/>
					</div>
					<div>
						<form:label path="fullName">Full Name: </form:label>
						<form:input path="fullName" class="form-control" />
						<form:errors path="fullName" />
					</div>
					<div>
						<form:label path="mobileNumber">Mobile Number: </form:label>
						<form:input path="mobileNumber" class="form-control" />
						<form:errors path="mobileNumber" />
					</div>
					<div>
						<form:label path="meilId">Mail Id: </form:label>
						<form:input path="meilId" class="form-control" />
						<form:errors path="meilId" />
					</div>
					<div>
						<form:label path="dateOfBith">Date Of Birth: </form:label>
						<form:input path="dateOfBith" class="form-control" type="date"/>
						<form:errors path="dateOfBith" />
					</div>
					<div class="d-grid mt-1">
						<button class="btn btn-primary">SAVE</button>
					</div>
				</form:form>
				
			</section>
		</div>
	</body>
</html>