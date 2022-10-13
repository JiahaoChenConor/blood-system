<%@ page import="com.elec5619.bloodsystem.domain.MessageRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.elec5619.bloodsystem.domain.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base/header.jsp"/>
</head>
<body>
<!-- Start your project here-->

<jsp:include page="base/nav-admin.jsp"/>


<div class="container mt-5 mb-5">
    <div class="row">



        <div class="col-12 bg-light">
            <div class="d-flex justify-content-center mt-5 mb-5">
                <h1>All Users</h1>
            </div>

        </div>


    </div>
</div>




<div class="d-flex justify-content-center mt-5 mb-5">
    <i class="fas fa-users fa-4x"></i>
</div>


<table class="table align-middle mb-0 bg-white ml-3 mt-5 mb-5">
    <thead class="bg-light">
    <tr>
        <th>User</th>
        <th>Action</th>



    </tr>
    </thead>
    <tbody>

    <a href=""></a>

    <% Map<String, List<Account>> data = (Map<String, List<Account>>) request.getAttribute("users");
        List<Account> accounts = data.get("users");
        for (Account entry : accounts) {
            out.println(
                    "<tr>\n" +
                            "                <td>\n" +
                            "                    <div class=\"d-flex align-items-center\">\n" +
                            "\n" +
                            "                        <div class=\"ms-3\">\n" +
                            "                            <p class=\"fw-bold mb-1 \">" + entry.getEmail() + "</p>\n" +
                            "\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                                                 "<a href=\"" + "/admin/user-message/" + entry.getId() +  "\">" +
                                                        "<button type=\"button\" class=\"btn btn-outline-primary btn-rounded\" data-mdb-ripple-color=\"dark\">Messages</button>"
                                                 + "</a>"+
                            "                </td>\n"



            );



        }




    %>


    </tbody>
</table>





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
