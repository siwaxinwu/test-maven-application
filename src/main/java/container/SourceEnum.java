package container;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * description：
 * 1-手动创建（至管区），2-手动创建（至网格），3-系统下达管区,4-系统下达网格,5-系统下达网点,6-手动下达管区,7-手动下达网格,8-手动下达网点
 * 任务来源：1-手动创建，2-系统下达，3-手动下达
 * 目标对象： W 网点 G管区  WG网格
 * Arrays.stream(values()).forEach(System.out::println)的输出结果
 * HAND_ESTAB_AREA
 * HAND_ESTAB_GRID
 * SYS_SEND_AREA
 * SYS_SEND_GRID
 * SYS_SEND_SITE
 * HAND_SEND_AREA
 * HAND_SEND_GRID
 * HAND_SEND_SITE
 * author：dingyawu
 * date：created in 16:31 2020/11/23
 * history:
 */
public enum SourceEnum {
    HAND_ESTAB_AREA(1, 1,"G"),
    HAND_ESTAB_GRID(2, 1,"WG"),
    SYS_SEND_AREA(3, 2,"G"),
    SYS_SEND_GRID(4, 2,"WG"),
    SYS_SEND_SITE(5, 2,"W"),
    HAND_SEND_AREA(6, 3,"G"),
    HAND_SEND_GRID(7, 3,"WG"),
    HAND_SEND_SITE(8, 3,"W");

    private Integer code;
    private Integer taskSource;
    private String targetType;

    SourceEnum(Integer code, Integer taskSource,String targetType) {
        this.code = code;
        this.taskSource = taskSource;
        this.targetType = targetType;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getTaskSource() {
        return taskSource;
    }

    public String getTargetType() {
        return targetType;
    }

    public static Integer valueOfKey(Integer taskSource, String targetType){
        if (null == taskSource || StringUtils.isEmpty(targetType)){
            return null;
        }
        Arrays.stream(values()).forEach(System.out::println);
        for (SourceEnum sourceEnum : values()) {
            if (taskSource.equals(sourceEnum.getTaskSource()) && targetType.equals(sourceEnum.getTargetType())){
                return sourceEnum.getCode();
            }
        }
        return null;
    }
}