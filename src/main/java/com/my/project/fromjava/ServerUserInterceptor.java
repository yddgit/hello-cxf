package com.my.project.fromjava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

import com.my.project.model.User;

public class ServerUserInterceptor extends AbstractSoapInterceptor {

	public ServerUserInterceptor() {
		super(Phase.UNMARSHAL);
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		try {
			QName name = new QName("http://project.my.com/", "authorizedUser");
			Header header = message.getHeader(name);
			if(header != null) {
				Element e = (Element) header.getObject();
				JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				User authorizedUser = unmarshaller.unmarshal(e, User.class).getValue();
				System.out.println(String.format("[Server]SOAPHeader %s: %s", "authorizedUser", authorizedUser));
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
