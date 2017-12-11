package com.my.project.fromjava;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class ServerInterceptor extends AbstractSoapInterceptor {

	public ServerInterceptor() {
		super(Phase.UNMARSHAL);
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		QName name = new QName("http://project.my.com/", "authorize");
		Header header = message.getHeader(name);
		if(header != null) {
			Element e = (Element) header.getObject();
			String authorize = (String) e.getTextContent();
			System.out.println(String.format("[Server]SOAPHeader %s: %s", "authorize", authorize));
		}
	}

}
