package pers.wdcy.resut.reactor.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(value = "storage_tbl", schema = "testdb")
public class Storage implements Persistable<Integer>,  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 11980201852332530L;

	@Id
	private Integer id;
	
	private String commodityCode;
	
	private Integer count;
	
	@Transient
	@JsonIgnore
	private boolean fresh;

	@Override
	public boolean isNew() {
		return fresh;
	}
	
	public Storage fresh(){
        this.fresh = true;
        return this;
    }
	
}
