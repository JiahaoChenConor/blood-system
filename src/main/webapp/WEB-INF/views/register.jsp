<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>

<body>

    <div class="container">

    </div>
    <jsp:include page="base/nav-non-user.jsp"/>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-5 align-content-center">
            <!-- Default form register -->
            <form class="text-center border border-light p-5" action="/register" method="post">

                <p class="h4 mb-4">Sign up</p>

                <!-- E-mail -->
                <input type="email" id="email" name="email" class="form-control mb-4" placeholder="E-mail">

                <!-- Password -->
                <input type="password" id="password" name="password" class="form-control mb-4" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">


                <!-- Password Again -->
                <input type="password" id="rePassword" name="rePassword" class="form-control mb-4" placeholder="Re enter password" aria-describedby="defaultRegisterFormPhoneHelpBlock">


                <!-- Newsletter -->
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultRegisterFormNewsletter">
                    <label class="custom-control-label" for="defaultRegisterFormNewsletter">Subscribe to our newsletter</label>
                </div>

                <!-- Sign up button -->
                <button class="btn btn-info my-4 btn-block" type="submit">Sign up</button>

                <!-- Social register -->
                <p>or sign up with:</p>

                <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
                <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
                <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
                <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

                <hr>

                <!-- Terms of service -->
                <p>By clicking
                    <em>Sign up</em> you agree to our
                    <a href="" target="_blank">terms of service</a>

                <div class="d-flex justify-content-around mt-5">
                    <%
                        String status = (String) request.getAttribute("registerStatus");
                        if (status != null){
                            if (status.equals("empty_error")){
                                out.println("<p class=\"text-warning\"> Empty is not allowed</p>");
                            }
                            else if (status.equals("password_not_valid")){
                                out.println("<p class=\"text-warning\"> Password not valid. </br> " +
                                                    "At least 1 number and 1 lowercase and 1 uppercase letter</br>" +
                                                    "length is between 8 to 20 </p>");
                            }else if (status.equals("password_not_same")){
                                out.println("<p class=\"text-warning\"> Password re-enter is not the same </p>");
                            }else if (status.equals("email_exists")){
                                out.println("<p class=\"text-warning\"> This email has been registered</p>");
                            }else{
                                out.println("<p class=\"text-primary\"> Congratulations. Register successfully </p>");
                            }

                        }

                    %>
                </div>
            </form>
            <!-- Default form register -->

        </div>


    </div>

</div>

<script src="" async defer></script>
</body>
