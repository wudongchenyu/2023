package pers.wdcy.resut.reactor.result;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分页查询传参")
public class PageParameter<T> {

	/**
	 * 每页个数，默认10
	 */
	@Parameter(description = "每页个数")
	private Integer size = 10;
	
	/**
	 * 当前页，默认为1
	 */
	@Parameter(description = "当前页")
	private Integer current = 1;
	
	@Parameter(description = "查询参数")
	private T paramer;
	
	public Integer offset() {
		if (null == current || current <= 0 || current >= Integer.MAX_VALUE || (current -1) >= Integer.MAX_VALUE / 10) {
			current = 1;
		}
		return (current -1) * size;
	}
}
