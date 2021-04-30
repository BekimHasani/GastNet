<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="flex-display ml-60" style="width: 100%;">
	<div class="card shadow flex-display pl-40 w-95" >
		<div class="ram  ml-100 inlineDisplay p-20">
			<img class="profileImg card shadow"
				src="https://source.unsplash.com/QAB-WJcbgJk/60x60" />
			<p>Profile Picture</p>

		</div>

		<div class="inline-display p-50 ">
			<div class="">
				<form action="">
					<table class="tbt info">
						<c:set var="individualUser" value="${individualUser}" />
						<c:set var="email" value="${individualEmail}" />
						<tr>
							<td><label>First name: </label></td>
							<td>${individualUser.name}</td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td>${individualUser.lastName}</td>
						</tr>
						<tr>
							<td><label>Birth date:</label></td>
							<td><fmt:formatDate value="${individualUser.birthDate}"
									pattern="dd-MM-yyyy" /></td>
						</tr>
						<tr>
							<td><label>Gender:</label></td>
							<td>${individualUser.gender}</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="inline-display p-50 mr-60">
			<div class="">
				<form action="" method="">
					<table class="tbt info">
						<tr>
							<td><label>Type: </label></td>
							<td>${individualUser.individualType }</td>
						</tr>
						<tr>
							<td><label>Phone number:</label></td>
							<td>${individualUser.phoneNumber}</td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td>${email}</td>
						</tr>
						<tr>
							<td><label>Adress: </label></td>
							<td>${individualUser.city} - ${individualUser.state}</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<hr style="width: 93%; margin-right: 2.2%;">


<div class="titles-wraper relative-position	">
	<table class="tbt titles">
		<tr>
			<td><button class="btn" onclick="showExperience()">Experience</button></td>
		</tr>
		<tr>
			<td><button class="btn" onclick="showSkills()">Skills</button></td>
		</tr>
		<tr>
			<td><button class="btn" onclick="showData()">Professional
					Data</button></td>
		</tr>
	</table>

	<div class="container-1 card shadow mb-4 ">
		<!-- 	Experiences -->
		<%@ include file="experience.jsp"%>

		<!-- 	Skills     -->
		<%@ include file="individual-skill.jsp"%>

		<!-- 	ProfessionalData -->
		<%@ include file="professional-data.jsp"%>

	</div>


</div>
























