package designmode.chain1.handler;


import designmode.chain1.request.DimissionRequest;
import designmode.chain1.request.Request;

//人事部门处理
public class HRRequestHandler implements RequestHandler {
	@Override
	public void handleRequest(Request request) {
		if (request instanceof DimissionRequest) {
			System.out.println("要离职, 人事审批!");
		}
		System.out.println("请求完成");
	}
}