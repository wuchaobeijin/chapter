package org.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class LalaInterceptor implements Interceptor{

	public void intercept(Invocation inv) {
		System.out.println("Before method invoking");
		
		inv.invoke(); //以上代码中的 DemoInterceptor 将拦截目标方法，并且在目标方法调用前后向控制台输出
	//	文本。 inv.invoke()这一行代码是对目标方法的调用，在这一行代码的前后插入切面代码可以很
		//方便地实现 AOP。
		System.out.println("After method invoking");
		
	}
 
}
