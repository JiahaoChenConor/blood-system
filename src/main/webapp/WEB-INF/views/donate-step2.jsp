<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>

    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

    <link rel="stylesheet" type="text/css" href="/css/map.css" />
    <script type="module" src="/js/map.js"></script>
</head>
<body>
<!-- Start your project here-->

<jsp:include page="base/nav-user.jsp"/>

<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-12">
            <div class="wrapper-progressBar">
                <ul class="progressBar">
                    <li class="active">Check eligibility</li>
                    <li class="active">Select hospital</li>
                    <li>Select date and time</li>
                    <li>Confirm appointment</li>
                </ul>
            </div>
        </div>

    </div>
</div>


<jsp:include page="map.jsp"/>


<br/>
<br/>
<br/>
<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-8">
            <button type="button" class="btn btn-primary" id="prev">Prev</button>
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
        location.href = "/book/donate-step3?location=" + document.getElementById("pac-input").value;
    };

    document.getElementById("prev").onclick = function () {
        location.href = "/book/donate";
    };
</script>
</body>
</html>
