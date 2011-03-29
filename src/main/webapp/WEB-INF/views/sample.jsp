<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Template</title>
<script type="text/javascript">
	var domainId = "${domain.id}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/jquery-ui-1.8.11.custom.min.js"></script>
</head>
<body>
	<input id="div1_editbutton_id" type="button" value="Edit Me" /><div id="template1_div1"> <b>Some text 1 </b></div>
	<div id="template2_div2"> <i>Some text 2 </i></div>

<div id="contentDialog" style="display:none">
	<input id="contentTextId" type="text" />
	<input id="dialogbutton" type="button" value="save"/>
</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/templatehelper.js"></script>
</body>
</html>