package container;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * description：登记类型枚举
 * author：dingyawu
 * date：created in 14:29 2020/9/23
 * history:
 */
@Getter
@AllArgsConstructor
@ToString
public enum InsertTypeEnum {
    IN(1,  "进港"),
    OUT(0, "出港");

    private Integer code;
    private String msg;

    public static String valueOfKey(Integer code){
        if (null == code){
            return null;
        }
        for (InsertTypeEnum insertTypeEnum : InsertTypeEnum.values()) {
            if (code.equals(insertTypeEnum.getCode())){
                return insertTypeEnum.getMsg();
            }
        }
        return null;
    }

}

