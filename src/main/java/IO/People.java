package IO;

import java.io.Serializable;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/22 19:23
 */
public class People  {

    private Long id;

    public People(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                '}';
    }
}
