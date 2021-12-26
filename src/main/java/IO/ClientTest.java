package IO;

import java.io.*;

/**
 * @description: 序列化和反序列化对象
 * @author: Ding Yawu
 * @create: 2021/11/22 19:25
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        testSerizableWorker();
        //testSerializablePeople();
    }


    private static void testSerializablePeople() throws Exception {

        // 序列化的步骤

        // 用于存储序列化的文件，这里的java_下划线仅仅为了说明是java序列化对象，没有任何其他含义
        File file = new File("/tmp/people_10.java_");
        if (!file.exists()) {
            // 1，先得到文件的上级目录，并创建上级目录
            file.getParentFile().mkdirs();
            try {
                // 2，再创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        People p = new People(10L);

        // 创建一个输出流
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        // 输出可序列化对象
        oos.writeObject(p);
        // 关闭输出流
        oos.close();

        // 反序列化的步骤

        // 创建一个输入流
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );
        // 得到反序列化的对象，这里可以强转为People类型
        Object newPerson = ois.readObject();
        // 关闭输入流
        ois.close();

        System.out.println(newPerson);
    }

    /**
     * <h2>子类实现序列化, 父类不实现序列化</h2>
     * */
    private static void testSerizableWorker() throws Exception {

        File file = new File("/tmp/worker_10.java_");
        if (!file.exists()) {
            // 1，先得到文件的上级目录，并创建上级目录
            file.getParentFile().mkdirs();
            try {
                // 2，再创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Worker p = new Worker(10L, "lcy", 18);

        // 创建一个输出流
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        // 输出可序列化对象
        oos.writeObject(p);
        // 关闭输出流
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newWorker = ois.readObject(); // 父类没有序列化的时候，需要调用父类的无参数构造方法
        ois.close();
        System.out.println(newWorker);
    }
}
