package leetcode.balance;

import com.google.errorprone.annotations.Var;
import com.sun.javafx.tools.packager.CommonParams;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 平滑加权轮询算法
 * @author: Ding Yawu
 * @create: 2022/2/19 15:17
 */
public class WeightRoundRobin {
    private static final Map<String, Weight> weightMap = new HashMap<>();

    private static final int totalWeight;

    static {
        ServerIps.WEIGHT_MAP.forEach((key, value) -> {
            weightMap.put(key, new Weight(key, value, 0));
        });
        totalWeight = ServerIps.WEIGHT_MAP.values().stream().reduce(0, Integer::sum);

    }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(getServer());
    }
  }

    private static String getServer() {
        //所有的ip的currentWeight统一加上原始权重
        weightMap.values().forEach(weight -> {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        });
        //找出currentWeight的最大值
        Weight maxCurrentWeight = weightMap.values().stream().max(Comparator.comparing(Weight::getCurrentWeight)).get();
        //将maxCurrentWeight减去总权重和
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalWeight);
        return maxCurrentWeight.getIp();
    }
}
