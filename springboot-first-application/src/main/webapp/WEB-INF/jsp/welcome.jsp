<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<p>Welcome ${name}. Login Successfully. Your Password is
		${password}
	</p>
	<p>
		<a href="/list-todos"> Click here </a> to manage your todos.
	</p>
</div>

<%@ include file="common/footer.jspf"%>