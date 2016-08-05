package cn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Bootstrap;

import cn.springboot.netty.WebsocketServer;

/**
 * Hello world!
 *
 */
@Configuration  
@ComponentScan  
@EnableAutoConfiguration  
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
        SpringApplication.run(App.class, args);
        new WebsocketServer(8090).run();
        Bootstrap.main(args);
    }
}
