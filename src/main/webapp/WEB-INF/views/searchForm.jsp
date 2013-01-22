<div class="row">
	<div class="span12">
		<h2>search product</h2>
	</div>
</div>

<hr/><br/>

<c:url var="searchUrl" value="/product/search" />

<div class="row"> 
	<div class="span3">
		<h4> max price </h4>
	</div>
</div>

<div class="row"> 
	<div class="span3">
		<form action="${searchUrl }" method="post" cssClass="form-horizontal">
			<input type="text" name="maxPrice" required="required"/>
	</div>
	<div class="span 1">
			<button type="submit" class="btn btn-info">search</button>
		</form>
	</div>
</div>