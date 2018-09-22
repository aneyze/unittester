package cesar.school.agile.unit.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class EmailBuilder {
    private LocalDate creationDate;
    private String from;
    private Collection<String> toBuild;
    private Collection<String> ccBuild;
    private Collection<String> bccBuild;
    private String subject;
    private String message;



    public EmailBuilder setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public EmailBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public EmailBuilder setTo(Collection<String> toBuild) {
        this.toBuild = toBuild;
        return this;
    }

    public EmailBuilder setCc(Collection<String> ccBuild) {
        this.ccBuild = ccBuild;
        return this;
    }

    public EmailBuilder setBcc(Collection<String> bccBuild) {
        this.bccBuild = bccBuild;
        return this;
    }

    public Email build(){
        Email emailss = new Email();
        emailss.setCreationDate(this.creationDate);
        emailss.setFrom(this.from);
        emailss.setSubject(this.subject);
        emailss.setMessage(this.message);
        emailss.setTo(this.toBuild);
        emailss.setCc(this.ccBuild);
        emailss.setBcc(this.bccBuild);
        return emailss;
    }
}
