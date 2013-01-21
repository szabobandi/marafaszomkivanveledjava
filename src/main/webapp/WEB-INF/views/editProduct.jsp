	
<div class="row">
	<div class="span12">
		<h2>edit product</h2>
	</div>
</div>

<hr/><br/>

<c:url var="formUrl" value="/product/save" />


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
			<input type="hidden" name="id"  value="${product.id}"/>
			<input type="text" name="name" value="${product.name}" />
	</div>
	<div class="span 3">
			<input type="text" name="price" value="${product.price}" />
	</div>
	<div class="span 1">
			<button type="submit" class="btn btn-primary" name="command" value="save" >Save</button>
		</form:form>
	</div>

</div>

