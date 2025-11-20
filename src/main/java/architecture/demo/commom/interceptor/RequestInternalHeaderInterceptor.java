package architecture.demo.commom.interceptor;

import architecture.demo.commom.constants.Constants;
import architecture.demo.entity.auth.ArchitectureAuth;
import architecture.demo.entity.auth.RequestBaseInfo;
import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class RequestInternalHeaderInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
		this.setRequestInfo(request);
		this.setRequestInfo(request);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
		MDC.clear();
	}

	private void setRequestInfo(HttpServletRequest request) {
		// set request trace id
		String traceId = request.getHeader(Constants.REQUEST_TRACE_ID);
		if (StringUtils.isBlank(traceId)) {
			traceId = UUID.randomUUID().toString();
		}
		MDC.put(Constants.TRACE_ID, traceId);
        RequestBaseInfo requestBaseInfo = new RequestBaseInfo();
		requestBaseInfo.setTraceId(traceId);
        //set RequestBaseInfo
        ArchitectureAuth.setArchitectureRequestInfo(requestBaseInfo);
	}


}