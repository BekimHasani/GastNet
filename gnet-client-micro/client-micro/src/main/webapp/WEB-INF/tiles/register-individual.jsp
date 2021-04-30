<%@ include file="include.jsp"%>

<div class="container-fluid">
<h1 class="h3 mb-4 text-gray-800 text-center">Individual Credentials</h1>


<form action="process-signup-individual" method="post">
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.name">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Name" required />
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>

	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.lastName">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Last Name" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.state">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="State" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.city">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="City" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.birthDate">
				<input type="date" name="${status.expression}" data-date-format="MM/DD/YYYY"
				value="${status.value}" class="form-control form-control-user"
				placeholder="Date Of Birth" required/>
				<c:if test="${status.error} ">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.user.email">
				<input name="${status.expression}" class="form-control form-control-user" type="email" 
				value="${status.value}" placeholder="Email" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>

	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.phoneNumber">
				<input name="${status.expression}" class="form-control form-control-user" type="text" 
				value="${status.value}" placeholder="Phone Number" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.user.password">
				<input name="${status.expression}" class="form-control form-control-user" type="password" 
				value="${status.value}" placeholder="Password" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.user.retryPassword">
				<input name="${status.expression}" class="form-control form-control-user" type="password" 
				value="${status.value}" placeholder="Retry Password" required/>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.gender">
				<input name="${status.expression}" value="M" type="radio" ${status.value eq 'M' ? 'checked=\"checked\"' :''}/>
				<label for="male">M</label>
				<input name="${status.expression}" value="F" type="radio" ${status.value eq 'F' ? 'checked=\"checked\"' :''} />
				<label for="female">F</label>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-4 "></div>
		<div class="col-sm-4 mb-3 mb-sm-0">
			<spring:bind path="individualUser.individual.individualType">
				<select class="form-control form-control-user" name="${status.expression}" required>
					<option value="">Please select user type</option>
					<c:forEach items="${individualTypes}" var="individualType">
						<option value="${individualType}" ${individualType eq status.value}>${individualType.value}</option>							
					</c:forEach>
				</select>
				<c:if test="${status.error}">
					<c:forEach items="${status.errorMessage}" var="errorMessage">
							<font color="red"> <c:out value="${errorMessage}" /><br>
							</font>
					</c:forEach>
				</c:if>
			</spring:bind>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	
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