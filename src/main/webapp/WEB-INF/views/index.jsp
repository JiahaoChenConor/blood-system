<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.domain.UrgentPost" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>
<body>

<jsp:include page="base/nav-non-user.jsp"/>


<div class="container-fluid mb-5">
    <!-- Carousel wrapper -->
    <div id="carouselMaterialStyle" class="carousel slide carousel-fade" data-mdb-ride="carousel">
        <!-- Indicators -->
        <div class="carousel-indicators">
            <button type="button" data-mdb-target="#carouselMaterialStyle" data-mdb-slide-to="0" class="active" aria-current="true"
                    aria-label="Slide 1"></button>
            <button type="button" data-mdb-target="#carouselMaterialStyle" data-mdb-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-mdb-target="#carouselMaterialStyle" data-mdb-slide-to="2" aria-label="Slide 3"></button>
        </div>

        <!-- Inner -->
        <div class="carousel-inner rounded-5 shadow-4-strong">
            <!-- Single item -->
            <div class="carousel-item active">
                <img src="/img/index/carousel/slide1.jpg" class="d-block w-100" alt="Donate blood"/>
                <div class="carousel-caption d-none d-md-block">
                    <h5>First slide label</h5>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </div>
            </div>


                                            <%-- 1320 * 583--%>
            <!-- Single item -->
            <div class="carousel-item">
                <img src="/img/index/carousel/slide2.jpg" class="d-block w-100" alt="Donate blood"/>
                <div class="carousel-caption d-none d-md-block">
                    <h5>Second slide label</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </div>
            </div>


        </div>
        <!-- Inner -->

        <!-- Controls -->
        <button class="carousel-control-prev" type="button" data-mdb-target="#carouselMaterialStyle" data-mdb-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-mdb-target="#carouselMaterialStyle" data-mdb-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <!-- Carousel wrapper -->
</div>




<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-8">
            <img src="/img/bg.png" alt="bg">
        </div>
        <div class="col-4 mt-5 mb-5">
            <h1> Who are we?</h1>
            <p> We are a blood donation agency</p>
        </div>
    </div>
</div>




<jsp:include page="base/footer.jsp"/>


<!-- MDB -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Custom scripts -->

</body>
</html>
