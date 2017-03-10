package org.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class CacheInterceptor implements Interceptor{
	


	public void intercept(Invocation inv) {
		System.out.println("Before method invoking");
		inv.invoke();
		System.out.println("After method invoking");
		
	}

	

}
