
package com.my.project.spring.wsdl2java;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.1.14
 * 2017-12-11T18:49:16.774+08:00
 * Generated source version: 3.1.14
 * 
 */
 
public class CalcService_CalcServicePort_Server{

    protected CalcService_CalcServicePort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new CalcServicePortImpl();
        String address = "http://localhost:8080/hello-cxf/services/calcService";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new CalcService_CalcServicePort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
