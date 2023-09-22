package pers.wdcy.result.reactor.result;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "查询结果")
public class Result<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6209998427223041092L;

	@Parameter(description = "响应代码")
	private int code;
	
	@Parameter(description = "响应说明")
	private String message;
	
	@Parameter(description = "接口访问是否成功")
	private boolean success;
	
	@Parameter(description = "响应时间")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private LocalDateTime timestamp = LocalDateTime.now();
	
	@Parameter(description = "响应结果")
	private T data;
	
	Result() {
		this(Results.SUCCESS.code(), Results.SUCCESS.message(), true, null);
	}

	public Result(int code, String message, boolean success, T data) {
		this.code = code;
		this.message = message;
		this.success = success;
		this.data = data;
	}
	
	/**
	 * 成功
	 * @param data
	 */
	public Result(T data) {
		this.data = data;
	}
	
	public static <T> Result<T> success() {
		return success(null);
	}
	
	public static <T> Result<T> success(T data) {
		return success(Results.SUCCESS.message(), data);
	}

	public static <T> Result<T> success(Results results) {
		return success(results.code(), results.message(), null);
	}
	
	public static <T> Result<T> success(Results results, T data) {
		return success(results.code(), results.message(), data);
	}
	
	public static <T> Result<T> success(String message, T data) {
		return success(Results.SUCCESS.code(), message, data);
	}
	
	public static <T> Result<T> success(int code, String message, T data) {
		return success(code, message, true, data);
	}
	
	public static <T> Result<T> success(int code, String message, boolean success, T data) {
		return new Result<T>(code, message, true, data);
	}
	
	public static <T> Result<T> success(int code, T data) {
		return success(code, Results.SUCCESS.message(), data);
	}
	
	/**
	 * 出错
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> error() {
		return error(Results.ERROR_SYSTEM.code(), null, null);
	}
	
	public static <T> Result<T> error(String message) {
		return error(message, null);
	}
	
	public static <T> Result<T> error(T data) {
		return error(Results.ERROR_SYSTEM.message(), data);
	}

	public static <T> Result<T> error(Results results) {
		return error(results.code(), results.message(), null);
	}
	
	public static <T> Result<T> error(Results results, T data) {
		return error(results.code(), results.message(), data);
	}
	
	public static <T> Result<T> error(int code, T data) {
		return error(code, Results.ERROR_SYSTEM.message(), data);
	}
	
	public static <T> Result<T> error(String message, T data) {
		return error(Results.ERROR_SYSTEM.code(), message, data);
	}
	
	public static <T> Result<T> error(int code, String message, T data) {
		return error(code, message, true, data);
	}
	
	public static <T> Result<T> error(int code, String message, boolean success, T data) {
		return new Result<T>(code, message, true, data);
	}
	
	/**
	 * 符合业务逻辑，没有数据
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> losing() {
		return losing(null);
	}

	public static <T> Result<T> losing(T data) {
		return losing(Results.SUCCESS.message(), data);
	}
	
	public static <T> Result<T> losing(Results results) {
		return losing(results.code(), results.message(), null);
	}
	
	public static <T> Result<T> losing(Results results, T data) {
		return losing(results.code(), results.message(), data);
	}
	
	public static <T> Result<T> losing(int code, T data) {
		return losing(code, Results.SUCCESS.message(), data);
	}
	
	public static <T> Result<T> losing(String message, T data) {
		return losing(Results.SUCCESS.code(), message, data);
	}
	
	public static <T> Result<T> losing(int code, String message, T data) {
		return losing(code, message, true, data);
	}
	
	public static <T> Result<T> losing(int code, String message, boolean success, T data) {
		return new Result<T>(code, message, true, data);
	}
	
	/**
	 * 不符合业务逻辑
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> failure() {
		return failure(null);
	}

	public static <T> Result<T> failure(T data) {
		return failure(Results.SUCCESS.message(), data);
	}

	public static <T> Result<T> failure(Results results) {
		return failure(results.code(), results.message(), null);
	}
	
	public static <T> Result<T> failure(Results results, T data) {
		return failure(results.code(), results.message(), data);
	}
	
	public static <T> Result<T> failure(int code, T data) {
		return failure(code, Results.SUCCESS.message(), data);
	}
	
	public static <T> Result<T> failure(String message, T data) {
		return failure(Results.SUCCESS.code(), message, data);
	}
	
	public static <T> Result<T> failure(int code, String message, T data) {
		return failure(code, message, true, data);
	}
	
	public static <T> Result<T> failure(int code, String message, boolean success, T data) {
		return new Result<T>(code, message, true, data);
	}
	
	public Result<T> code(int code) {
		this.code = code;
		return this;
	}
	
	public Result<T> message(String message) {
		this.message = message;
		return this;
	}
	
	public Result<T> success(boolean success) {
		this.success = success;
		return this;
	}
	
	public Result<T> timestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	public Result<T> data(T data) {
		this.data = data;
		return this;
	}
	
	
}
