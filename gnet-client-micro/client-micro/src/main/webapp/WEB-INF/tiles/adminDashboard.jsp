<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>

	<div class="row form-cardline mx-2">

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-primary text-uppercase mb-1">Individual
								Users</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800"><%=request.getAttribute("individuals")%></div>
						</div>
						<div class="col-auto">
							<img src="img/user.png" style="width: 25px; height: 30px;"></img>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-success text-uppercase mb-1">Business
								Users</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800"><%=request.getAttribute("businesses")%></div>
						</div>
						<div class="col-auto">
							<img src="img/small-business.png"
								style="width: 28px; height: 33px;"></img>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-info text-uppercase mb-1">PENDING
								REPORTS</div>
							<div class="row no-gutters align-items-center">
								<div class="col-auto">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%=request.getAttribute("pendingReports") %></div>
								</div>
								<div class="col">
									<div class="mr-2"></div>
								</div>
							</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pending Requests Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-warning text-uppercase mb-1">CHECKED
								REPORTS</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800"><%=request.getAttribute("checkedReports") %></div>
						</div>
						<div class="col-auto">
							<img src="img/unnamed.png" style="width: 28px; height: 33px;"></img>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="char-flex">
		<div class="card shadow m-4 char-width">
			<div class="card-header mb-4">
				<h6 class="m-0 font-weight-bold text-primary">Currently Active
					Users</h6>
			</div>
			<div class="card-body">
				<div class="chart-bar">
					<canvas id="myAreaChart"></canvas>
				</div>
				<hr>
				This chart represent currently logged in users.
			</div>
		</div>

		<div class="card shadow m-4 char-width">
			<div class="card-header mb-4">
				<h6 class="m-0 font-weight-bold text-primary ">Opened Job
					Applications</h6>
			</div>
			<div class="card-body">
				<div class="chart-bar">
					<canvas id="myBarChart"></canvas>
				</div>
				<hr>
				This chart represents free open job positions.
			</div>
		</div>
	</div>



	<div class="card-body col-sm-12">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Admin Users</h6>
			</div>
			<div class="table-wraper">
				<div class="table-responsive">
					<table class="table table-sm table-bordered dataTable " width="80%"
						cellspacing="0" role="grid" id="dataTable"
						aria-describedby="dataTable_info" style="width: 100%;">
						<thead>
							<tr>
								<th>Admin Id</th>
								<th>Email</th>
								<th>Creation Date</th>
								<th>Status</th>
								<th>Role</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="adminUser" items="${adminUsers}">
								<tr role="row" class="odd">
									<td class="sorting_1">${adminUser.userId}</td>
									<td>${adminUser.email}</td>
									<td>${adminUser.creationDate}</td>
									<td>${adminUser.status}</td>
									<td>${adminUser.role}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>