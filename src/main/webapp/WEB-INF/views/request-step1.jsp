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
                    <li class="active">Check your request</li>
                    <li>Select hospital</li>
                    <li>Urgent</li>
                    <li>Contact</li>
                </ul>
            </div>
        </div>

    </div>
</div>


<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-3">
        </div>


        <div class="col-2">
            Blood Type
        </div>

        <div class="col-4">
            <select class="blood-type" id="blood-type" aria-label="Default select example">
                <option value="A" selected>A</option>
                <option value="B">B</option>
                <option value="AB">AB</option>
                <option value="O">O</option>
            </select>
        </div>

        <div class="col-3">
        </div>
    </div>
</div>

<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-3">
        </div>


        <div class="col-2">
            Cc
        </div>

        <div class="col-4">
            <select class="cc" id="cc" aria-label="Default select example">
                <option value="200">200</option>
                <option value="400" selected>400</option>
            </select>
        </div>

        <div class="col-3">
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
        location.href = "/book/request-step2?bloodType=" + document.getElementById("blood-type").value
            + "&cc=" + document.getElementById("cc").value;
    };
</script>
</body>
</html>
