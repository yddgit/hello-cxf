package com.my.project.fromjava;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.my.project.fromjava.wsdl2java.IMyService;
import com.my.project.fromjava.wsdl2java.MyServiceService;

public class TestClient {

	private static final String SERVICE_ADDRESS = "http://localhost:9000/myService";

	/**
	 * JAX-WS的调用方式
	 */
	@Test
	public void jaxwsClient() {
		try {
			URL url = new URL(SERVICE_ADDRESS + "?wsdl");
			IMyService myService = new MyServiceService(url).getMyServicePort();
			System.out.println(myService.sayHello("Jerry"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CXF的调用方式(使用SOAPHandler来处理Header信息)
	 */
	@Test
	public void cxfClient() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IMyService.class);
		factory.setAddress(SERVICE_ADDRESS);
		// 客户端添加Interceptor
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		// 客户端添加Handler处理Header
		factory.setHandlers(Arrays.asList(new ClientHandler()));
		IMyService myService = (IMyService) factory.create();
		System.out.println(myService.sayHello("Green"));
	}

	/**
	 * CXF的调用方式(使用Interceptor来处理Header信息)
	 */
	@Test
	public void cxfInterceptor() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IMyService.class);
		factory.setAddress(SERVICE_ADDRESS);
		// 客户端添加Interceptor
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.getOutInterceptors().add(new ClientInterceptor());
		factory.getOutInterceptors().add(new ClientUserInterceptor());
		IMyService myService = (IMyService) factory.create();
		System.out.println(myService.sayHello("Red"));
	}

}
