<%@ page import="com.dpamanagement.entity.Activity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dpamanagement.entity.Exercice" %>
<%@ page import="com.dpamanagement.entity.Participant" %>
<%@ include file="../components/dashHeader.jsp"%>
<% List < Activity > activityList = (List<Activity>) request.getAttribute ( "activityList" ); %>
<% List < Exercice > exerciceList = (List<Exercice>) request.getAttribute ( "exerciceList" ); %>
<% List < Participant > participantList = (List<Participant>) request.getAttribute ( "participantList" ); %>


<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/2/2022
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="content-wrapper">
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <p>Activity List</p>
                </div>
                <div class="col-sm-4"></div>
                <div class="col-sm-2">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addActivity">
                        Add Activity
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
                            <h3 class="card-title">Activities List</h3>
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
                                    <th>Start</th>
                                    <th>End</th>
                                    <th>Status</th>
                                    <th>Description</th>
                                    <th>Title</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                for (Activity activity : activityList) {
                                out.println ("<tr>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getId () + "</td>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getDateDebut () + "</td>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getDateFin () + "</td>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getDescription () + "</td>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getStatus () + "</td>");
                                    out.println( "<td data-bs-toggle='modal' data-bs-target='#editActivity' onclick='chargingModal(event)'>" + activity.getTitle () + "</td>");
                                    out.println( "<td><a href='deleteActivity?id=" + activity.getId () + "'>Delete</a></td>");
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
<div class="modal fade" id="editActivity" tabindex="-1" aria-labelledby="editActivityLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editActivityLabel">Edit Activity</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="editActivity" method="post" name="editActivity">
                <input type="hidden" name="id">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="dateDebut" class="form-label">Start date</label>
                        <input type="text" name="dateDebut" id="dateDebut" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="dateFin" class="form-label">End date</label>
                        <input type="date" name="dateFin" id="dateFin" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="Description" class="form-label">Description</label>
                        <input type="date" name="description" id="Description" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="statusTrue" class="form-check-label">Active</label>
                        <input type="radio" name="status" id="statusTrue" value="true" class="form-check-input">
                        <label for="statusFalse" class="form-check-label">Inactive</label>
                        <input type="radio" name="status" id="statusFalse" value="false" class="form-check-input">
                    </div>
                    <div class="form-group">
                    <label for="title" class="form-label">Title</label>
                    <textarea name="title" id="title" cols="30" rows="4" class="form-control"></textarea>
                </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" value="save changes" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Add Modal -->
<div class="modal fade" id="addActivity" tabindex="-1" aria-labelledby="addActivityLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addActivityLabel">Add Activity</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="addActivity" method="post" name="addActivity">
                <div class="modal-body">

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
                    <div class="form-group">
                        <label for="title" class="form-label">Title</label>
                        <textarea name="title" id="_title" cols="30" rows="4" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-label" for="exercice">Exercice</label>
                        <select class="form-control" id="exercice" name="exercice">
                            <% for ( Exercice exercice : exerciceList ) { %>
                                <option value="<%=exercice.getId()%>"><%=exercice.getDescription()%></option>
                            <% } %>
                        </select>
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
<script>
    function chargingModal(event) {
        let parent = event.target.parentElement;
        let form = document.forms['editActivity'];

        form.id.value = parent.children[0].innerText;
        form.dateDebut.value = parent.children[1].innerText;
        form.dateFin.value = parent.children[2].innerText;
        if (parent.children[3].innerText == 'false') {
            document.getElementById('statusFalse').checked  = true;
        } else {
            document.getElementById('statusTrue').checked  = true;
        }
        form.description.value = parent.children[4].innerText;
        form.title.value = parent.children[5].innerText;
    }
</script>
<%@ include file="../components/dashFooter.jsp"%>

