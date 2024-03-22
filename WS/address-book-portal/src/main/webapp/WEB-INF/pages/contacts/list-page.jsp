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
			<section class="border border-primary p-4 col-sm-9 mx-auto">
				<h3>Contacts List</h3>
				
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>Contact#</th>
							<th>Full Name</th>
							<th>Mobile</th>
							<th>Mail </th>
							<th>Date Of Birth</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contacts }" var="c">
							<tr>
								<td>${c.contactId }</td>
								<td>${c.fullName }</td>
								<td>${c.mobileNumber }</td>
								<td>${c.meilId }</td>
								<td>${c.dateOfBith }</td>
								<td>
									<a class="btn btn-sm btn-secondary" href="/contacts/edit?cid=${c.contactId }">EDIT</a>
									<a class="btn btn-sm btn-danger ml-1" href="/contacts/del?cid=${c.contactId }">DELETE</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</section>
		</div>
	</body>
</html>