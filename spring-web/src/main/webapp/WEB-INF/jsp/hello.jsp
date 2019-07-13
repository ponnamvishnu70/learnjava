<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
${msg}
${count}
<div>
	<form:form action="/spring-web/hello1">
		Enter First Name: <input type="text" name="fname"><br>
		Enter Last Name: <input type="text" name="lname"><br> 
		Enter Last Name: <input type="text" name="name"><br> 
		<button type="submit">submit</button>
		</form:form>
	</br>
	</br>
	</br>
<!-- modelAttribute should be used to convert below form to  FileUploadForm.java object and multipart/form-data for allowing images or vedios or  files-->
<form:form method="POST" modelAttribute="fileUploadForm" action="/spring-web/hello5" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form:form>
	</div>

</body>
</html>