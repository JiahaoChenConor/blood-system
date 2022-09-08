<%@ page import="com.elec5619.bloodsystem.entity.MessageRecord" %>
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


<table class="table align-middle mb-0 bg-white ml-3 mt-5 mb-5">
    <thead class="bg-light">
    <tr>
        <th>Sender</th>
        <th>Subject</th>
        <th>Date</th>
        <th>Action</th>


    </tr>
    </thead>
    <tbody>



    <% Map<String, List<MessageRecord>> data = (Map<String, List<MessageRecord>>) request.getAttribute("messages");
        List<MessageRecord> messageRecords = data.get("messages");
        for (MessageRecord entry : messageRecords) {
            out.println(
                    "<tr>\n" +
                            "                <td>\n" +
                            "                    <div class=\"d-flex align-items-center\">\n" +
                            "\n" +
                            "                        <div class=\"ms-3\">\n" +
                            "                            <p class=\"fw-bold mb-1 \">" + entry.getSender() + "</p>\n" +
                            "\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                   <a href=\"/admin/messages/" + entry.getMessageId() + "\">" +
                            "                       <p class=\"fw-normal mb-1 \">" + entry.getSubject() + "</p>\n" +
                            "                       </a>" +
                            "                </td>\n" +
                            "                <td>\n" +
                            "                    <p class=\"fw-normal mb-1 \">" + entry.getDate() + "</p>\n" +
                            "\n" +
                            "                </td>\n" +
                    "                <td>\n" +

                            "                   <button value= \"" + entry.getMessageId() +  "\" id=\"delete\"" + entry.getMessageId()
                                                + "type=\"button\" class=\"btn btn-outline-danger btn-rounded\" data-mdb-ripple-color=\"dark\"" +
                            "                       onclick=\"deleteMessage(" + entry.getMessageId() + ")\">" +
                            "                       Delete</button>" +
                            "\n" +
                            "                </td>\n"




            );



        }




    %>


    </tbody>
</table>




<br/>
<br/>
<br/>
<div class="container mt-5 mb-5">
    <div class="row">
        <div class="col-8">
            <a href="/index-admin">
                <button type="button" class="btn btn-primary" >Back</button>
            </a>
        </div>


        <div class="col-3">
        </div>

        <div class="col-1">
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
   function deleteMessage(messageId){
        $.post("/admin/delete",
            {
                messageId: messageId
            },

            function(data, status){
                window.location.href = window.location.pathname;
            });
    }
</script>
</body>
</html>
