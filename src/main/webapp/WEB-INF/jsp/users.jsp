<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<jsp:include page="header.jsp"/>
<br>

<div class="container">
    <button class="btn btn-primary" onclick="add()">Add User</button>
    <table class="table table-striped table-hover table-sm" id="datatable">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Birthday</th>
            <th>Login</th>
            <th>Password</th>
            <th>About Myself</th>
            <th>Address</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    </table>
</div>

<div class="modal fade" id="editRow" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Add user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="col-form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name"
                               placeholder="name">
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-form-label">Surname</label>
                        <input type="text" class="form-control" id="lastName" name="lastName"
                               placeholder="Last Name">
                    </div>
                    <div class="form-group">
                        <label for="birthday" class="col-form-label">Birthday</label>
                        <input type="datetime-local" class="form-control" id="birthday" name="birthday"
                               placeholder="birthday">
                    </div>
                    <div class="form-group">
                        <label for="login" class="col-form-label">Login</label>
                        <input type="text" class="form-control" id="login" name="login"
                               placeholder="Login">
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="aboutMyself" class="col-form-label">About Myself</label>
                        <input type="text" class="form-control" id="aboutMyself" name="aboutMyself"
                               placeholder="About Myself">
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-form-label">Address</label>
                        <input type="text" class="form-control" id="address" name="address"
                               placeholder="Address">
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="save()">Save</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
