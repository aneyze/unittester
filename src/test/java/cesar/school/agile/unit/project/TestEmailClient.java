package cesar.school.agile.unit.project;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class TestEmailClient {
    private Collection<EmailAccount> accounts;
    private EmailService emailService;

    private LocalDate creationDateV = LocalDate.parse( "2018-08-08" );
    private String fromV = "rrd@gmail.com";
    private Collection<String> toBuildV = new ArrayList<String>();
    private Collection<String> ccBuildV = new ArrayList<String>();
    private Collection<String> bccBuildV = new ArrayList<String>();
    private String subjectV = "BeHappy";
    private String messageV = "lahsdkhqkbwdskjsdkahdkajsdhkjsahdkjashkjh";

    private LocalDate creationDateN = null;
    private String fromN = null;
    private Collection<String> toBuildN = new ArrayList<String>();
    private Collection<String> ccBuildN = new ArrayList<String>();
    private Collection<String> bccBuildN = new ArrayList<String>();
    private String subjectN = null;
    private String messageN = null;

    private Email email;
    private EmailAccount emailAccount;
    private EmailClient emailClient;
    private EmailBuilder emailBuilder = new EmailBuilder();

    private EmailBuilder emailBuilderV;
    private EmailBuilder emailBuilderN;
    private EmailBuilder emailBuilderCreationDateNull;
    private EmailBuilder emailBuilderFromNull;
    private EmailBuilder emailBuilderCcNull;
    private EmailBuilder emailBuilderToNull;
    private EmailBuilder emailBuilderBccNull;
    private EmailBuilder emailBuilderSubjectNull;
    private EmailBuilder emailBuilderMessageNull;
    private Email emailV;
    private Email emailN;
    private Email emailC;
    private Email emailF;
    private Email emailCc;
    private Email emailT;
    private Email emailB;
    private Email emailS;
    private Email emailM;


    private String userNotValid = "/////aneyze";
    private String domainNotValid = "..gmail.com...";
    private String passwordNotValid = "3123";
    private LocalDate lastPasswordUpdateNotValid = LocalDate.parse("2017-09-09");

    private String userValid = "aneyze";
    private String domainValid = "gmail.com";
    private String passwordValid = "3123212121";
    private LocalDate lastPasswordUpdateValid = LocalDate.parse("2018-09-09");

    private EmailAccount emailAccountNotValid;
    private EmailAccount emailAccountValid;
    private EmailAccount emailAccountPasswordExpired;
    private EmailAccount emailAccountPasswordNotValid;
    private EmailAccount emailAccountUserNotValid;
    private EmailAccount emailAccountDomainNotValid;


    @BeforeEach
    public void setUp() {

        emailClient = new EmailClient();
        emailClient.setAccounts(accounts);
        emailClient.setEmailService(emailService);
        Collection <Email> emailClientArray = new ArrayList<Email>();
        emailClientArray.add(emailV);

        IntStream.range( 0, 10 ).forEach( i -> {
            toBuildV.add( "frlc@gma" + i + "il.com" );
            ccBuildV.add( "frlc@gma" + i + "il.com" );
            bccBuildV.add( "frlc@gma" + i + "il.com" );
        } );

        emailBuilderV = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc( bccBuildV)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderN = new EmailBuilder()
                .setCreationDate(creationDateN)
                .setFrom(fromN)
                .setTo(toBuildN)
                .setCc(ccBuildN)
                .setBcc( bccBuildN)
                .setSubject (subjectN)
                .setMessage( messageN);

        emailBuilderCreationDateNull = new EmailBuilder()
                .setCreationDate(null)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc( bccBuildV)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderFromNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(null)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc( bccBuildV)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderCcNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildN)
                .setBcc( bccBuildV)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderToNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(bccBuildN)
                .setCc(ccBuildV)
                .setBcc( bccBuildV)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderBccNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc(bccBuildN)
                .setSubject (subjectV)
                .setMessage( messageV);

        emailBuilderSubjectNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc(bccBuildV)
                .setSubject (null)
                .setMessage( messageV);

        emailBuilderMessageNull = new EmailBuilder()
                .setCreationDate(creationDateV)
                .setFrom(fromV)
                .setTo(toBuildV)
                .setCc(ccBuildV)
                .setBcc(bccBuildV)
                .setSubject (subjectV)
                .setMessage( null);

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

        emailAccountPasswordNotValid = new EmailAccountBuilder()
                .setUser(userValid)
                .setDomain(domainValid)
                .setPassword(passwordNotValid)
                .setLastPasswordUpdate(lastPasswordUpdateValid).build();

        emailAccountPasswordExpired = new EmailAccountBuilder()
                .setUser(userValid)
                .setDomain(domainValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateNotValid).build();

        emailAccountUserNotValid = new EmailAccountBuilder()
                .setUser(userNotValid)
                .setDomain(domainValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateNotValid).build();

        emailAccountDomainNotValid = new EmailAccountBuilder()
                .setUser(userValid)
                .setDomain(domainNotValid)
                .setPassword(passwordValid)
                .setLastPasswordUpdate(lastPasswordUpdateNotValid).build();

    }


    @Test
    public void testIsValidAddress() {
        emailV = emailBuilderV.build();

        EmailClient emailClientV = new EmailClient();
        String emailAdressV = userValid+"@"+domainValid;
        Assertions.assertTrue(emailClientV.isValidAddress(emailAdressV));

    }

    @Test
    public void testIsNotValidAddress() {
        emailN = emailBuilderN.build();

        EmailClient emailClientN = new EmailClient();
        String emailAdressN = userNotValid+"@"+domainNotValid;
        Assertions.assertFalse(emailClientN.isValidAddress(emailAdressN));

    }



    @Test
    public void testIsValidEmail() {
        emailV = emailBuilderV.build();

        EmailClient emailClientV = new EmailClient();
        Assertions.assertTrue(emailClientV.isValidEmail(emailV));

    }

    @Test
    public void testIsNotValidEmail() {
        emailN = emailBuilderN.build();

        EmailClient emailClientN = new EmailClient();
        Assertions.assertFalse(emailClientN.isValidEmail(emailN));

    }

    @Test
    public void testIsNotValidCreationDate(){
        emailC = emailBuilderCreationDateNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailC ));
    }

    @Test
    public void testIsNotValidFrom(){
        emailF = emailBuilderFromNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailF ));
    }

    @Test
    public void testIsNotValidCc(){
        emailCc = emailBuilderCcNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailCc ));
    }

    @Test
    public void testIsNotValidAddressCc(){
        emailCc = emailBuilderCcNull.build();
        String emailCC = String.valueOf( emailCc.getCc() );
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidAddress( emailCC ));
    }


    @Test
    public void testIsNotValidTo(){
        emailT = emailBuilderToNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailT ));
    }

    @Test
    public void testIsNotValidAddressTo(){
        emailT = emailBuilderToNull.build();
        String emailTo = String.valueOf( emailT.getTo() );
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidAddress( emailTo ));
    }

    @Test
    public void testIsNotValidBcc(){
        emailB = emailBuilderBccNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailB ));
    }

    @Test
    public void testIsNotValidAddressBcc(){
        emailB = emailBuilderBccNull.build();
        String emailBcc = String.valueOf( emailB.getTo() );
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidAddress( emailBcc ));
    }
    @Test
    public void testIsNotValidSubject(){
        emailS = emailBuilderSubjectNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailS ));
    }

    @Test
    public void testIsNotValidMessage(){
        emailM = emailBuilderMessageNull.build();
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.isValidEmail( emailM ));
    }

    @Test
    public void testAccountIsValid() {
        EmailClient emailClientV = new EmailClient();
        Assertions.assertTrue(emailClientV.createAccount(emailAccountValid));

    }

    @Test
    public void testAccountIsNotValid() {
        EmailClient emailClientN = new EmailClient();
        Assertions.assertFalse(emailClientN.createAccount(emailAccountNotValid));

    }

    @Test
    public void testUserIsNotValid() {
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.createAccount(emailAccountUserNotValid));

    }

    @Test
    public void testDomainIsNotValid() {
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.createAccount(emailAccountDomainNotValid));

    }

    @Test
    public void testPasswordIsNotValid() {
        EmailClient emailClient = new EmailClient();
        Assertions.assertFalse(emailClient.createAccount(emailAccountPasswordNotValid));

    }

    @Test
    public void testIsValidEmailList(){
        EmailClient emailClientV = new EmailClient();
        Collection <Email> expectedEmail = Collections.singleton(emailV);
        Assertions.assertEquals(emailV, emailClientV.emailList( emailAccountValid ));
    }

    @Test
    public void testIsNotValidEmailList(){
        EmailClient emailClientN = new EmailClient();
        Assertions.assertThrows( RuntimeException.class, ()->emailClientN.emailList( emailAccountNotValid ) );
    }

    @Test
    public void testIsNotValidPassword(){
        EmailClient emailClient = new EmailClient();
        Assertions.assertThrows( RuntimeException.class, ()->emailClient.emailList( emailAccountPasswordNotValid ) );
    }

    @Test
    public void testIsPasswordExpired(){
        EmailClient emailClient = new EmailClient();
        Assertions.assertThrows( RuntimeException.class, ()->emailClient.emailList( emailAccountPasswordExpired ) );
    }

    @Test
    public void testIsNotValidSendEmail(){
        EmailClient emailClientN = new EmailClient();
        Assertions.assertThrows( RuntimeException.class, ()->emailClientN.sendEmail( emailN ) );
    }

}