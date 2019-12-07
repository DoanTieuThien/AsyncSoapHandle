package com.its.webservice.config;

import java.util.concurrent.ConcurrentHashMap;
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

import com.its.webservice.config.models.DataTransferModel;
import com.its.webservice.process.HandleRequestCommand;
import com.its.webservice.process.HandleResponseCommand;
import com.its.webservice.ws.VWebServicePortType;

@Configuration
public class VWebServiceConfiguration {
	@Value("${com.its.webservice.impl-class}")
	private String vwebServicePortTypeImplName = "";
	@Value("${com.its.webservice.name}")
	private String webServiceName = "";
	@Value("${com.its.webservice.wsdl-file}")
	private String webServiceWsdlFile = "";
	@Value("${com.its.webservice.url-app1}")
	private String SERVICE_URL_APP1 = "";
	@Value("${com.its.webservice.url-app2}")
	private String SERVICE_URL_APP2 = "";
	@Value("${com.its.webservice.url-app3}")
	private String SERVICE_URL_APP3 = "";
	@Value("${com.its.webservice.url-app4}")
	private String SERVICE_URL_APP4 = "";

	@Bean("vwebServicePortType")
	public VWebServicePortType vwebServicePortType() throws Exception {
		return (VWebServicePortType) Class.forName(vwebServicePortTypeImplName).newInstance();
	}

	@Bean
	public Endpoint endpoint() throws Exception {
		EndpointImpl endpoint = new EndpointImpl(bus(), vwebServicePortType(), SOAPBinding.SOAP12HTTP_BINDING);
		endpoint.publish(webServiceName);
		endpoint.setWsdlLocation(webServiceWsdlFile);
		return endpoint;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus bus() {
		SpringBus springBus = new SpringBus();
		return springBus;
	}

	@Bean("requestCommandQueue")
	public LinkedBlockingQueue requestCommandQueue() {
		return new LinkedBlockingQueue(400000);
	}

	@Bean("responseCommandQueue")
	public LinkedBlockingQueue responseCommandQueue() {
		return new LinkedBlockingQueue(400000);
	}

	@Bean("threadPoolExecutor")
	public ThreadPoolExecutor threadPoolExecutor() {
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
		threadPoolExecutor.execute(handleRequestCommand(threadPoolExecutor));

		ConcurrentHashMap<String, LinkedBlockingQueue> appManager = managerApp();

		// start app 1
		LinkedBlockingQueue<DataTransferModel> app1ResponseQueueApp1 = new LinkedBlockingQueue<DataTransferModel>();
		appManager.put("APP1", app1ResponseQueueApp1);
		threadPoolExecutor.execute(
				handleResponseCommand1(app1ResponseQueueApp1, threadPoolExecutor, vwebServicePortTypeClientAPP1()));
		// start app 2
		LinkedBlockingQueue<DataTransferModel> app1ResponseQueueApp2 = new LinkedBlockingQueue<DataTransferModel>();
		appManager.put("APP2", app1ResponseQueueApp2);
		threadPoolExecutor.execute(
				handleResponseCommand2(app1ResponseQueueApp2, threadPoolExecutor, vwebServicePortTypeClientAPP2()));
		// start app 3
		LinkedBlockingQueue<DataTransferModel> app1ResponseQueueApp3 = new LinkedBlockingQueue<DataTransferModel>();
		appManager.put("APP3", app1ResponseQueueApp3);
		threadPoolExecutor.execute(
				handleResponseCommand3(app1ResponseQueueApp3, threadPoolExecutor, vwebServicePortTypeClientAPP3()));
		// start app 4
		LinkedBlockingQueue<DataTransferModel> app1ResponseQueueApp4 = new LinkedBlockingQueue<DataTransferModel>();
		appManager.put("APP4", app1ResponseQueueApp4);
		threadPoolExecutor.execute(
				handleResponseCommand4(app1ResponseQueueApp4, threadPoolExecutor, vwebServicePortTypeClientAPP4()));
		
		//so ket noi duoc khoi tao dua vao managerApp o day
		return threadPoolExecutor;
	}

	@Bean("HandleRequestCommand")
	public HandleRequestCommand handleRequestCommand(ThreadPoolExecutor pool) {
		return new HandleRequestCommand(pool);
	}

	@Bean("HandleResponseCommand1")
	public HandleResponseCommand handleResponseCommand1(LinkedBlockingQueue<DataTransferModel> queue,
			ThreadPoolExecutor pool, VWebServicePortType porttype) {
		return new HandleResponseCommand(queue, pool, porttype);
	}
	@Bean("HandleResponseCommand2")
	public HandleResponseCommand handleResponseCommand2(LinkedBlockingQueue<DataTransferModel> queue,
			ThreadPoolExecutor pool, VWebServicePortType porttype) {
		return new HandleResponseCommand(queue, pool, porttype);
	}
	@Bean("HandleResponseCommand3")
	public HandleResponseCommand handleResponseCommand3(LinkedBlockingQueue<DataTransferModel> queue,
			ThreadPoolExecutor pool, VWebServicePortType porttype) {
		return new HandleResponseCommand(queue, pool, porttype);
	}
	@Bean("HandleResponseCommand4")
	public HandleResponseCommand handleResponseCommand4(LinkedBlockingQueue<DataTransferModel> queue,
			ThreadPoolExecutor pool, VWebServicePortType porttype) {
		return new HandleResponseCommand(queue, pool, porttype);
	}

	@Bean("vwebServicePortTypeClientAPP1")
	public VWebServicePortType vwebServicePortTypeClientAPP1() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VWebServicePortType.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL_APP1);
		return (VWebServicePortType) jaxWsProxyFactoryBean.create();
	}

	@Bean("vwebServicePortTypeClientAPP2")
	public VWebServicePortType vwebServicePortTypeClientAPP2() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VWebServicePortType.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL_APP2);
		return (VWebServicePortType) jaxWsProxyFactoryBean.create();
	}

	@Bean("vwebServicePortTypeClientAPP3")
	public VWebServicePortType vwebServicePortTypeClientAPP3() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VWebServicePortType.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL_APP3);
		return (VWebServicePortType) jaxWsProxyFactoryBean.create();
	}

	@Bean("vwebServicePortTypeClientAPP4")
	public VWebServicePortType vwebServicePortTypeClientAPP4() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VWebServicePortType.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL_APP4);
		return (VWebServicePortType) jaxWsProxyFactoryBean.create();
	}

	@Bean("managerApp")
	public ConcurrentHashMap<String, LinkedBlockingQueue> managerApp() {
		ConcurrentHashMap<String, LinkedBlockingQueue> appMap = new ConcurrentHashMap<String, LinkedBlockingQueue>();
		return appMap;
	}

}
