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
                <h1>History</h1>
            </div>

        </div>


    </div>
</div>




<div class="d-flex justify-content-center mt-5 mb-5">
    <i class="fas fa-history fa-4x"></i>
</div>


<table class="table align-middle mb-0 bg-white ml-3 mt-5 mb-5">
    <thead class="bg-light">
    <tr>
        <th>History ID</th>
        <th>History Type</th>
        <th>Date</th>
        <th>Matched</th>


    </tr>
    </thead>
    <tbody>



    <% Map<String, List<HistoryRecord>> data = (Map<String, List<HistoryRecord>>) request.getAttribute("history");
        List<HistoryRecord> historyRecords = data.get("history");
        for (HistoryRecord entry : historyRecords) {
            out.println(
                    "<tr>\n" +
                            "                <td>\n" +
                            "                    <div class=\"d-flex align-items-center\">\n" +
                            "\n" +
                            "                        <div class=\"ms-3\">\n" +
                            "                            <p class=\"fw-bold mb-1 \">" + entry.getHistoryId() + "</p>\n" +
                            "\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                       <p class=\"fw-normal mb-1 \">" + entry.getHistoryType() + "</p>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                    <p class=\"fw-normal mb-1 \">" + entry.getDate() + "</p>\n" +
                            "\n" +
                            "                </td>\n" +
                    "                <td>\n" +
                            "                    <p class=\"fw-normal mb-1 \">" + entry.getMatched() + "</p>\n" +
                            "\n" +
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
