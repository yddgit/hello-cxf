package com.my.project.fromwsdl;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class CalcServer {

	public static void main(String[] args) {
		// JAX-WS方式发布服务
		//jaxws();
		// CXF方式发布服务
		cxf();
	}

	/**
	 * JAX-WS方式发布服务
	 */
	static void jaxws() {
		Endpoint.publish("http://localhost:9000/calcService", new CalcServiceImpl());
	}

	/**
	 * CXF方式发布服务
	 */
	static void cxf() {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:9000/calcService");
		factory.setServiceClass(CalcService.class);
		factory.setServiceBean(new CalcServiceImpl());
		// 设置WSDL文件位置
		factory.setWsdlLocation("META-INF/wsdl/calc.wsdl");
		factory.setServiceName(new QName("http://www.example.org/calc", "calcService"));
		factory.create();
	}
}
