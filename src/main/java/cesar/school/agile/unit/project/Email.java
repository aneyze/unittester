package cesar.school.agile.unit.project;

import java.time.LocalDate;
import java.util.Collection;

public class Email {
    public static final String EMAIL_NÃO_ESTÁ_PREENCHIDO = "Email não está preenchido";
    public static final String EMAIL_ESTÁ_PREENCHIDO = "Email está preenchido";
    private LocalDate creationDate;
    private String from;
    private Collection<String> to;
    private Collection<String> cc;
    private Collection<String> bcc;
    private String subject;
    private String message;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Collection<String> getTo() {
        return to;
    }

    public void setTo(Collection<String> to) {
        this.to = to;
    }

    public Collection<String> getCc() {
        return cc;
    }

    public void setCc(Collection<String> cc) {
        this.cc = cc;
    }

    public Collection<String> getBcc() {
        return bcc;
    }

    public void setBcc(Collection<String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String emailPreenchido(Email email) {
        boolean v1 = false;
        boolean v2 = false;
        boolean v3 = false;
        boolean v4 = false;
        boolean v5 = false;
        boolean v6 = false;
        boolean v7 = false;
        boolean a = false;

        if (email.from != null) {
            v1 = true;
        } else {
            v1 = false;
        }

        if (email.creationDate != null) {
            v2 = true;
        } else {
            v2 = false;
        }

        if (email.message != null) {
            v3 = true;
        } else {
            v3 = false;
        }

        if (email.subject != null) {
            v4 = true;
        } else {
            v4 = false;
        }

        for (String s : email.to) {
            if (email.to!=null) {
                v5 = true;
            }
            else{
                v5=false;
            }
        }


        for (String s : email.cc) {
            if (email.cc!=null) {
                v6 = true;
            }
            else{
                v6=false;
            }
        }

        for (String s : email.bcc) {
            if (email.bcc!=null) {
                v7 = true;
            }
            else{
                v7=false;
            }
        }


        a = v1 && v2 && v3 && v4 && v5 && v6 && v7;

        if (a) {
            return EMAIL_ESTÁ_PREENCHIDO;
        } else {
            return EMAIL_NÃO_ESTÁ_PREENCHIDO;
        }
    }
}



