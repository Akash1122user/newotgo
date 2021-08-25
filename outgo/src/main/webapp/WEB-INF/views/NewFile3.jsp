<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


                    <form id="uploadfileexcle222" action="excel2" enctype="multipart/form-data" method="post">
                         <input type="file" class="form-control" name="imageFile" id="imageFile"   > 
                                              <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}" />
                         

<input type="submit" value="submit">

</form>

</body>
</html>