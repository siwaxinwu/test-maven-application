package leetcode.balance;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/2/19 15:15
 */
public class Weight {
    //服务器IP
    private String ip;
    //静态权重
    private Integer weight;
    //动态权重
    private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
