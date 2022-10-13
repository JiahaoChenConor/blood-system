<%@ page import="com.elec5619.bloodsystem.domain.MessageRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.domain.HistoryRecord" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>
<body>
<!-- Start your project here-->

<jsp:include page="base/nav-user.jsp"/>

<!-- Jumbotron -->
<div class="p-5 text-center bg-light">
    <i class="far fa-check-circle fa-6x" style="color:#11e314"></i>
    <br/>
    <br/>
    <h1 class="mb-3">Congratulations! upload success</h1>

</div>
<!-- Jumbotron -->
<div class="container mt-5 mb-5">
    <div class="row">

        <div class="col-sm">
        </div>

        <div class="col-sm">
            <a href="/health-info">
                <button type="button" class="btn btn-success">Back</button>
            </a>
        </div>

        <div class="col-sm">
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



</script>
</body>
</html>
