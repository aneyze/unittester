package cesar.school.agile.unit.project;

import java.time.LocalDate;

public class EmailAccountBuilder {
    private String user;
    private String domain;
    private String password;
    private LocalDate lastPasswordUpdate;

    public EmailAccountBuilder setUser(String user) {
        this.user = user;
        return this;
    }

    public EmailAccountBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public EmailAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public EmailAccountBuilder setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
        return this;
    }

    public EmailAccount build(){
        EmailAccount builderAccount = new EmailAccount();
        builderAccount.setUser(this.user);
        builderAccount.setDomain(this.domain);
        builderAccount.setPassword(this.password);
        builderAccount.setLastPasswordUpdate(this.lastPasswordUpdate);
        return builderAccount;
    }
}
