	
<div class="row">
	<div class="span12">
		<h2>products</h2>
	</div>
</div>

<hr/><br/>

	<div class="row">
		<div class="span1"> <h5>id</h5> </div>
		<div class="span2"> <h5>name</h5> </div>
		<div class="span1"> <h5>price</h5> </div>
	</div>

<c:forEach items="${products}" var="product">
	
	<div class="row">
	
		<div class="span1">
			${product.id}
		</div>
		<div class="span2">		
			${product.name}
		</div>
		<div class="span1">
			${product.price}
		</div> 
		<div class="span1">
			<c:url var="editUrl" value="/product/edit" >
				<c:param name="id" value="${product.id}" />
			</c:url>
	
			<a href="${editUrl}" class= "btn btn-info btn-mini">
				<i class="icon-pencil icon-white"></i>
			</a>
		</div>
	
		<div class="span1">
			<c:url var="deleteUrl" value="/product/delete" >
				<c:param name="id" value="${product.id}" />
			</c:url>
	
			<a href="${deleteUrl}" class= "btn btn-danger btn-mini">
					<i class="icon-trash icon-white"></i>
				</a>
		</div>	
	</div>

</c:forEach>
