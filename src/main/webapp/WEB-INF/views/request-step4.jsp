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
                    <li class="active">Contact</li>
                </ul>
            </div>
        </div>

    </div>
</div>



<div class="container mt-5 mb-5">
    <div class="row">

        <div class="col-2">

        </div>

        <div class="col-2">
        </div>

        <div class="col-8">
            <p>We get some matching users. Enter your request below</p>

        </div>




    </div>
</div>




<div class="d-flex justify-content-center mt-5 mb-5">
    <i class="far fa-envelope fa-4x"></i>
</div>



<div class="container mt-5 mb-5">
    <div class="row">

        <div class="col-2">

        </div>


        <div class="col-8">
            <form>
                <!-- Message input -->
                <div class="form-outline mb-4">
                    <textarea class="form-control" id="message" rows="4"></textarea>
                    <label class="form-label" for="message">Message</label>
                </div>

<%--                <!-- Submit button -->--%>
<%--                <button type="submit" class="btn btn-primary btn-block mb-4">Send</button>--%>
            </form>
        </div>

        <div class="col-2">
        </div>


    </div>
</div>


<jsp:include page="base/modal.jsp"/>


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
            <button type="button" class="btn btn-primary" id="confirm" data-mdb-toggle="modal" data-mdb-target="#exampleModal">Confirm</button>
<%--            <a href="/book/request-confirm" class="btn btn-primary">Confirm</a>--%>
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
    document.getElementById("prev").onclick = function () {
        location.href = "/book/request-step3";
    };


    $("#confirm").click(function(){
        $.post("/book/request-confirm",
            {
                message: document.getElementById("message").value
            },

            function(data, status){
                window.location.href = "/book/request-confirm";
            });
    });
</script>
</body>
</html>
