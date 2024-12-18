package com.PGS.Stage.config;
import com.PGS.Stage.soap.SoapConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@Configuration
@EnableWs
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "stages")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema stageSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("StagePort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace(SoapConstants.NAMESPACE_URI);
        definition.setSchema(stageSchema);
        return definition;
    }

    @Bean
    public XsdSchema stageSchema() {
        return new SimpleXsdSchema(new ClassPathResource("stage.xsd"));
    }
}