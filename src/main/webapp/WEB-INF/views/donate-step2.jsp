<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>


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

<div class="container mt-5 mb-5">
    <div class="row">

        <div class="col-6">

        </div>
        <div class="col-6">
            <input id="location" value="sydney" />
        </div>

    </div>
</div>

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
        location.href = "/book/donate-step3?location=" + document.getElementById("location").value;
    };

    document.getElementById("prev").onclick = function () {
        location.href = "/book/donate-step1";
    };
</script>
</body>
</html>
