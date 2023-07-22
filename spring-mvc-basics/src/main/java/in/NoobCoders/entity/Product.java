package in.NoobCoders.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	//-----------------------------------------------------------------------
	@Column(name = "supplier_id" , insertable = false, updatable = false)
	private Integer supplierId;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@Column(name = "category_id" , insertable = false , updatable = false)
	private Integer categoryId;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
	@JoinColumn(name = "category_id")
	private Category category;
	//--------------------------------------------------------------------------
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "units_in_stock")
	private Integer unitInStock;
	@Column(name = "units_on_order")
	private Integer unitsOnOrder;
	@Column(name = "reorder_level")
	private Integer reorderLevel;
	private Integer discontinued;

}