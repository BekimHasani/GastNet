<%@ include file="include.jsp"%>

<div class="container-fluid">
<h1 class="h3 mb-4 text-gray-800 text-center">Register Business</h1>
<br>

<form action="process-signup-business" method="post">
	
	<div class="form-group row">
		<div class="col-sm-3 "></div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.business.name">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Name" required />
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3 mb-1 mb-sm-0">
			<spring:bind path="businessUser.location.state">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="State" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div><br>
	
	<div class="form-group row">
		<div class="col-sm-3 "></div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.business.businessNumber">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Business Number" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		
		
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.location.city">
				<input name="${status.expression}"
					class="form-control form-control-user" type="text"
					value="${status.value}" placeholder="City" required />
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
						<font color="red"> <c:out value="${errorMessage}" /><br>
						</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div><br>
	
	<div class="form-group row">
		<div class="col-sm-3 "></div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.user.password">
				<input name="${status.expression}" class="form-control form-control-user" type="password" 
				value="${status.value}" placeholder="Password" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.location.address">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Street" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div><br>

	<div class="form-group row">
		<div class="col-sm-3 "></div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.user.retryPassword">
				<input name="${status.expression}" class="form-control form-control-user" type="password" 
				value="${status.value}" placeholder="Retry Password" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.emailContact.contactValue">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Email" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div><br>
	
	<div class="form-group row">
		<div class="col-sm-3 "></div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.business.category">
				<select class="form-control form-control-user" name="${status.expression}" required>
					<option value="">Please select user type</option>
					<c:forEach items="${categories}" var="category">
						<option value="${category}" ${category eq status.value}>${category.value}</option>							
					</c:forEach>
				</select>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3 mb-3 mb-sm-0">
			<spring:bind path="businessUser.phoneContact.contactValue">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Phone Number" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div><br>
	
	<div class="form-group row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<input type="submit" class="btn btn-primary btn-user col-sm-12"
				value="Insert">
		</div>
		<div class="col-sm-3"></div>
	</div>
 
</form>
</div>