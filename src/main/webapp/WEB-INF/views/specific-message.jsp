<%@ page import="com.elec5619.bloodsystem.domain.MessageRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
                <h1>Messages</h1>
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
            <div class="card">
                <div class="card-body"><%= request.getAttribute("message")%></div>
            </div>
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
            <button type="button" class="btn btn-primary" id="reply" >Reply</button>
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
    document.getElementById("reply").onclick = function () {
        const arr = window.location.pathname.split("/");
        const messageId = arr[arr.length - 1];
        console.log(messageId);
        location.href = "/messages/" + messageId + "/reply";
    };
</script>
</body>
</html>
