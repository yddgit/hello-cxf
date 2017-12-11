package com.my.project.spring.wsdl2java;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.14
 * 2017-12-11T18:49:16.774+08:00
 * Generated source version: 3.1.14
 * 
 */
@WebServiceClient(name = "calcService", 
                  wsdlLocation = "http://localhost:8080/hello-cxf/services/calcService?wsdl",
                  targetNamespace = "http://www.example.org/calc") 
public class CalcService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/calc", "calcService");
    public final static QName CalcServicePort = new QName("http://www.example.org/calc", "calcServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/hello-cxf/services/calcService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CalcService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/hello-cxf/services/calcService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CalcService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalcService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalcService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CalcService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CalcService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CalcService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CalcService
     */
    @WebEndpoint(name = "calcServicePort")
    public CalcService getCalcServicePort() {
        return super.getPort(CalcServicePort, CalcService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalcService
     */
    @WebEndpoint(name = "calcServicePort")
    public CalcService getCalcServicePort(WebServiceFeature... features) {
        return super.getPort(CalcServicePort, CalcService.class, features);
    }

}