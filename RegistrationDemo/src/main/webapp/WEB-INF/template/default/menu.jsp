
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="menu">
<h4>Menu</h4>
<ul>
<li>
<spring:url value="/registration" var="regUrl" htmlEscape="true"></spring:url>
<a href="${regUrl }">Registration</a>
</li>
<li>
<spring:url value="/about" var="aboutUrl" htmlEscape="true"></spring:url>
<a href="${aboutUrl }">About</a>
</li>

</ul>
</div>
