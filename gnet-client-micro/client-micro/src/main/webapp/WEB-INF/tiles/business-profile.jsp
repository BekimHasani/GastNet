<%@ include file="include.jsp"%>
<div>
	<!-- Left page content  -->
	<div class="d-flex justify-content-between ">
		<div class="col-xl-8 ">
			<div class="card card-profile shadow bg-light">
				<div class="card-body d-flex flex-column border border-gray" >
					<div>
						<img class="rounded-0" src="/img/armendi.jpg" width="100%" height="200">
					</div>
					<div class="pt-2">
						<div class="d-flex justify-content-between">
							<h4>${business.businessName}</h4>
							<h4>${business.category.value}</h4>
						</div>
						<hr>
						<c:if test="${business.description != null }">
							<div class="w-100 p-3 rounded border border-gray mt-2 bg-white">
									<p>${business.description}</p>
							</div>	
						</c:if>
					</div>
				</div>
			</div>
			
			<c:if test="${contacts != null}">
				<!-- Contact info -->
				<div class="mt-2">
					<div class="card card-profile shadow px-3 pt-2 bg-light ">
						<div class="card-body d-flex justify-content-between">
							<h5>Contact info</h5>
							<form action="">
								<input type="submit" value="Add new contact info" class="btn btn-outline-primary">
							</form>
						</div>
						<hr>
						<div class="d-flex justify-content-around">
							<c:forEach items="${contacts}" var="contact">
								
							</c:forEach>
						</div>
					</div>
				</div>
			</c:if>
			
			<c:if test="${locations != null}">
				<!-- Location info -->
				<div class="mt-2 mb-4">
					<div class="card card-profile shadow px-3 pt-2 bg-light ">
						<div class="card-body d-flex justify-content-between">
							<h5>Location info</h5>
							<form action="">
								<input type="submit" value="Add a new location" class="btn btn-outline-primary">
							</form>
						</div>	
						
						<hr>
						<div class="card-body ">
							<div class="d-flex">
								<div class="w-25 d-flex justify-content-center">
									<div class="border border-gray p-1  bg-white">
										<img class="rounded-0" src="/img/armendi.jpg" width="150" height="150">
									</div>
								</div>
								<div class="w-25 bg-white rounded border border-gray p-3">
									<table class="h-100">
										<tbody>
											<tr>
												<th class="col-sm-1">State:</th>
												<td class="col-sm-1">${location.state} </td>
											</tr>
											<tr>
												<th class="col-sm-1">City:</th>
												<td class="col-sm-1">${location.city} </td>
											</tr>
											<tr>
												<th class="col-sm-1">Address:</th>
												<td class="col-sm-1">${location.address} </td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="w-75 p-3 rounded border border-gray ml-3 bg-white">
									<p>${location.description}</p>
								</div>		
							</div>
							<div class="d-flex flex-row-reverse mt-2">
								<form action="">
									<input type="submit" value="Edit Info" class="btn btn-primary">
								</form>
							</div>	
						</div>
						
					</div>
				</div>
			</c:if>
		</div>
		
		
		<div class="col-xl-4 mb-4">
			<div class="card card-profile shadow p-3">
				<div class="card-body d-flex justify-content-between">
					<h5>Exeprtises</h5>
					<form action="">
						<input type="submit" value="Add new expertise" class="btn btn-outline-primary">
					</form>
				</div>
				<c:if test="${expertises != null}">
					<c:forEach items="${expertises}" var="expertise">
						<hr>
						<div class="card-body">
							<h6><b>${expertise.expertise}</b></h6>
							<p class="pt-2">${expertise.description}</p>
						</div>
					</c:forEach>
				</c:if>
				<div class="card-body">
					<h6><b>Expertiese Name</b></h6>
					<p class="pt-2">This is the description of the expertiese that this business has</p>
				</div>
				<button class="btn btn-primary">Show more</button>
			</div>
			<div class="card card-profile shadow p-3 mt-2">
				<div class="card-body d-flex justify-content-between">
					<h5>Top Reviews</h5>
				</div>
				<c:if test="${reviews != null }">
					<c:forEach items="${reviews}" var="review">
						<hr>
						<div class="card-body">
							<h6><b>${review.name}</b>&nbsp;${review.rating}&#9734; </h6>
							<p class="pt-2">${review.comment}</p>
						</div>
					</c:forEach>
				</c:if>
				<div class="d-flex flex-row-reverse">
					<form action="">
						<input type="submit" value="Show All" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>
	
</div>