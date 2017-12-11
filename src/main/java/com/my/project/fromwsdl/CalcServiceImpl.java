package com.my.project.fromwsdl;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService(
	endpointInterface = "com.my.project.fromwsdl.CalcService",
	wsdlLocation = "META-INF/wsdl/calc.wsdl",
	serviceName = "calcService",
	portName = "calcServicePort",
	targetNamespace = "http://www.example.org/calc")
@Service("calcService")
@org.apache.cxf.interceptor.InInterceptors(interceptors = {"com.my.project.fromwsdl.AuthorizeInInterceptor"})
public class CalcServiceImpl implements CalcService {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

}
