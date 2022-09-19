<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>

<body>


    <jsp:include page="base/nav-non-user.jsp"/>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-5 align-content-center">
                <!-- Default form login -->
                <%--@elvariable id="user" type="entity.User"--%>
                <form class="text-center border border-light p-5" action="/login" method="post">

                    <p class="h4 mb-4">Sign in</p>

                    <!-- Email -->
                    <input type="email" id="defaultLoginFormEmail" name="email" class="form-control mb-4" placeholder="E-mail" >

                    <!-- Password -->
                    <input type="password" id="defaultLoginFormPassword" name="password" class="form-control mb-4" placeholder="Password">

                    <div class="d-flex justify-content-around">
                        <div>
                            <!-- Remember me -->
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="remember-me" name="remember-me">
                                <label class="custom-control-label" for="remember-me" >Remember me</label>
                            </div>
                        </div>
                        <div>
                            <!-- Forgot password -->
                            <a href="">Forgot password?</a>
                        </div>
                    </div>

                    <div class="d-flex justify-content-around mt-5">
                        <%
                            if (request.getAttribute("registerStatus") != null
                                && request.getAttribute("registerStatus").equals("success_register")){
                                out.println("<p class=\"text-primary\"> Register successfully, you can login</p>");
                            }
                            if (request.getAttribute("loginError") != null &&
                                    (Boolean) request.getAttribute("loginError")){
                            out.println("<p class=\"text-warning\"> Wrong password or email </p>");
                        }%>
                    </div>

                    <!-- Sign in button -->
                    <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

                    <!-- Register -->
                    <p>Not a member?
                        <a href="/register">Register</a>
                    </p>

                    <!-- Social login -->
                    <p>or sign in with:</p>

                    <a href="/oauth2/authorization/google" class="mx-2" role="button"><i class="fab fa-google light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

                </form>
                <!-- Default form login -->

            </div>


        </div>

    </div>

    <script src="" async defer></script>
</body>
