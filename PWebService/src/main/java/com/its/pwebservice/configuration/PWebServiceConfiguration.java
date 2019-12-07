package com.its.pwebservice.configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.its.pwebservice.handle.MonitorEventHandle;
import com.its.webservice.ws.VWebServicePortType;

@Configuration
public class PWebServiceConfiguration {
	@Value("${com.its.webservice.impl-class}")
	private String vwebServicePortTypeImplName = "";
	@Value("${com.its.webservice.name}")
	private String webServiceName = "";
	@Value("${com.its.webservice.wsdl-file}")
	private String webServiceWsdlFile = "";
	@Value("${com.its.webservice.url}")
	private String SERVICE_URL = "";

	@Bean("pwebServicePortType")
	public VWebServicePortType pwebServicePortType() throws Exception {
		return (VWebServicePortType) Class.forName(vwebServicePortTypeImplName).newInstance();
	}

	@Bean
	public Endpoint endpoint() throws Exception {

		EndpointImpl endpoint = new EndpointImpl(bus(), pwebServicePortType(), SOAPBinding.SOAP12HTTP_BINDING);
		endpoint.publish(webServiceName);
		endpoint.setWsdlLocation(webServiceWsdlFile);
		return endpoint;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus bus() {
		SpringBus springBus = new SpringBus();
		return springBus;
	}

	@Bean("vwebServicePortTypeClient")
	public VWebServicePortType vwebServicePortTypeClient() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VWebServicePortType.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL);
		return (VWebServicePortType) jaxWsProxyFactoryBean.create();
	}

	@Bean("MonitorEventHandle")
	public MonitorEventHandle monitorEventHandle(ThreadPoolExecutor pool) {
		return new MonitorEventHandle(pool);
	}

	@Bean("monitorDataQueue")
	public LinkedBlockingQueue monitorDataQueue() {
		return new LinkedBlockingQueue(400000);
	}

	@Bean("threadPoolExecutor")
	public ThreadPoolExecutor threadPoolExecutor() {
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
		threadPoolExecutor.execute(monitorEventHandle(threadPoolExecutor));
		return threadPoolExecutor;
	}
}
