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
                    <li class="active">Select hospital</li>
                    <li class="active">Urgent</li>
                    <li>Contact</li>
                </ul>
            </div>
        </div>

    </div>
</div>





<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-4">
        </div>


        <div class="col-4 justify-content-center">
            <h1> Are you urgent? </h1>
            <br/>
            <select class="form-select" id="subject" aria-label="Default select example">
                <option value="Urgent-request">Yes</option>
                <option value="Blood-Request" selected>No</option>
            </select>

        </div>

        <div class="col-4">

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


<jsp:include page="base/modal-no-matchers.jsp"/>

<jsp:include page="base/footer.jsp"/>
<!-- Footer -->


<!-- End your project here-->

<!-- MDB -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript">
    console.log(document.getElementById("subject").value);

    document.getElementById("next").onclick = function () {
        // TODO: get matchers from server, if no

        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/book/getMatchers",
            data: { },  // data to submit
            success: function (data, status, xhr) {
                location.href = "/book/request-step4?subject=" + document.getElementById("subject").value;

            },
            error: function (jqXhr, textStatus, errorMessage) {
                $('p').append('Error' + errorMessage);
            }

        });


    };

    document.getElementById("prev").onclick = function () {
        location.href = "/book/request-step2";
    };
</script>
</body>
</html>
