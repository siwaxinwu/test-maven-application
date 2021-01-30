package designmode.chain1.handler;


import designmode.chain1.request.AddMoneyRequest;
import designmode.chain1.request.Request;

//项目经理处理
public class PMRequestHandler implements RequestHandler {
    RequestHandler rh;
    public PMRequestHandler(RequestHandler rh) {
        this.rh = rh; 
    } 
    @Override
    public void handleRequest(Request request) {
        if (request instanceof AddMoneyRequest) {
            System.out.println("要加薪, 项目经理审批!");
        } else { 
            rh.handleRequest(request); 
        } 
    } 
} 