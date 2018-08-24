package xyz.oilpea.wechat.app.api.exception;

import xyz.oilpea.wechat.app.api.enums.ResultEnum;

/**
 * @program: sell
 * @description: 自定义异常
 * @author: 01
 * @create: 2018-05-09 15:45
 **/
public class SellException extends RuntimeException {

	private Integer code;

	public SellException(Integer code, String msg) {
		super(msg);
		this.code = code;
	}

	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
}