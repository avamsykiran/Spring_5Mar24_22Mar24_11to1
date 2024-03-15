package com.cts.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.iocdemo.views.IocDemoView;

public class IocDemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext container = new AnnotationConfigApplicationContext(IocDemoConfig.class);
		
		IocDemoView view = (IocDemoView) container.getBean("iocDemoView");
		view.run();
		
	}

}
