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
                <h1>Profile</h1>
            </div>

        </div>


    </div>
</div>




<div class="d-flex justify-content-center mt-5 mb-5">
    <i class="fas fa-user-circle fa-4x"></i>
</div>


<div class="row mt-3 mb-3">
    <div class="col-4"></div>
    <div class="col-2">First Name</div>
    <div class="col-2">
        <div class="form-outline">
            <input type="text" id="firstName" class="form-control" />
            <label class="form-label" for="firstNameForm" ><%= request.getAttribute("firstName")%></label>
        </div>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg" onclick="editFirstName()"></i>
    </div>
    <div class="col-5"></div>
</div>


<div class="row mt-3 mb-3">
    <div class="col-4"></div>
    <div class="col-2">Last Name</div>
    <div class="col-2">
        <div class="form-outline">
            <input type="text" id="lastNameForm" class="form-control" />
            <label class="form-label" for="lastNameForm"><%= request.getAttribute("lastName")%></label>
        </div>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg"></i>
    </div>
    <div class="col-5"></div>
</div>


<div class="row mt-3 mb-3">
    <div class="col-4"></div>
    <div class="col-2">Date of Birth</div>
    <div class="col-2">
        <div class="form-outline">
            <input type="text" id="dateOfBirth" class="form-control" />
            <label class="form-label" for="dateOfBirth"><%= request.getAttribute("dob")%></label>
        </div>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg"></i>
    </div>
    <div class="col-5"></div>
</div>

<div class="row mt-3 mb-5">
    <div class="col-4"></div>
    <div class="col-2">Gender</div>
    <div class="col-2">
        <select class="form-select" aria-label="Default select example">
            <option value="male" selected>Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg"></i>
    </div>
    <div class="col-5"></div>
</div>


<div class="row mt-5 mb-3">
    <div class="col-4"></div>
    <div class="col-2">Email</div>
    <div class="col-2">
        <div class="form-outline mb-3">
            <input
                    class="form-control"
                    id="formControlDisabled"
                    type="text"
                    placeholder="Disabled input"
                    aria-label="disabled input example"
                    disabled
            />
            <label class="form-label" for="formControlDisabled"><%= request.getAttribute("email")%></label>
        </div>
    </div>
    <div class="col-6"></div>
</div>


<div class="row mt-3 mb-5">
    <div class="col-4"></div>
    <div class="col-2">Mobile Number</div>
    <div class="col-2">
        <div class="form-outline">
            <input type="text" id="phoneNumber" class="form-control" />
            <label class="form-label" for="phoneNumber"><%= request.getAttribute("mobileNum")%></label>
        </div>
    </div>
    <div class="col-1">
        <i class="fas fa-pencil-alt fa-lg"></i>
    </div>
    <div class="col-5"></div>
</div>






<jsp:include page="base/footer.jsp"/>
<!-- Footer -->


<!-- End your project here-->

<!-- MDB -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript">

    function editFirstName(){
        let firstName = document.getElementById("firstName").value;

        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/profile?firstName=" + firstName ,
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

    function test(){
        alert("Hello");
    }


</script>
</body>
</html>
