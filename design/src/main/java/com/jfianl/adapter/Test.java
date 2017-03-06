package com.jfianl.adapter;

/**
 * @author: wuchao
 * @date： 2017/2/27
 */
public class Test {
    public static void main(String[] args) {
//        Targetable targetable = new Adapter();
//        targetable.method1();
//        targetable.method2();


//        Source source = new Source();
//        Targetable targetable1 = new Wrapper(source);
//        targetable1.method1();
//        targetable1.method2();

          Sourceable sourceable1 = new SoureceSub1();
          Sourceable sourceable2 = new SourceSub2();

        sourceable1.method1();
        sourceable2.method2();
    }
}
