package org.zhouhy.design.model.sigleton.md05;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 静态内部类虽然保证了单例在多线程并发下的线程安全性，但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。
 * 如果对象不实现这个Serializable接口是无法写进文件中的
 * */
public class MySingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    //内部类
    private static class MySingletonHandler{
        private static MySingleton instance = new MySingleton();
    }

    private MySingleton(){}

    public static MySingleton getInstance() {
        return MySingletonHandler.instance;
    }

    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MySingletonHandler.instance;
    }
}
