<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>
	<div class="card-body col-sm-12">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Reports</h6>
			</div>
			<div class="table-wraper">
				<div class="table-responsive">
					<table class="table table-sm table-bordered" id="dataTable"
						aria-describedby="dataTable_info" style="width: 100%;">
						<thead>
							<tr>
								<th>Report Id</th>
								<th>Report Type</th>
								<th>Object Id</th>
								<th>Object Type</th>
								<th>User</th>
								<th>Report Status</th>
								<th>Details</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="report" items="${reports}">
								<tr role="row" class="odd">
									<td class="sorting_1">${report.reportId}</td>
									<td>${report.reportType}</td>
									<td>${report.objectId}</td>
									<td>${report.objectType}</td>
									<td>${report.user.email}</td>
									<td>${report.reportStatus}</td>									
									<td><button type="button" class="detaislBtn"
											data-toggle="modal" data-target="#exampleModalLong">Details</button>
										<div class="modal fade" id="exampleModalLong" tabindex="-1"
											role="dialog" aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title">Report Details</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
															<div class="left-contact-content">
																<form action="" method="">
																	<table class="tbt">
																		<tr>
																			<td><label>Report Id: </label></td>
																			<td>${report.reportId }</td>
																		</tr>
																		<tr>
																			<td><label>Report Type:</label></td>
																				<td>${report.reportType }</td>	
																		</tr>
																		<tr>
																			<td><label>Object Id:</label></td>
																			<td>${report.objectId }</td>
																		</tr>
																		<tr>
																			<td><label>Object Type:</label></td>
																			<td>${report.objectType}</td>	
																		</tr>
																		<tr>
																			<td><label>User :</label></td>
																			<td>${report.user.email}</td>
																		</tr>
																		<tr>
																			<td><label>Status:</label></td>	
																			<td>${report.reportStatus}</td>
																		</tr>																					
																	</table>
																	<br>
																	<label>Message:</label><br>
																	<p name="reportContnt">${report.description}</p>
																</form>
															</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="closeBtn "
															data-dismiss="modal">Close</button>
													</div>
												</div>
											</div>
										</div>
									</td>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>