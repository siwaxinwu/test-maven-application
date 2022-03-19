package container;

import jdk.internal.org.objectweb.asm.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @description: 内部类使用美元符号
 * @author: Ding Yawu
 * @create: 2022/3/14 23:27
 */
public class ASMTest implements Opcodes {
    @Test
    public void test() throws IOException {
        //获取读取器
        ClassReader classReader = new ClassReader("container.ASMTest$HelloWorld");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classReader.accept(classWriter, 0);
        byte[] bytes = classWriter.toByteArray();
        String fileName = "/Users/xmly/Desktop/mycoderepo/test-maven-application/hello.class";
        Files.write(new File(fileName).toPath(), bytes);
    }

    @Test
    public void test1() throws IOException {
        //获取读取器，
        ClassReader classReader = new ClassReader("container.ASMTest$HelloWorld");
        //指定ASM的版本 ASM5
        ClassVisitor visitor = new ClassVisitor(ASM5) {
            @Override
            public void visit(int version, int access, String name, String siganature, String superName, String[] strings) {
                System.out.println("类名：" + name);
            }

            @Override
            public MethodVisitor visitMethod(int access, String name, String s1, String s2, String[] strings) {
                System.out.println("方法名：" + name);
                return new MethodVisitor(ASM5) {
                    @Override
                    public void visitLocalVariable(String name, String s1, String s2, Label label, Label label1, int i) {
                        System.out.println("变量名字：" + name);
                    }
                };
            }


        };
        classReader.accept(visitor, 0);

    }

    public static class HelloWorld{
        public void helloWorld(String name){
            int age = 18;
            System.out.println("hello world" + name + "age: " + age);
        }
    }
}
