<%@ include file="./header.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="row" >

	<div class="col">
		<sf:form modelAttribute="pr" action ="save-product">
		<sf:hidden path="productId"/>
			<div class="form-group row">
				<label class="col-md-4" for="productName">Product name</label>
				<div class="col-md-8">
					<sf:input path="productName" cssClass="form-control" />
					<sf:errors path="productName" cssClass="text-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="categoryId">Category</label>
				<div class="col-md-8">
					<sf:select path="category.categoryId" cssClass="form-select">
						<sf:option value="-1" label="-- Select --"></sf:option>
						<sf:options items="${categories}" itemLabel="categoryName" itemValue="categoryId" />
					</sf:select>
					<sf:errors path="category.categoryId" cssClass="text-danger"></sf:errors>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-md-4" for="supplierId">Supplier</label>
				<div class="col-md-8">
					<sf:select path="supplier.supplierId" cssClass="form-select">
						<sf:option value="-1" label="-- Select --"></sf:option>
						<sf:options items="${suppliers}" itemLabel="companyName"
							itemValue="supplierId" />
					</sf:select>
					<sf:errors path="supplier.supplierId" cssClass="text-danger"></sf:errors>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-md-4" for="unitPrice">Unit price</label>
				<div class="col-md-8">
					<sf:input path="unitPrice" cssClass="form-control" />
					<sf:errors path="unitPrice" cssClass="text-danger"></sf:errors>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="quantityPerUnit">Quantity per
					unit</label>
				<div class="col-md-8">
					<sf:input path="quantityPerUnit" cssClass="form-control" />
					<sf:errors path="quantityPerUnit" cssClass="text-danger"></sf:errors>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="unitInStock">Units in stock</label>
				<div class="col-md-8">
					<sf:input path="unitInStock" cssClass="form-control" />
					<sf:errors path="unitInStock" cssClass="text-danger"></sf:errors>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="unitsOnOrder">Units on order</label>
				<div class="col-md-8">
					<sf:input path="unitsOnOrder" cssClass="form-control" />
					<sf:errors path="unitsOnOrder" cssClass="text-danger"></sf:errors>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="reorderLevel">Reorder Level</label>
				<div class="col-md-8">
					<sf:input path="reorderLevel" cssClass="form-control" />
					<sf:errors path="reorderLevel" cssClass="text-danger" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-4" for="discontinued">Discontinued</label>
				<div class="col-md-8">
					<label> <sf:radiobutton path="discontinued" value="1" />
						Yes
					</label> <label> <sf:radiobutton path="discontinued"
							value="0" /> No
					</label>
					<div>
						<sf:errors path="discontinued" cssClass="text-danger"></sf:errors>
					</div>
				</div>
			</div>



			<div class="form-group row">
				<label class="col-md-4"></label>
				<div class="col-md-8">
					<button class="btn btn-primary">Submit changes</button>
				</div>
			</div>

		</sf:form>
	</div>
	
	<div class="col"></div>

</div>


<%@ include file="./footer.jspf" %>