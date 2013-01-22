<div class="row">
	<div class="span12">
		<h2>address</h2>
	</div>
</div>

<hr/><br/>

<div class="row">
	<div class="span4">
		<h4>Selected</h4>
	</div>
</div>

<div class="row">
	<div class="span12">
		<div class="alert alert-success">
			<c:choose>
				<c:when test="${not empty selectedAddress}">
					${selectedAddress.id} :  [${selectedAddress.zip }] ${selectedAddress.city }, ${selectedAddress.street }
				</c:when>
				<c:otherwise>
					No selected address.
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<hr/><br/>

<c:forEach items="${addressList}" var="address">
	<c:url var="editUrl" value="/address/edit" >
		<c:param name="id" value="${address.id}" />
	</c:url>
	
	<c:url var="deleteUrl" value="/address/delete" >
		<c:param name="id" value="${address.id}" />
	</c:url>
	
	<c:url var="selectUrl" value="/address/select" >
		<c:param name="id" value="${address.id}" />
	</c:url>

	<div class="row">
		<div class="span5">
			${address.id} :  [${address.zip}] ${address.city}, ${address.street} 
		</div>
		<div class="span1" id="selectButton">
			<a href="${selectUrl}" class= "btn  btn-success btn-mini">
				<i class="icon-ok icon-white"></i>
			</a>
		</div>
		<div class="span1" id="modifyButton">
			<a href="${editUrl}" class= "btn btn-info btn-mini">
				<i class="icon-cog icon-white"></i>
			</a>
		</div>
		<div class="span1" id="deleteButton">
			<a href="${deleteUrl}" class= "btn btn-danger btn-mini">
				<i class="icon-trash icon-white"></i>
			</a>	
		</div>
	</div>
	<hr/>
</c:forEach>

<c:url var="formUrl" value="/address/add" />

<div class="row">
	<div class="span3">
		<h5>street</h5>
	</div>
	<div class="span3">
	<h5>city</h5>
	</div>
	<div class="span3">
		<h5>zip</h5>
	</div>
</div>

<div class="row"> 
	<div class="span3">
		<form:form action="${formUrl }" method="post" cssClass="form-horizontal" modelAttribute="address">
			<input type="hidden" name="id" value="${address.id }" />
				<form:input path="street"  />
	</div>
	<div class="span3">
				<form:input path="zip" />
	</div>
	<div class="span3">
				<form:input path="city" />
	</div>
	<div class="span1">
			<button type="submit" class="btn btn-primary" name="command" value="add"  >
				<i class="icon-ok icon-white"></i>
			</button>
		</form:form>
	</div>
</div>