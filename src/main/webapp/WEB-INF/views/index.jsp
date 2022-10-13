<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.domain.HistoryRecord" %>
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



        <div class="col-12 bg-light">
            <div class="d-flex justify-content-center mt-5 mb-5">
                <h1>Urgent Case</h1>
            </div>

        </div>


    </div>
</div>
<table class="table align-middle mb-0 bg-white ml-3 mt-5 mb-5">
    <thead class="bg-light">
    <tr>
        <th>Blood Type</th>
        <th>Case Date</th>
        <th>Case content</th>


    </tr>
    </thead>
    <tbody>

    <%
        Map<String, List<HistoryRecord>> data = (Map<String, List<HistoryRecord>>) request.getAttribute("history");
        List<HistoryRecord> historyRecords = data.get("history");
        for (HistoryRecord entry : historyRecords) {

            out.println(
                    "<tr>\n" +
                            "                <td>\n" +
                            "                    <div class=\"d-flex align-items-center\">\n" +
                            "\n" +
                            "                        <div class=\"ms-3\">\n" +
                            "                            <p class=\"fw-bold mb-1 \">" + entry.getBloodType() + "</p>\n" +
                            "\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                       <p class=\"fw-normal mb-1 \">" + entry.getDate() + "</p>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                    <p class=\"fw-normal mb-1 \">" + entry.getContent() + "</p>\n" +
                            "\n" +
                            "                </td>\n"




            );



        }




    %>


    </tbody>
</table>

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

</body>
</html>
