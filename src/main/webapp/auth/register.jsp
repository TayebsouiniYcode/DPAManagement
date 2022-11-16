<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/11/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="d-flex justify-content-md-center pt-5 vh-100">
    <form method="post" class="form w-50 mt-2 border p-5" name="register">
        <div class="form-group">
            <label for="firstName" class="form-label">firstName</label>
            <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Enter your firstname" required>
        </div>
        <div class="form-group">
            <label for="lastName" class="form-label">lastName</label>
            <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Enter your lastname" required>
        </div>
        <div class="form-group">
            <label for="phone" class="form-label">phone</label>
            <input type="text" name="phone" id="phone" class="form-control" placeholder="Enter your phone" required>
        </div>
        <div class="form-group">
            <label for="username" class="form-label">Username</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="Enter your username" required>
        </div>
        <div class="form-group">
            <label for="email" class="form-label">email</label>
            <input type="text" name="email" id="email" class="form-control" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Enter your password" required>
        </div>
        <div class="form-group mt-4">
            <input type="submit" value="submit" class="form-control bg-primary text-white">
        </div>
    </form>
</section>
</body>
</html>
