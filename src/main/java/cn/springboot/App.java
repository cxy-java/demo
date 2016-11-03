package cn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.shell.Bootstrap;

import cn.springboot.netty.WebsocketServer;

/**
 * Hello world!
 *
 */
@Configuration  
@ComponentScan  
@EnableAutoConfiguration
@ServletComponentScan
@ImportResource(locations = "classpath*:/applicationContext.xml")
@PropertySource("classpath:quartz.properties")  
@EnableAsync
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
        SpringApplication.run(App.class, args);
        new WebsocketServer(8090).run();
        Bootstrap.main(args);
    }
}
