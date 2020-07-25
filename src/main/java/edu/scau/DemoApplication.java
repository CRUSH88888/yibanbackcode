package edu.scau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ServletComponentScan注解后，Servlet Filter Listener可以直接通过@WebServlet @WebFilter @WebListener注解自动注册，无需任何代码
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class DemoApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(DemoApplication.class,args);
    }
}
