<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<p>Add a todo page for ${name} ${todo.desc} ${todo.targetDate} </p>
	<form:form method="post" modelAttribute="todo">
		<%-- <form:hidden path="id" /> --%>
		<fieldset class="form-group">
				<label>Description </label>
				<form:input path="desc" type="text" class="form-control" />
				<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
				<label path="targetDate">Target Date</label>
				<form:input path="targetDate" type="text" class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<button class="btn btn-success" type="submit">Add</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>