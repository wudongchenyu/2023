package pers.wdcy.resut.reactor.common;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import lombok.extern.slf4j.Slf4j;
import pers.wdcy.resut.reactor.exception.BusinessException;
import pers.wdcy.resut.reactor.exception.GlobalException;
import pers.wdcy.resut.reactor.result.Result;

@Slf4j
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes{
	
	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
		return this.assembleAttributes(request, options);
	}

	private Map<String, Object> assembleAttributes(ServerRequest request, ErrorAttributeOptions options) {

		Map<String, Object> attributes = super.getErrorAttributes(request, options);

		Throwable error = getError(request);
		log.error("错误:{}", attributes, error);
		if (error instanceof GlobalException) {
			GlobalException ge = (GlobalException) error;
			attributes.put("result", Result.error(ge.getStatusCode().value(), ge.getMessage(), null));
			return attributes;
		}

		if (error instanceof BusinessException) {
			BusinessException ge = (BusinessException) error;
			attributes.put("result", Result.error(ge.getResults()));
			return attributes;
		}
		attributes.put("result",
				Result.error(Integer.parseInt(attributes.get("status").toString()), error.getMessage(), null));
		return attributes;
	}

}
