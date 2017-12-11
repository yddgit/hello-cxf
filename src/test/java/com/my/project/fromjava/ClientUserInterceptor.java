package com.my.project.fromjava;

import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.phase.Phase;

import com.my.project.model.User;

public class ClientUserInterceptor extends AbstractSoapInterceptor {

	public ClientUserInterceptor() {
		// 默认构造函数: 在写消息阶段执行
		super(Phase.WRITE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		try {
			List<Header> headers = message.getHeaders();
			QName name = new QName("http://project.my.com/", "authorizedUser");
			DataBinding binding = new JAXBDataBinding(User.class);
			User user = new User();
			user.setUsername("admin");
			user.setPassword("123456");
			Header header = new Header(name, user, binding);
			headers.add(header);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
