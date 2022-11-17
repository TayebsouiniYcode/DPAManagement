<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/11/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
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
-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="${pageContext.request.contextPath}/assets/css/adminlte.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <!--
    <div class="register-logo">
        <a href="register"><b>PDA</b>Manager</a>
    </div>
    -->
    <div class="card">
        <div class="card-body register-card-body">
            <p class="login-box-msg">Register a new membership</p>

            <form method="post" name="register">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="firstName" placeholder="firstname">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="lastName" placeholder="lastname">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="email" class="form-control" placeholder="Email" name="email">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="tel" class="form-control" placeholder="Phone" name="phone">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="username" placeholder="username">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" name="password" class="form-control" placeholder="Password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="social-auth-links text-center">
                    <input type="submit" name="submit" value="register" class="btn btn-primary form-control">
                </div>
            </form>

            <div class="social-auth-links text-center">
                <p>- OR -</p>
                <a href="login" class="btn btn-block border">
                    <!--i class="fab fa-facebook mr-2"></i-->
                    Login
                </a>
            </div>
        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/assets/js/adminlte.js"></script>
</body>
</html>