package com.java;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class CompileClassTest extends ClassLoader {

    private byte[] getBytes(String fileName) {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int r = fileInputStream.read(raw);
            if (r != len) throw new IOException("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return raw;
    }


    private boolean complie(String javaFile) throws Exception {
        System.out.println("正在编译");
        Process process = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            process.waitFor();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        int ret = process.exitValue();
        return ret == 0;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String fileStub = name.replace(".", "/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
            try {
                if (!complie(javaFileName) || classFile.exists()) {
                    throw new ClassNotFoundException("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (classFile.exists()) {
                byte[] raw = getBytes(classFileName);
                clazz = defineClass(name, raw, 0, raw.length);
            }
            if (clazz == null) {
                throw new ClassNotFoundException("");
            }
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        String progClass = args[0];
        String []proArgs = new String[args.length - 1];
        System.arraycopy(args,1,proArgs,0,proArgs.length);
        CompileClassTest compileClassTest = new CompileClassTest();
        Class clazz = compileClassTest.loadClass(progClass);
        Method main = clazz.getMethod("main",(new String[0]).getClass());
        Object argsArray[] = {proArgs};
        main.invoke(null,argsArray);
    }
}
