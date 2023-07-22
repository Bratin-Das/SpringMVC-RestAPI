<%@ include file="header.jspf"%>

<h2>Product Details for id :: ${param.id}</h2>

<a href="./edit-product?id=${pr.productId}" class="btn btn-primary">Edit</a>
<div class = "row">

	<div class="col">
		<table class="table">
			<tbody>
				<tr>
					<td>Name</td>
					<td>${pr.productName}</td>
				</tr>
				<tr>
					<td>Category</td>
					<td>${pr.category.categoryName}</td>
				</tr>
				<tr>
					<td>Supplier</td>
					<td>${pr.supplier.companyName}</td>
				</tr>
				<tr>
					<td>Unit Price</td>
					<td>USD ${pr.unitPrice}</td>
				</tr>
				<tr> 
					<td>Quantity per unit</td>
					<td>${pr.quantityPerUnit}</td>
				</tr>
				<tr>
					<td>Units on Order</td>
					<td>${pr.unitsOnOrder}</td>
				</tr>
				<tr>
					<td>Reorder Level</td>
					<td>${pr.reorderLevel}</td>
				</tr>
				<tr>
					<td>Discontinued ?</td>
					<td>${pr.discontinued==1 ? "Yes":"No"}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="col"></div>

</div>

<%@ include file="footer.jspf"%>