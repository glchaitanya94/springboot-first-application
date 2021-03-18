<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<p>name is ${name}</p>
	<font color="red">${errorMessage}</font>
	<form method="post">
		<label>Name</label> <input type="text" name="name" /> <label>Password</label>
		<input type="password" name="password" />
		<!-- <button>Submit query</button> -->
		<input type="submit">
	</form>
</div>

<%@ include file="common/footer.jspf"%>