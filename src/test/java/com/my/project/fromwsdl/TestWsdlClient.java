package com.my.project.fromwsdl;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class TestWsdlClient {

	private static final String SERVICE_ADDRESS = "http://localhost:9000/calcService";

	@Test
	public void fromwsdl() {
		try {
			URL url = new URL(SERVICE_ADDRESS + "?wsdl");
			com.my.project.fromwsdl.wsdl2java.CalcService calcService = new com.my.project.fromwsdl.wsdl2java.CalcService_Service(url).getCalcServicePort();
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
