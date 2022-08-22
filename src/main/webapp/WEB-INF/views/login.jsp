<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Life Blood</title>
    <!-- MDB icon -->
    <link rel="icon" href="img/blood-drop.png" type="image/png" />
    <!-- Font Awesome -->
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />
    <!-- Google Fonts Roboto -->
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"
    />
    <!-- MDB -->
    <link rel="stylesheet" href="css/mdb.min.css" />
</head>

<body>


<body>

    <div class="container">

    </div>

    <div class="container">
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

                    <!-- Sign in button -->
                    <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

                    <!-- Register -->
                    <p>Not a member?
                        <a href="/register">Register</a>
                    </p>

                    <!-- Social login -->
                    <p>or sign in with:</p>

                    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
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
