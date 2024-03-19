<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Spring WebApp</title>
	</head>
	<body>
	
		<jsp:include page="/header" />
	
		<h3>Contact Us</h3>
		
		<form>
			<div>
				<label>Title:
					<select name="title" required>
						<option value="Mr.">Mr.</option>
						<option value="Ms.">Ms.</option>
						<option value="Dr.">Dr.</option>
						<option value="Prof.">Prof.</option>
					</select> 
				 </label>
			</div>
			<div>
				<label>Name: <input type="text" name="nm" required /> </label>
			</div>
			<div>
				<label>Email Id: <input type="email" name="mailId" required /> </label>
			</div>
			<button>Please contact me</button>
		</form>
		
		
	</body>
</html>