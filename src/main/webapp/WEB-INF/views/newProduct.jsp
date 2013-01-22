<div class="row">
	<div class="span12">
		<h2>new product</h2>
	</div>
</div>

<hr/><br/>

<c:url var="formUrl" value="/product/add" />

<c:if test="${not empty errorMsg }">
	<div class="alert alert-error">
 		${errorMsg} 
	</div>
</c:if>

<div class="row"> 
	<div class="span3">
		<h4> product name </h4>
	</div>
	<div class="span3">
		<h4> product price </h4>
	</div>
</div>

<div class="row"> 
	<div class="span3">
		
		<form:form action="${formUrl }" method="post" cssClass="form-horizontal" modelAttribute="product">
			<form:input path="name"/>
	</div>	
	<div class="span 3">
			<form:input path="price" />
  	</div>
	
	<div class="span 1">
			<button type="submit" class="btn btn-primary" name="command" value="add" >add</button>
		</form:form>
	</div>
		
</div>