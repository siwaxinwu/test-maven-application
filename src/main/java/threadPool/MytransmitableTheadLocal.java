package threadPool;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 23:10 2021-01-29
 * @history:
 */
public class MytransmitableTheadLocal<T> extends TransmittableThreadLocal<T> {
  @Override
  public T copy(T parentValue) {
    String string = JSONObject.toJSONString(parentValue);
    return (T) JSONObject.parseObject(string, parentValue.getClass());
  }
}
