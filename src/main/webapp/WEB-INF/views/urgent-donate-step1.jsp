<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
    <link rel="stylesheet" href="/css/progress-bar-2.css" />
</head>
<body>
<!-- Start your project here-->
<jsp:include page="base/nav-user.jsp"/>

<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-12">
            <div class="wrapper-progressBar">
                <ul class="progressBar">
                    <li class="active">Check requester information</li>
                    <li>Contact</li>
                </ul>
            </div>
        </div>

    </div>
</div>


<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-5">
        </div>


        <div class="col-5">
            <h3>Blood Type</h3>
            <p class="font-monospace"><%=request.getAttribute("bloodType")%></p>
        </div>

        <div class="col-2">
        </div>
    </div>
</div>

<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-5">
        </div>


        <div class="col-5">
            <h3>Cc</h3>
            <p class="font-monospace"><%=request.getAttribute("cc")%></p>
        </div>

        <div class="col-2">
        </div>
    </div>
</div>

<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-5">
        </div>


        <div class="col-5">
            <h3>Location</h3>
            <p class="font-monospace"><%=request.getAttribute("location")%></p>
        </div>

        <div class="col-2">
        </div>
    </div>
</div>


<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-5">
        </div>


        <div class="col-5">
            <h3>Date</h3>
            <p class="font-monospace"><%=request.getAttribute("date")%></p>

        </div>

        <div class="col-2">
        </div>
    </div>
</div>


<br/>
<br/>
<br/>
<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-8">
        </div>


        <div class="col-3">

        </div>

        <div class="col-1">
            <button type="button" class="btn btn-primary" id="next">Next</button>
        </div>
    </div>
</div>


<jsp:include page="base/footer.jsp"/>
<!-- Footer -->


<!-- End your project here-->

<!-- MDB -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Custom scripts -->


<script type="text/javascript">

    document.getElementById("next").onclick = function () {
        location.href = "/urgentDonate/step2";
    };

</script>


</body>
</html>