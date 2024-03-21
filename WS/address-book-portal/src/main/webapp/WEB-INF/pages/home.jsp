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
			<section class="border border-primary p-4 col-sm-8 mx-auto">
				<h3>Welcome Home!</h3>
				
				<p>
					This is a sample <strong>spring boot dynamic web application</strong> demonstrating the CRUD
					operations on 'Contact' Entity
				</p>
				
				<p>
					JSP (Java Server PAges) are ued for Views.
				</p>
				
				<p>
					Bootstrap 5 is used for styling 
				</p>
				
				<p>
					Spring Data JPA for Dynamic JPA Repositories and MySQL for Persistence.
				</p>
			</section>
		</div>
	</body>
</html>