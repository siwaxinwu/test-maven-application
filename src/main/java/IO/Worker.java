package IO;

import java.io.Serializable;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/22 19:25
 */
public class Worker extends People implements Serializable {

    private String name;
    private Integer age;

    public Worker(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

}