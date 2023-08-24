package pers.wdcy.resut.reactor.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(value = "order_tbl", schema = "testdb")
public class Order implements Persistable<Integer>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261292099625950172L;

	@Id
	private Integer id;
	
	private String userId;
	
	private String commodityCode;
	
	private Integer count;
	
	private Integer money;

	@Transient
	@JsonIgnore
	private boolean fresh;

	@Override
	public boolean isNew() {
		return fresh;
	}
	
	public Order fresh(){
        this.fresh = true;
        return this;
    }
	
}
