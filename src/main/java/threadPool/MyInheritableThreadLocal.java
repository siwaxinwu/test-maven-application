package threadPool;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 22:39 2021-01-29
 * @history:
 */
public class MyInheritableThreadLocal<T> extends InheritableThreadLocal<T> {
	@Override
	protected T childValue(T parentValue) {
		String string = JSONObject.toJSONString(parentValue);
		return  (T)JSONObject.parseObject(string, parentValue.getClass());
	}
}
