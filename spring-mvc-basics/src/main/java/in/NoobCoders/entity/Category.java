package in.NoobCoders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//If class Name is different from Table name then-
@Table(name ="categories")
@ToString(exclude = {"picture"} )
@NoArgsConstructor
@Getter
@Setter
public class Category 
{
	//atleast one primary key should be annotated with @id
	@Id
	@Column(name ="category_id")
	private Integer categoryId;
	@Column(name ="category_name")
	private String categoryName;
	private String description;
	@JsonIgnore
	private byte[] picture;
}
