package IO;

import sun.reflect.generics.tree.VoidDescriptor;
import sun.swing.BeanInfoUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 对象池的实现
 * 对象池里面的对象可以再回收的时候被重置
 * 对象池里的对象被用完，任然可以让业务继续进行
 * 对象池单线程使用，不需要考虑多线程的同步锁操作
 * @author: Ding Yawu
 * @create: 2022/2/15 13:03
 */
public class ObjectPool<T> {

    private final LinkedList<T> list;
    private Class<T> clazz;
    //定义对象池存储可以供使用的对象
    public ObjectPool(Class<T> clazz, int size) throws Exception {
        //初始化对象池，填入对象
        list = new LinkedList<T>();
        this.clazz = clazz;
        for (int i = 0; i < size; i++) {
          list.add(clazz.newInstance());
        }
    }
    public T get() throws Exception {
        //从对象池里取出一个对象，不允许返回空
        if (list.size() > 0){
            return list.remove();
        }
        return clazz.newInstance();
    }

    public void recycle(T object){
        //当对象可以回收的时候，调用该方法把对象放入对象池

    }
}
