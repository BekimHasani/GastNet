<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="Skill" class="content-body hide">
	<div id="wrapper">
		<h2>Skills</h2>
		<button type="button" class="newBtn bms" data-toggle="modal"
			data-target="#exampleModalLong1">New</button>
		<div class="modal fade" id="exampleModalLong1" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">New Skill</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="left-contact-content">
							<form:form action="new-skill" id="new-skill"
								modelAttribute="newIndividualSkill" method="POST"
								enctype="multipart/form-data">
								<h6>Add skill description:</h6>
								<form:textarea type="text" id="skill-description"
									class="fadeIn second" path="skill" placeholder="Description" />
							</form:form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="closeBtn" form="new-skill">Add</button>

					</div>
				</div>
			</div>
		</div>
	</div>
	<c:forEach var="skills" items="${individualSkills}" varStatus="index">
		<div class="container-2 card shadow mb-4 ">
			<h4 class="skillTxt">${skills.skill}</h4>
			<form action="delete-skill" method="POST">
				<input name="id" type="hidden" value="${skills.id}" />
				<input type="submit" value="delete" class="updateBtn bmi"
					onClick="return confirm('Are you sure?')" />
			</form>
		</div>
	</c:forEach>
</div>