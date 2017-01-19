<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<p>
				Language: <a href="?language=en">English</a> | <a
					href="?language=fr">French</a>
			</p>
			<form:form method="post" action="registration"
				commandName="registration">

				<table>
					<tr>
						<td><spring:message
								code="registration.form.input.label.firstname"></spring:message>:</td>
						<td><form:input path="firstName" />
						<td><font color="red"> <form:errors path="firstName">
								</form:errors></font>
					</tr>
					<tr>
						<td><spring:message
								code="registration.form.input.label.lastname"></spring:message>:</td>
						<td><form:input path="lastName" />
						<td><font color="red"> <form:errors path="lastName"></form:errors></font>
					</tr>
					<tr>
						<td><spring:message
								code="registration.form.input.label.username"></spring:message>:</td>
						<td><form:input path="userName" />
						<td><font color="red"><form:errors path="userName"></form:errors></font>
					</tr>
					<tr>
						<td><spring:message
								code="registration.form.input.label.password"></spring:message>:</td>
						<td><form:password path="password" />
						<td><font color="red"><form:errors path="password"></form:errors></font>
					</tr>
					<tr>
						<td><spring:message
								code="registration.form.input.label.confirmpassword"></spring:message>:</td>
						<td><form:password path="confirmPassword" />
						<td><font color="red"><form:errors
									path="confirmPassword"></form:errors></font>
					</tr>
					<tr>
						<td><spring:message
								code="registration.form.input.label.email"></spring:message>:</td>
						<td><form:input path="email" />
						<td><font color="red"><form:errors path="email"></form:errors></font>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Register">
						<td>&nbsp;</td>
					</tr>
				</table>

			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>