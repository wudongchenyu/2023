package pers.wdcy.result.reactor.result;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "加密传参")
public class Paramer<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3568436365977466539L;

	@Schema(description = "签名")
	private String sign;
	
	@Schema(description = "时间戳")
	private long timestamp;
	
	@Schema(description = "数据")
	private T data;
	
}
