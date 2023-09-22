package pers.wdcy.result.reactor.result;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "分页查询结果")
public class PageResult<T> extends Result<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6855789499776652186L;

	@Parameter(description = "当前页数")
	private int current;
	
	@Parameter(description = "每页个数")
	private int size;
	
	@Parameter(description = "总数")
	private long total;
	
	public PageResult() {
	}
	
	public PageResult(Result<T> result, int current, int size, long total) {
		data(result.getData());
		code(result.getCode());
		message(result.getMessage());
		success(result.isSuccess());
		this.current = current;
		this.size = size;
		this.total = total;
	}
	
}
