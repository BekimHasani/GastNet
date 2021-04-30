<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<c:set var="individualUser" value="${individualUser}" />

	<div id="Experience" class="content-body show">
		<div id="wrapper">
			<h2>Experiences</h2>
			<button type="button" class="newBtn bms" data-toggle="modal"
				data-target="#exampleModalLong">New</button>
			<div class="modal fade" id="exampleModalLong" tabindex="-1"
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
								<form:form action="new-experience" id="experience-form"
									modelAttribute="newIndividualExperience" method="POST"
									enctype="multipart/form-data">
									<table class="info">
										<tr>
											<td><label>Job Title: </label></td>
											<td><form:select type="text" id="jobTitle"
													class="fadeIn second txtDecor" path="jobTitle" placeholder="Job Title">
													<form:options items="${jobTitles}" class="jobTitle-select" />
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
									<form:textarea type="text" id="exp-description"
										class="fadeIn second" path="description"
										placeholder="Description"/>
								</form:form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" form="experience-form" class="closeBtn">Add</button>

						</div>
					</div>
				</div>
			</div>
		</div>


		<c:forEach var="experience" items="${individualExperience}">				
			<div class="container-2 card shadow mb-4 ">
				<h4>${experience.jobTitle}</h4>
				<h6><fmt:formatDate value="${experience.startDate}" pattern="dd/MM/yyyy" /> - <fmt:formatDate value="${experience.endDate}" pattern="dd/MM/yyyy" /></h6>
				<br>
				<h6>Work Desc :</h6>
				<p>${experience.description}</p>
				<form action="delete-experience" method="POST">
				<input name="experienceId" type="hidden" value="${experience.experienceId}" />
				<input type="submit" value="delete" class="updateBtn bmi"
					onClick="return confirm('Are you sure?')" />
			</form>
			</div>
		</c:forEach>
	</div>