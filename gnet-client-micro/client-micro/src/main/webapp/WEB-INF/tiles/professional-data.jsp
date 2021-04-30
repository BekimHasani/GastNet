<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="ProffesionalData" class="content-body hide">
	<div id="wrapper">
		<h2>Professional Data</h2>
		<button type="button" class="newBtn bms" data-toggle="modal"
			data-target="#exampleModalLong3">New</button>
			<div class="modal fade" id="exampleModalLong3" tabindex="-1"
				role="dialog" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">New Experience</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="left-contact-content">
								<form:form action="new-professionalData" id="data-form"
									modelAttribute="newIndividualProfessionalData" method="POST"
									enctype="multipart/form-data">
									<table class="info">
										<tr>
											<td><label>Title: </label></td>
											<td><form:input type="text" id="dataTitle"
													class="fadeIn second txtDecor" path="title" placeholder="Data Title"/></td>
										</tr>
										<tr>
											<td><label>Activity Type: </label></td>
											<td><form:select type="text" id="jobTitle"
													class="fadeIn second txtDecor" path="activityType" placeholder="Activity Type">
													<form:options items="${activityType}" class="jobTitle-select" />
												</form:select></td>
										</tr>
										<tr>
											<td><label>Start Date:</label></td>
											<td><form:input type="Date" id="startDate"
													class="fadeIn second txtDecor" data-date-format="DD MMMM YYYY"
													path="startDate" placeholder="Start Date" /></td>
										</tr>
										<tr>
											<td><label>End Date:</label></td>
											<td><form:input type="Date" id="endDate"
													class="fadeIn second txtDecor" path="endDate" placeholder="End Date" /></td>
										</tr>
									</table>
									<form:textarea type="text" id="dep-description"
										class="fadeIn second" path="description"
										placeholder="Description" />
									<form:input type="file" id="data-file"
										class="fadeIn second" path=""
										placeholder="Description" />
								</form:form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit"  form="data-form" class="closeBtn ">Add</button>

						</div>
					</div>
				</div>
			</div>
	</div>
	<c:forEach var="data" items="${individualProfessionalData}">
		<div class="container-2 card shadow mb-4 ">
			<h4>${data.title}</h4>
			<h5>${data.activityType}</h5>
			<h6><fmt:formatDate value="${data.startDate}" pattern="dd/MM/yyyy" /> - <fmt:formatDate value="${data.endDate}" pattern="dd/MM/yyyy" /></h6>
			<p>${data.description}</p>
			<form action="delete-data" method="POST">
				<input name="professionalDataId" type="hidden" value="${data.professionalDataId}" />
				<input type="submit" value="delete" class="updateBtn bmi"
					onClick="return confirm('Are you sure?')" />
			</form>
		</div>
	</c:forEach>
</div>