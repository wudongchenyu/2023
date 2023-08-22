package pers.wdcy.resut.reactor.result;

public enum Results {
	//1XX：请求收到，继续处理
	RECAIVE(100000, "请求已收到，请继续"),
	//2XX：操作成功收到，分析、接受
	SUCCESS(200000, "成功"),
	//3XX：完成此请求必须进一步处理
	CONTINUE_REQUEST(300000, "必须进一步处理"),
	//4XX：请求包含一个错误语法或不能完成
	ERROE_REQUEST(400000, "请求错误"),
	//5XX：服务器执行一个完全有效请求失败
	ERROR_SYSTEM(500000, "系统内部错误"),
	;
	
	private int code;
	
	private String message;
	
	private Results(int code, String message) {
		this.message = message;
		this.code = code;
	}
	
	public int code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}
	
	public int code(int code) {
		this.code = code;
		return this.code;
	}
	
	public String message(String message) {
		this.message = message;
		return this.message;
	}
}
