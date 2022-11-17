<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/11/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dpamanagement.entity.Users" %>
<%@ include file="../components/dashHeader.jsp"%>
<% List < Users > usersList = (List<Users>) request.getAttribute ( "usersList" ); %>

<%
    String deleteMessage = (String) request.getAttribute ( "deleteMessage" );
    Boolean deleted = Boolean.parseBoolean ( deleteMessage );
%>


<div class="content-wrapper">
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <% if(deleteMessage != null && !deleteMessage.isEmpty() && deleted) { %>
                <div class="col-6"></div>
                <div class="col-6 alert alert-success" role="alert">
                    User has deleted
                </div>
                <% } %>
                <% if(deleteMessage != null && !deleteMessage.isEmpty() && !deleted) { %>
                <div class="col-6"></div>
                <div class="col-6 alert alert-danger" role="alert">
                    User dont deleted
                </div>
                <% } %>
            </div>
            <div class="row mb-2">
                <div class="col-sm-6">
                    <p>Exercise List</p>
                </div>
                <div class="col-sm-4"></div>
                <div class="col-sm-2">
                    <button disabled type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUser">
                        Add User
                    </button>
                </div>
            </div>
        </div>
    </div>

    <section class="main-content content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">User List</h3>
                            <div class="card-tools">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-default">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body table-responsive p-0">
                            <table class="table table-hover text-nowrap">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Fullname</th>
                                    <th>Phone</th>
                                    <th>State</th>
                                    <th>Role</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (Users users : usersList) {
                                        out.println ("<tr>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editUser' onclick='chargingModal(event)'>" + users.getId () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editUser' onclick='chargingModal(event)'>" + users.getFirstName () + " " + users.getLastName () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editUser' onclick='chargingModal(event)'>" + users.getPhone ()+ "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editUSer' onclick='chargingModal(event)'>" + users.isState () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editUSer' onclick='chargingModal(event)'>" + users.getRole ().getName () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editUSer' onclick='chargingModal(event)'>" + users.getEmail () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editUSer' onclick='chargingModal(event)'>" + users.getUsername () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editUSer' onclick='chargingModal(event)'>" + users.getPassword () + "</td>");
                                        out.println( "<td><a href='deleteUser?id=" + users.getId () + "'>Delete</a></td>");
                                        out.println("</tr>");
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- edit modal -->
<!-- Modal -->
<div class="modal fade" id="editUser" tabindex="-1" aria-labelledby="editUserLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editExerciceLabel">Edit User</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="editUser" method="post" name="editUser" class="me-3">
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <input type="hidden" name="password" id="password">
                    <div class="form-group d-flex gap-3">
                        <div>
                            <label for="firstname" class="form-label">Firstname</label>
                            <input type="text" name="firstname" id="firstname" class="form-control">
                        </div>
                        <div>
                            <label for="lastname" class="form-label">Lastname</label>
                            <input type="text" name="lastname" id="lastname" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" name="email" id="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="tel" name="phone" id="phone" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="status" class="form-label">Status</label>
                        <select class="form-control" name="status" id="status">
                            <option value="true">Active</option>
                            <option value="false">inactive</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="role" class="form-label">Role</label>
                        <select class="form-control" name="role" id="role">
                            <option value="utilisateur">Utilisateur</option>
                            <option value="administrateur">Administrateur</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input class="btn btn-primary" type="submit" value="save changes">
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    window.onload = function() {
        setTimeout(function(){
            let elt = document.querySelector(".alert");
            elt.style.display = "none"
        }, 3000);
    }
</script>

<script>
    function chargingModal(event) {
        let parent = event.target.parentElement;
        console.log(parent);
        let form = document.forms["editUser"];

        form.id.value = parent.children[0].innerText;
        let fullname = parent.children[1].innerText;
        fullname = fullname.split(" ");
        form.firstname.value = fullname[0];
        form.lastname.value = fullname[1];
        form.phone.value = parent.children[2].innerText;
        form.status.value = parent.children[3].innerText
        form.role.value = parent.children[4].innerText;
        form.email.value = parent.children[5].innerText;
    }
</script>

<%@ include file="../components/dashFooter.jsp"%>
