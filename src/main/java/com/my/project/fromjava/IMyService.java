package com.my.project.fromjava;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IMyService {
	@WebMethod
	@WebResult(name = "helloMsg")
	public String sayHello(@WebParam(name = "name")String name);
}
