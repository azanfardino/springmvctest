<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<script type="text/javascript" src="js/form.js"> </script> 
 
<form:form name="search_form" method="post" modelAttribute="searchForm" onsubmit="return validateForm()" action="find">
		<form:label path="textToSearch">Text to search</form:label>
		<form:input path="textToSearch" onfocus="cleanError()"/>
		<form:errors path="textToSearch" cssclass="error"></form:errors>
    	<input type="submit" value="search" >
    	<div id="err" class="error"></div>
</form:form> 

