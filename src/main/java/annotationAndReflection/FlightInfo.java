package annotationAndReflection;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 注解 + 反射来实现简化冗余代码
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-14 21:03
 */
@FlightQuery(url = "/flight/query", desc = "查询航班")
@Data
public class FlightInfo {
    @FlightQueryField(name = "org", order = 1)
    private String org;         //出发机场
    @FlightQueryField(name = "dst", order = 2)
    private String dst;         // 到达机场
    @FlightQueryField(name = "flightDate", order = 3)
    private String flightDate;  // 航班日期
    @FlightQueryField(name = "flightNo", order = 4)
    private String flightNo;    // 航班号
    @FlightQueryField(name = "passengerNum", order = 5)
    private int passengerNum;   // 乘客数


    public static String createUrl(FlightInfo flightInfo) {
        FlightQuery flightQuery = flightInfo.getClass().getAnnotation(FlightQuery.class);
        StringBuilder stringBuilder = new StringBuilder(flightQuery.url());
        Arrays.stream(flightInfo.getClass().getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(FlightQueryField.class))
                .sorted(Comparator.comparing(x -> x.getAnnotation(FlightQueryField.class).order()))
                .peek(x -> x.setAccessible(true))
                .forEach(field -> {
                    FlightQueryField flightQueryField = field.getAnnotation(FlightQueryField.class);
                    Object value = "";
                    try {
                        value = field.get(flightInfo);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (flightQueryField.order() == 1) {
                        stringBuilder.append("?").append(flightQueryField.name() + "=" + value).append("&");
                    } else {
                        stringBuilder.append(flightQueryField.name() + "=" + value).append("&");
                    }
                });
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    public static void main(String[] args) {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setOrg("beijing");
        flightInfo.setDst("shanghai");
        flightInfo.setFlightDate("2021-10-01");
        flightInfo.setFlightNo("CA9988");
        flightInfo.setPassengerNum(1);
        System.out.println(createUrl(flightInfo));
    }
}
