package ru.test.postings.loginsdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;


@Configuration
public class LoginsConfiguration {
    @Autowired Environment ev;

    @Bean
    public CommandLineRunner commandLineRunnerLogins(LoginsRepository loginsRepository)
    {
        String loginspath = ev.getProperty("logins.path");
        // System.out.println("loginspath="+loginspath);

        List<LoginRecord> llist = LoginsData.initList(loginspath);

        return args -> {  loginsRepository.saveAll( llist ); };
    }


}
