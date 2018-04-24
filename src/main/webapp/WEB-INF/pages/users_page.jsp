<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 16.07.2017
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello from spring

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name}
            | <c:url value="login?logout" var="logoutUrl" />
            <a href="${logoutUrl}">Log Out</a>
        </h2>
    </c:if>

</body>
</html>
