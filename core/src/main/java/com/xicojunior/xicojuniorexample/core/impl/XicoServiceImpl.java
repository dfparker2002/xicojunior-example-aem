package com.xicojunior.xicojuniorexample.core.impl;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import com.xicojunior.xicojuniorexample.core.XicoService;

@Component(immediate=true, label="Xico Service", description="This is a Service", metatype=true)
@Service(value=XicoService.class)
public class XicoServiceImpl implements XicoService {
	
	@Property(value="http://companyservices/myservice?wsdl")
    static final String SERVICE_ENDPOINT_URL = "service.endpoint.url";
    
    private String serviceEndpointUrl;
	
    @Activate
    public void activate(final Map<String, Object> props) {
    	System.out.println("Calling Activate Method");
    	this.serviceEndpointUrl = (String)props.get(SERVICE_ENDPOINT_URL);
    	System.out.println("ServiceEndpointUrl:" + this.serviceEndpointUrl);
    }
    
    
	@Override
	public String getData() {
		return "Calling Service from:" + this.serviceEndpointUrl;
	}
}
