<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/2/2022
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Activity</title>
</head>
<body>
<form action="addActivity" method="post">
    <p>Enter dateDebut
        <input type="date" name="dateDebut" /></p>

    <p>Enter  dateFin
        <input type="date" name="dateFin" /></p>

    <p>Enter  description
        <input type="text" name="description" /></p>

    <p>Select status
        <input type="radio" name="status" /></p>

    <p>Enter title
        <input type="text" name="title" /></p>


    <p>Submit
        <input type="submit" name="submit" value="submit" /></p>
</form>
</body>
</html>
