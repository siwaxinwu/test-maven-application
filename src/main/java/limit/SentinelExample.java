package limit;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sun.deploy.security.BlockedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/15 14:57
 */
public class SentinelExample {
  private static final String RESOURCE = "SentinelExample";

  public SentinelExample(){
      flowRule();
  }
  public static void main(String[] args) {
    while (true){
        //获取一个令牌（自动释放资源，令牌）
        try(Entry entry = SphU.entry(RESOURCE)){
        System.out.println("request success");
        //Thread.sleep(300);
        }catch (BlockException  e){
        System.out.println("request blocked");
        }
      System.out.println("request success");
    }
  }

  private static void flowRule(){
      List<FlowRule> list = new ArrayList<>();
      FlowRule flowRule = new FlowRule();
      //针对那个资源设置规则，限流的维度，设置QPS = 5
      flowRule.setResource(RESOURCE);
      flowRule.setCount(5);
      flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
      list.add(flowRule);
      FlowRuleManager.loadRules(list);
  }
}
