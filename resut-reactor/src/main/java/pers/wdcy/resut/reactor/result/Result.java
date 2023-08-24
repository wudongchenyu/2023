package pers.wdcy.resut.reactor.result;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Result<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6209998427223041092L;

	private int status;
	
	private int code;
	
	private String message;
	
	private boolean success;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private LocalDateTime timestamp = LocalDateTime.now();
	
	private T data;
	
	Result() {
//		this(Results.SUCCESS.code(), Results.SUCCESS.message(), true, null);
	}

	public Result(int status, int code, String message, boolean success, T data) {
		this.status = status;
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
		return new Result<T>(HttpStatus.OK.value() ,code, message, true, data);
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
		return new Result<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), code, message, true, data);
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
		return new Result<T>(HttpStatus.OK.value(), code, message, true, data);
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
		return new Result<T>(HttpStatus.OK.value(), code, message, true, data);
	}
	
	
}
