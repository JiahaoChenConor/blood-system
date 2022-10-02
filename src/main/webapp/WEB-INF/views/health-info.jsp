<%@ page import="com.elec5619.bloodsystem.entity.MessageRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.entity.HistoryRecord" %>
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
                <h1>Health Info</h1>
            </div>

        </div>


    </div>
</div>




<div class="d-flex justify-content-center mt-5 mb-5">
    <i class="fas fa-briefcase-medical fa-4x"></i>
</div>




<div class="row mt-3 mb-3">
        <div class="col-4">
        </div>

        <div class="col-2">
            Blood Type
        </div>

        <div class="col-2">
            <select class="form-select" id="blood-type" aria-label="Default select example">
                <option value="A" selected>A</option>
                <option value="B">B</option>
                <option value="AB">AB</option>
                <option value="O">O</option>
            </select>
        </div>

        <div class="col-1">
            <i class="fas fa-pencil-alt fa-lg" onclick="editBloodType()"></i>
        </div>
        <div class="col-5"></div>

</div>

<div class="row mt-3 mb-5">
    <div class="col-4"></div>
    <div class="col-2">Age</div>
    <div class="col-2">
        <div class="form-outline">
            <input type="text" id="age" class="form-control" />
            <label class="form-label" for="age" > 18 </label>
        </div>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg" onclick="editAge()"></i>
    </div>
    <div class="col-5"></div>
</div>

<br/>
<br/>


<div class="d-flex justify-content-center mt-5 mb-5">
    <h3 > Upload </h3>
</div>




<div class="container mt-5 mb-5">
    <div class="row">

        <div class="col-sm">
        </div>

        <div class="col-sm">
            <form method="post" action="upload" enctype="multipart/form-data">
                <label class="form-label" for="customFile">Please upload your health info provement</label>
                <input type="file" name="upload"  class="form-control" id="customFile" />

                <br/><br/>
                <input type="submit" value="Submit"/>
            </form>

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
    function editAge(){
        let age = document.getElementById("age").value;
        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/health-info?age=" + age ,
            data: { },  // data to submit
            success: function (data, status, xhr) {
                if (data === "true"){
                    alert("Edit Success");

                }

            },
            error: function (jqXhr, textStatus, errorMessage) {
                $('p').append('Error' + errorMessage);
            }

        });
    }


    function editBloodType(){
        let bloodType = document.getElementById("blood-type").value;
        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/health-info?bloodType=" + bloodType ,
            data: { },  // data to submit
            success: function (data, status, xhr) {
                if (data === "true"){
                    alert("Edit Success");

                }

            },
            error: function (jqXhr, textStatus, errorMessage) {
                $('p').append('Error' + errorMessage);
            }

        });
    }






</script>
</body>
</html>
