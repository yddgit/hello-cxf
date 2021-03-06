package com.my.project.fromjava;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * 发送WebService消息时添加Header[authorize]
 * @author yang
 */
public class ClientHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			Boolean out = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(out) {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if(header == null) {
					header = envelope.addHeader();
				}
				QName name = new QName("http://project.my.com/", "authorize");
				header.addHeaderElement(name).setValue("admin");
			}
			return true;
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
