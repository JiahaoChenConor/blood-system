

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>
<body>
<!-- Start your project here-->

<%--Nav bar--%>
<div class="container-fluid height=300px">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Container wrapper -->
        <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>

            <!-- Collapsible wrapper -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!-- Navbar brand -->
                <a class="navbar-brand mt-2 mt-lg-0" href="#">
                    <img
                            src="img/blood-drop.png"
                            height="25"
                            alt="MDB Logo"
                            loading="lazy"
                    />
                </a>
                <!-- Left links -->
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">FAQ</a>
                    </li>
                </ul>
                <!-- Left links -->
            </div>
            <!-- Collapsible wrapper -->

            <!-- Right elements -->
            <div class="d-flex align-items-center">
                <button type="button" id="book" class="btn btn-secondary me-4">Book</button>

                <!-- Avatar -->
                <div class="dropdown">
                    <a
                            class="dropdown-toggle d-flex align-items-center hidden-arrow"
                            href="#"
                            id="navbarDropdownMenuAvatar"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        <!-- Avatar -->
                        <div ><i class="fas fa-user fa-lg"></i> <%=request.getAttribute("username")%> </div>
                    </a>
                    <ul
                            class="dropdown-menu dropdown-menu-end"
                            aria-labelledby="navbarDropdownMenuAvatar"
                    >
                        <li>
                            <a class="dropdown-item" href="#">Profile</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Health Info</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">History</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log out</a>
                        </li>
                    </ul>
                </div>



            </div>
            <!-- Right elements -->
        </div>
        <!-- Container wrapper -->
    </nav>
    <!-- Navbar -->
</div>



<!-- Jumbotron -->
<div class="p-5 text-center bg-light">
    <h1 class="mb-3">Book</h1>
</div>
<!-- Jumbotron -->


<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-md">
        </div>


        <div class="col-md">

        </div>

        <div class="col-md">
        </div>
    </div>
</div>



<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-md">
        </div>

        <div class="col-md">
            <div class="card">
                <img src="img/book/request.png" class="card-img-top" alt="Fissure in Sandstone"/>
                <div class="card-body bg-light">
                    <p class="card-text">If your want to reuqest blood, click this button</p>
                    <a href="#!" class="btn btn-primary">Request</a>
                </div>
            </div>
        </div>


        <div class="col-md">
        </div>


        <div class="col-md">
            <div class="card">
                <img src="img/book/donation.jpeg" class="card-img-top" alt="Fissure in Sandstone"/>
                <div class="card-body bg-light">

                    <p class="card-text">If your want to donate blood, click this button</p>
                    <a href="#!" class="btn btn-primary">Donate</a>
                </div>
            </div>
        </div>


        <div class="col-md">
        </div>

    </div>
</div>




<jsp:include page="base/footer.jsp"/>
<!-- Footer -->


<!-- End your project here-->

<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript">
</script>
</body>
</html>
