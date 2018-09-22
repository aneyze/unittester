package cesar.school.agile.unit.project;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TestEmailAccount {
    private String userNotValid = "/////aneyze";
    private String domainNotValid = "..gmail.com...";
    private String passwordNotValid = "3123";
    private LocalDate lastPasswordUpdateNotValid = LocalDate.parse("2017-09-09");

    private String userValid = "aneyze";
    private String domainValid = "gmail.com";
    private String passwordValid = "3123212121";
    private LocalDate lastPasswordUpdateValid = LocalDate.parse("2018-09-09");

    //Email email = new Email();
    private EmailAccount emailAccountNotValid;
    private EmailAccount emailAccountValid;
    private EmailAccount emailAccountDomainNotValid;
    private EmailAccount emailAccountUserNotValid;
    private EmailAccount emailAccountPasswordNotValid;

    @BeforeEach
    public void setUp(){

                emailAccountNotValid = new EmailAccountBuilder()
                .setUser(userNotValid)
                .setDomain(domainNotValid)
                .setPassword(passwordNotValid)
                .setLastPasswordUpdate(lastPasswordUpdateNotValid).build();

                emailAccountValid = new EmailAccountBuilder()
                .setUser(userValid)
                .setDomain(domainValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateValid).build();

                emailAccountUserNotValid = new EmailAccountBuilder()
                .setUser(userNotValid)
                .setDomain(domainValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateValid).build();

                emailAccountDomainNotValid = new EmailAccountBuilder()
                .setUser(userNotValid)
                .setDomain(domainNotValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateValid).build();

                emailAccountPasswordNotValid = new EmailAccountBuilder()
                .setUser(userNotValid)
                .setDomain(domainValid)
                .setPassword(passwordNotValid)
                .setLastPasswordUpdate(lastPasswordUpdateValid).build();

    }

    @Test
    public void testEmailAccountNotValid(){
        Assertions.assertFalse(emailAccountNotValid.verifyPasswordExpiration());
        Assertions.assertFalse(emailAccountNotValid.isPasswordValid());
        Assertions.assertFalse(emailAccountNotValid.isUserValid());
        Assertions.assertFalse(emailAccountNotValid.isDomainValid());

    }
    @Test
    public void testEmailAccountValid(){
        Assertions.assertTrue(emailAccountValid.verifyPasswordExpiration());
        Assertions.assertTrue(emailAccountValid.isPasswordValid());
        Assertions.assertTrue(emailAccountValid.isUserValid());
        Assertions.assertTrue(emailAccountValid.isDomainValid());

    }


    @Test
    public void testUserIsNotValid() {
        Assertions.assertFalse(emailAccountUserNotValid.isUserValid());
    }

    @Test
    public void testDomainIsNotValid() {
        Assertions.assertFalse(emailAccountDomainNotValid.isDomainValid());
    }

    @Test
    public void testPasswordIsNotValid() {
        Assertions.assertFalse(emailAccountPasswordNotValid.isPasswordValid());
    }

    @Test
    public void testGetDomainValid(){
        Assertions.assertEquals( domainValid, emailAccountValid.getDomain());
    }

    @Test
    public void testGetDomainNotValid(){
        Assertions.assertEquals( domainNotValid, emailAccountNotValid.getDomain());
    }

    @Test
    public void testGetUserValid(){
        Assertions.assertEquals( userValid, emailAccountValid.getUser());
    }

    @Test
    public void testGetUserNotValid(){
        Assertions.assertEquals( userNotValid, emailAccountNotValid.getUser());
    }

    @Test
    public void testGetPasswordValid(){
        Assertions.assertEquals( passwordValid, emailAccountValid.getPassword());
    }

    @Test
    public void testGetPasswordNotValid(){
        Assertions.assertEquals( passwordNotValid, emailAccountNotValid.getPassword());
    }

    @Test
    public void testGetLastPasswordUpdateValid(){
        Assertions.assertEquals( lastPasswordUpdateValid, emailAccountValid.getLastPasswordUpdate());
    }

    @Test
    public void testGetLastPasswordUpdateNotValid(){
        Assertions.assertEquals( lastPasswordUpdateNotValid, emailAccountNotValid.getLastPasswordUpdate());
    }


}

