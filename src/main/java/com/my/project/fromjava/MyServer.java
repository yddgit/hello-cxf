package com.my.project.fromjava;

import java.util.Arrays;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class MyServer {

	private static final String SERVICE_ADDRESS = "http://localhost:9000/myService";

	public static void main(String[] args) {
		// JAX-WS的发布方式
		//jaxws();
		// CXF提供的发布方式(使用SOAPHandler来处理Header信息)
		//cxf();
		// CXF的Interceptor的使用
		interceptor();
	}

	/**
	 * JAX-WS的发布方式
	 */
	static void jaxws() {
		Endpoint.publish(SERVICE_ADDRESS, new MyService());
	}

	/**
	 * CXF提供的发布方式(使用SOAPHandler来处理Header信息)
	 */
	static void cxf() {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(MyService.class);
		factory.setAddress(SERVICE_ADDRESS);
		factory.setServiceBean(new MyService());
		// 服务端添加Interceptor
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		// 服务端添加Handler处理Header
		factory.setHandlers(Arrays.asList(new ServerHandler()));
		factory.create();
	}

	/**
	 * CXF的Interceptor的使用
	 */
	static void interceptor() {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(MyService.class);
		factory.setAddress(SERVICE_ADDRESS);
		factory.setServiceBean(new MyService());
		// 服务端添加Interceptor
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getInInterceptors().add(new ServerInterceptor());
		factory.getInInterceptors().add(new ServerUserInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.create();
	}

}
