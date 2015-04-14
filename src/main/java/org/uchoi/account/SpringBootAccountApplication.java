package org.uchoi.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.uchoi.account.view.AccountView;

@SpringBootApplication
public class SpringBootAccountApplication {

    public static void main(String[] args) {
    	
        ApplicationContext context =SpringApplication.run(SpringBootAccountApplication.class, args);
        AccountView accountView = (AccountView) context.getBean("accountView");
        accountView.showMainMenu();

    }
}
