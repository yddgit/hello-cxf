package com.my.project.fromjava;


import javax.jws.WebService;

@WebService(endpointInterface = "com.my.project.fromjava.IMyService")
public class MyService implements IMyService {

	@Override
	public String sayHello(String name) {
		return String.format("Hello %s", name);
	}

}
