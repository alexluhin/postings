package ru.test.postings.postdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.test.postings.loginsdata.LoginRecord;
import ru.test.postings.loginsdata.LoginsData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
public class PostConfiguration {
    @Autowired Environment ev;

    @Bean
    public CommandLineRunner commandLineRunner(PostRepository postRepository)
    {

        String postingspath = ev.getProperty("postings.path");
        //System.out.println("postingspath="+postingspath);

        List<LoginRecord> llist = LoginsData.getLoginsList();

        List<PostRecord> postList = new ArrayList<>();
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(postingspath));
            String line = null;
            Scanner scanner = null;
            int index = 0;
            boolean first = true;

            while ((line = reader.readLine()) != null)
            {
                if(first)
                {
                    first = false;
                    continue;
                }
                PostRecord prec = new PostRecord();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    try {
                        if (index == 0)
                            prec.setMatdoc(data.trim());
                        else if (index == 1)
                            prec.setItem(Integer.parseInt(data.trim()));
                        else if (index == 2)
                            prec.setDocdate(LocalDate.parse(data.trim(), formatter));
                        else if (index == 3)
                            prec.setPstngdate(LocalDate.parse(data.trim(), formatter));
                        else if (index == 4)
                            prec.setMatdesc(data.trim());
                        else if (index == 5)
                            prec.setQuantity(Integer.parseInt(data.trim()));
                        else if (index == 6)
                            prec.setBun(data.trim());
                        else if (index == 7)
                            prec.setAmount(Double.parseDouble(data.trim().replaceAll(",",".")));
                        else if (index == 8)
                            prec.setCrcy(data.trim());
                        else if (index == 9)
                            prec.setUsername(data.trim());
                        else
                            System.out.println("Incorrect data:" + data);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    index++;
                }
                prec.setAutorpstn(checkLogins(prec.getUsername(),llist));
                index = 0;
                postList.add(prec);
            }
            reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return args -> {  postRepository.saveAll( postList ); };
    }

    private boolean checkLogins(String username, List<LoginRecord> list)
    {
        for(LoginRecord lr: list)
        {
            if(lr.getAppAccauntName().equals(username) && lr.getIsActive().equalsIgnoreCase("true"))
                return true;
        }
        return false;
    }
}
