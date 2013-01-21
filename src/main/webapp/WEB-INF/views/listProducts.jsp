	
<div class="row">
	<div class="span12">
		<h2>products</h2>
	</div>
</div>

<hr/><br/>

<c:forEach items="${products}" var="product">

	<div class="row">
	
		<div class="span3">
			${product.id} :  ${product.name} [${product.price }] 
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
	<div class="row"><div class="span12"><br/></div></div>

</c:forEach>
