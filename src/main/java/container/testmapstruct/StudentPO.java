package container.testmapstruct;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 09:23
 */

@Data
@Builder
public class StudentPO {

    private Integer id;
    private String name;
    private Integer age;
    private String className;
}
