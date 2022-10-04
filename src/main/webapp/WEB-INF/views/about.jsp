<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.entity.HistoryRecord" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>

<jsp:include page="base/nav-non-user.jsp"/>

<br/>
<br/>
<br/>
<!-- ======= About Us Section ======= -->
<section id="about" class="about">
    <div class="container" data-aos="fade-up">

        <div class="section-title">
            <h2>About Us</h2>
            <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
        </div>

        <div class="row">
            <div class="col-lg-6" data-aos="fade-right">
                <img src="/img/about.jpg" class="img-fluid" alt="">
            </div>
            <div class="col-lg-6 pt-4 pt-lg-0 content" data-aos="fade-left">
                <h3>Voluptatem dignissimos provident quasi corporis voluptates sit assumenda.</h3>
                <p class="fst-italic">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                    magna aliqua.
                </p>
                <ul>
                    <li><i class="bi bi-check-circle"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
                    <li><i class="bi bi-check-circle"></i> Duis aute irure dolor in reprehenderit in voluptate velit.</li>
                    <li><i class="bi bi-check-circle"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate trideta storacalaperda mastiro dolore eu fugiat nulla pariatur.</li>
                </ul>
                <p>
                    Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                    velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
                    culpa qui officia deserunt mollit anim id est laborum
                </p>
            </div>
        </div>

    </div>
</section><!-- End About Us Section -->

<!-- ======= Counts Section ======= -->
<section id="counts" class="counts">
    <div class="container" data-aos="fade-up">

        <div class="row no-gutters">

            <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                <div class="count-box">
                    <i class="fas fa-user-md"></i>
                    <span data-purecounter-start="0" data-purecounter-end="85" data-purecounter-duration="1" class="purecounter"></span>

                    <p><strong>Doctors</strong> consequuntur quae qui deca rode</p>
                    <a href="#">Find out more &raquo;</a>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                <div class="count-box">
                    <i class="far fa-hospital"></i>
                    <span data-purecounter-start="0" data-purecounter-end="26" data-purecounter-duration="1" class="purecounter"></span>
                    <p><strong>Departments</strong> adipisci atque cum quia aut numquam delectus</p>
                    <a href="#">Find out more &raquo;</a>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                <div class="count-box">
                    <i class="fas fa-flask"></i>
                    <span data-purecounter-start="0" data-purecounter-end="14" data-purecounter-duration="1" class="purecounter"></span>
                    <p><strong>Research Lab</strong> aut commodi quaerat. Aliquam ratione</p>
                    <a href="#">Find out more &raquo;</a>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                <div class="count-box">
                    <i class="fas fa-award"></i>
                    <span data-purecounter-start="0" data-purecounter-end="150" data-purecounter-duration="1" class="purecounter"></span>
                    <p><strong>Awards</strong> rerum asperiores dolor molestiae doloribu</p>
                    <a href="#">Find out more &raquo;</a>
                </div>
            </div>

        </div>

    </div>
</section><!-- End Counts Section -->

<!-- ======= Features Section ======= -->
<section id="features" class="features">
    <div class="container" data-aos="fade-up">

        <div class="row">
            <div class="col-lg-6 order-2 order-lg-1" data-aos="fade-right">
                <div class="icon-box mt-5 mt-lg-0">
                    <i class="bx bx-receipt"></i>
                    <h4>Est labore ad</h4>
                    <p>Consequuntur sunt aut quasi enim aliquam quae harum pariatur laboris nisi ut aliquip</p>
                </div>
                <div class="icon-box mt-5">
                    <i class="bx bx-cube-alt"></i>
                    <h4>Harum esse qui</h4>
                    <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt</p>
                </div>
                <div class="icon-box mt-5">
                    <i class="bx bx-images"></i>
                    <h4>Aut occaecati</h4>
                    <p>Aut suscipit aut cum nemo deleniti aut omnis. Doloribus ut maiores omnis facere</p>
                </div>
                <div class="icon-box mt-5">
                    <i class="bx bx-shield"></i>
                    <h4>Beatae veritatis</h4>
                    <p>Expedita veritatis consequuntur nihil tempore laudantium vitae denat pacta</p>
                </div>
            </div>
            <div class="image col-lg-6 order-1 order-lg-2" style='background-image: url("/img/features.jpg");' data-aos="zoom-in"></div>
        </div>

    </div>
</section><!-- End Features Section -->

<!-- ======= Services Section ======= -->
<section id="services" class="services services">
    <div class="container" data-aos="fade-up">

        <div class="section-title">
            <h2>Services</h2>
            <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="100">
                <div class="icon"><i class="fas fa-heartbeat"></i></div>
                <h4 class="title"><a href="">Lorem Ipsum</a></h4>
                <p class="description">Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident</p>
            </div>
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="200">
                <div class="icon"><i class="fas fa-pills"></i></div>
                <h4 class="title"><a href="">Dolor Sitema</a></h4>
                <p class="description">Minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat tarad limino ata</p>
            </div>
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="300">
                <div class="icon"><i class="fas fa-hospital-user"></i></div>
                <h4 class="title"><a href="">Sed ut perspiciatis</a></h4>
                <p class="description">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur</p>
            </div>
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="100">
                <div class="icon"><i class="fas fa-dna"></i></div>
                <h4 class="title"><a href="">Magni Dolores</a></h4>
                <p class="description">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
            </div>
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="200">
                <div class="icon"><i class="fas fa-wheelchair"></i></div>
                <h4 class="title"><a href="">Nemo Enim</a></h4>
                <p class="description">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque</p>
            </div>
            <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="300">
                <div class="icon"><i class="fas fa-notes-medical"></i></div>
                <h4 class="title"><a href="">Eiusmod Tempor</a></h4>
                <p class="description">Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi</p>
            </div>
        </div>

    </div>
</section><!-- End Services Section -->




<jsp:include page="base/footer.jsp"/>

</body>
</html>
