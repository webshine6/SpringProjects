<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<div class="container">
    <h1>List of Users</h1>
    <table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
        <thead>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>email</th>
            <th>Date of birth</th>
            <th>Phone number</th>
            <th>Command</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        var data = eval('${users}');
        var table = $('#example').DataTable({
            "aaData": data,
            "aoColumns": [
                {
                    "mData": "firstName"
                },
                {
                    "mData": "lastName"
                },
                {
                    "mData": "email"
                },
                {
                    "mData": "dob"
                },
                {
                    "mData": "phoneNumber"
                },
                {
                    "mData": null,
                    "bSortable": false,
                    "mRender": function (user) {
                        var links = [
                            '<a class="btn btn-info btn-sm" href=./edit-user-' + user.firstName + '>' + 'Edit' + '</a>',
                            '<a class="btn btn-success btn-sm" href=./delete-user-' + user.id + '>' + 'Delete' + '</a>'];

                        return links;
                    },
                    "width": "20%"
                },
            ],
            "paging": true,
            "ordering": true,
            "order": [0, "asc"]

        });

    });
</script>