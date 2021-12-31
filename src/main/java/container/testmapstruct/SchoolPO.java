package container.testmapstruct;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 09:50
 */

@Data
@Builder
public class SchoolPO {

    private String name;
    private String location;
}
