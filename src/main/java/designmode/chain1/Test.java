package designmode.chain1;

import designmode.chain1.handler.HRRequestHandler;
import designmode.chain1.handler.PMRequestHandler;
import designmode.chain1.handler.RequestHandler;
import designmode.chain1.handler.TLRequestHandler;
import designmode.chain1.request.AddMoneyRequest;
import designmode.chain1.request.DimissionRequest;
import designmode.chain1.request.Request;

public class Test {
	public static void main(String[] args) {
		RequestHandler hr = new HRRequestHandler();
		RequestHandler pm = new PMRequestHandler(hr);
		RequestHandler tl = new TLRequestHandler(pm);

		// team leader处理离职请求
		Request request = new DimissionRequest();
		tl.handleRequest(request);

		System.out.println("===========");

		//team leader处理加薪请求
		request = new AddMoneyRequest();
		tl.handleRequest(request);

		System.out.println("========");

		// 项目经理上理辞职请求
		request = new DimissionRequest();
		pm.handleRequest(request);
	}
}