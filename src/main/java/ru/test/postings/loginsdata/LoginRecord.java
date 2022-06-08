package ru.test.postings.loginsdata;

import javax.persistence.*;

@Entity
public class LoginRecord {

    @Id
    @SequenceGenerator(name = "logins_sequence", sequenceName = "logins_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logins_sequence")
    private Long id;
    private String application;
    private String appAccauntName;
    private String isActive;
    private String jobTitle;
    private String department;

    public LoginRecord() {
    }

    public LoginRecord(String application, String appAccauntName, String isActive, String jobTitle, String department) {
        this.application = application;
        this.appAccauntName = appAccauntName;
        this.isActive = isActive;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public String getApplication() {
        return application;
    }

    public String getAppAccauntName() {
        return appAccauntName;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setAppAccauntName(String appAccauntName) {
        this.appAccauntName = appAccauntName;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
