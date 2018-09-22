package cesar.school.agile.unit.project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailAccount {
    private String user;
    private String domain;
    private String password;
    private LocalDate lastPasswordUpdate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }


    public boolean verifyPasswordExpiration() {
        LocalDate agora = LocalDate.now();

        long diferencaEmDias = 0;
        diferencaEmDias = ChronoUnit.DAYS.between( this.lastPasswordUpdate, agora );

        if (diferencaEmDias <= 90) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isPasswordValid() {
        if (this.password.length() > 6) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserValid(){
        boolean isUserValid = false;
        if (this.user != null) {
            String expression = "^[A-Za-z0-9_.-]{3,16}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(user);
            if (matcher.matches()) {
                isUserValid = true;
            }else{
                isUserValid = false;
            }
        }
        return isUserValid;

    }
    public boolean isDomainValid(){
        boolean isDomainValid = false;
        if (this.domain != null) {
            String expression = "^[a-zA-Z0-9][a-zA-Z0-9-]{1,61}[a-zA-Z0-9]\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(domain);
            if (matcher.matches()) {
                isDomainValid = true;
            }
            else{
                isDomainValid = false;
            }
        }
        return isDomainValid;

    }

}


