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



        <div class="col-12 bg-light">
            <div class="d-flex justify-content-center mt-5 mb-5">
                <h1>Reply</h1>
            </div>

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
            <button type="button" class="btn btn-primary" id="confirm">Confirm</button>
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

    $("#confirm").click(function(){
        $.post(window.location.pathname,
            {
                message: document.getElementById("message").value,
            },
            function(data, status){
                window.location.href = "/index-user";
            });
    });
</script>
</body>
</html>
