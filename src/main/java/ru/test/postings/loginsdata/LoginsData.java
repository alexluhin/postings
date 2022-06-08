package ru.test.postings.loginsdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginsData {

    private static List<LoginRecord> loginsList = new ArrayList<>();

    public static List<LoginRecord> getLoginsList()
    {
        return loginsList;
    }
    public static List<LoginRecord> initList(String path)
    {
        // read logins
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
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
                LoginRecord lrec = new LoginRecord();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    try {
                        if (index == 0)
                            lrec.setApplication(data.trim());
                        else if (index == 1)
                            lrec.setAppAccauntName(data.trim());
                        else if (index == 2)
                            lrec.setIsActive(data.trim());
                        else if (index == 3)
                            lrec.setJobTitle(data.trim());
                        else if (index == 4)
                            lrec.setDepartment(data.trim());
                        else
                            System.out.println("Incorrect data:" + data);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    index++;
                }
                index = 0;
                loginsList.add(lrec);
            }
            reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return loginsList;
    }
}
