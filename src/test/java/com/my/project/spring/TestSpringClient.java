package com.my.project.spring;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.my.project.fromwsdl.AuthorizeOutInterceptor;
import com.my.project.spring.wsdl2java.CalcService;
import com.my.project.spring.wsdl2java.CalcService_Service;

public class TestSpringClient {

	private static final String SERVICE_ADDRESS = "http://localhost:8080/hello-cxf/services/calcService";

	@Test
	public void fromwsdl() {
		try {
			URL url = new URL(SERVICE_ADDRESS + "?wsdl");
			CalcService calcService = new CalcService_Service(url).getCalcServicePort();
			System.out.println(calcService.add(12, 33));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void interceptor() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(CalcService.class);
		factory.setAddress(SERVICE_ADDRESS);
		factory.getOutInterceptors().add(new AuthorizeOutInterceptor());
		CalcService calcService = (CalcService) factory.create();
		System.out.println(calcService.add(11, 34));
	}

}
