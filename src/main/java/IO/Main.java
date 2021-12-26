package IO;

import java.io.*;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/22 19:24
 */
public class Main {

    /**
     * <h1>序列化和反序列化 People 对象</h1>
     */
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

    public static void main(String[] args) throws Exception {
        testSerializablePeople();
    }
}
