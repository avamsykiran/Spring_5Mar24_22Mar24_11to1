<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> ${appName }</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:forEach items="${links }" var="link">
					<li class="nav-item">
						<a class="nav-link" href="${link[1]}">${link[0]}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</nav>