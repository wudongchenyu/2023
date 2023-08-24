package pers.wdcy.resut.reactor.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(value = "account_tbl", schema = "testdb")
public class Account implements Persistable<Integer>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060043988709594346L;

	@Id
	private Integer id;
	
	private String userId;
	
	private Integer money;

	@Transient
	@JsonIgnore
	private boolean fresh;

	@Override
	public boolean isNew() {
		return fresh;
	}
	
	public Account fresh(){
        this.fresh = true;
        return this;
    }
	public Account() {
	}

	public Account(int i, String string, int j) {
		this.id = i;
		this.userId = string;
		this.money = j;
		this.fresh = true;
	}
	
}
