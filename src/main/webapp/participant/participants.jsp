
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.dpamanagement.entity.Participant" %>
<%@ page import="java.util.List" %>
<%@ include file="../components/dashHeader.jsp"%>
<% List < Participant > participantList = (List<Participant>) request.getAttribute ( "participantList" ); %>

<div class="content-wrapper">
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <p>Participant List</p>
                </div>
                <div class="col-sm-4"></div>
                <div class="col-sm-2">
                    <button disabled type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addParticipant">
                        Add Participant
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
                            <h3 class="card-title">Participant List</h3>
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
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (Participant participant : participantList) {
                                        out.println ("<tr>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getId () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getFirstName () + " " + participant.getLastName () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getPhone ()+ "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.isState () + "</td>");
                                        out.println( "<td data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getRole ().getName () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getEmail () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getUsername () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getPassword () + "</td>");
                                        out.println( "<td  class='d-none'  data-bs-toggle='modal' data-bs-target='#editParticipant' onclick='chargingModal(event)'>" + participant.getStructure () + "</td>");

                                        out.println( "<td><a href='deleteParticipant?id=" + participant.getId () + "'>Delete</a></td>");
                                        out.println("</tr>");
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
            <!-- /.row -->
        </div>
    </section>
</div>

<!-- edit modal -->
<!-- Modal -->
<div class="modal fade" id="editParticipant" tabindex="-1" aria-labelledby="editParticipantLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editExerciceLabel">Edit Participant</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="editParticipant" method="post" name="editParticipant" class="me-3">
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

<!-- Add Modal
<div class="modal fade" id="addExercice" tabindex="-1" aria-labelledby="addExerciceLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="addExerciceLabel">Add Exercice</h5>
<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
</div>
<form action="addExercice" method="post" name="addExercice">
<div class="modal-body">
<div class="form-group">
<label for="year" class="form-label">Year</label>
<input type="text" name="year" id="_year" class="form-control">
</div>
<div class="form-group">
<label for="dateDebut" class="form-label">Start date</label>
<input type="date" name="dateDebut" id="_dateDebut" class="form-control">
</div>
<div class="form-group">
<label for="dateFin" class="form-label">End date</label>
<input type="date" name="dateFin" id="_dateFin" class="form-control">
</div>
<div class="form-group">
<label for="statusTrue" class="">Active</label>
<input type="radio" name="status" id="_statusTrue" value="true" class="">
<label for="statusFalse" class="">Inactive</label>
<input type="radio" name="status" id="_statusFalse" value="false" class="">
</div>
<div class="form-group">
<label for="description" class="form-label">Description</label>
<textarea name="description" id="_description" cols="30" rows="4" class="form-control"></textarea>
</div>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
<input type="submit" value="add" class="btn btn-primary">
</div>
</form>
</div>
</div>
</div>
-->
<script>
    function chargingModal(event) {
        let parent = event.target.parentElement;
        console.log(parent);
        let form = document.forms["editParticipant"];

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
