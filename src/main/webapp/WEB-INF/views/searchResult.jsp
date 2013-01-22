<div class="row">
	<div class="span12">
		<h2>search result</h2>
	</div>
</div>

<hr/><br/>

<div class="row"> 
	<div class="span3">
		<h4> product name</h4>
	</div>
	<div class="span3">
		<h4> product price</h4>
	</div>
	
</div>

<c:forEach  items="${products}" var="product">
	<div class="row"> 
		<div class="span3">
			${product.name}
		</div>
		<div class="span3">
			${product.price}
		</div>
	</div>
	<hr/>
</c:forEach>

