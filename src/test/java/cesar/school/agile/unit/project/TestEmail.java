package cesar.school.agile.unit.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

public class TestEmail {
    private LocalDate creationDateP = LocalDate.parse( "2018-08-08" );
    private String fromP = "rrd@gmail.com";
    private Collection<String> toBuildP = new ArrayList<String>();
    private Collection<String> ccBuildP = new ArrayList<String>();
    private Collection<String> bccBuildP = new ArrayList<String>();
    private String subjectP = "BeHappy";
    private String messageP = "lahsdkhqkbwdskjsdkahdkajsdhkjsahdkjashkjh";

    private LocalDate creationDateN = null;
    private String fromN = null;
    private Collection<String> toBuildN = new ArrayList<String>();
    private Collection<String> ccBuildN = new ArrayList<String>();
    private Collection<String> bccBuildN = new ArrayList<String>();
    private String subjectN = null;
    private String messageN = null;


    EmailBuilder emailBuilderP;
    EmailBuilder emailBuilderN;
    EmailBuilder emailBuilderF;
    EmailBuilder emailBuilderC;
    EmailBuilder emailBuilderM;
    EmailBuilder emailBuilderS;
    EmailBuilder emailBuilderT;
    EmailBuilder emailBuilderCc;
    EmailBuilder emailBuilderB;

    Email emailP;
    Email emailN;
    Email emailF;
    Email emailC;
    Email emailM;
    Email emailS;
    Email emailT;
    Email emailCc;
    Email emailB;

    @BeforeEach
    public void setUp(){
        IntStream.range( 0, 10 ).forEach( i -> {
            toBuildP.add( "frlc@gma" + i + "il.com" );
            ccBuildP.add( "frlc@gma" + i + "il.com" );
            bccBuildP.add( "frlc@gma" + i + "il.com" );
        } );

        emailBuilderP = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageP);

        emailBuilderN = new EmailBuilder()
                .setCreationDate(creationDateN)
                .setFrom(fromN)
                .setTo(toBuildN)
                .setCc(ccBuildN)
                .setBcc( bccBuildN)
                .setSubject (subjectN)
                .setMessage( messageN);

        emailBuilderF = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromN)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageP);

        emailBuilderC = new EmailBuilder()
                .setCreationDate(creationDateN)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageP);

        emailBuilderM = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageN);

        emailBuilderS = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectN)
                .setMessage( messageP);

        emailBuilderT = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildN)
                .setCc(ccBuildP)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageP);

        emailBuilderCc = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildN)
                .setBcc( bccBuildP)
                .setSubject (subjectP)
                .setMessage( messageP);

        emailBuilderB = new EmailBuilder()
                .setCreationDate(creationDateP)
                .setFrom(fromP)
                .setTo(toBuildP)
                .setCc(ccBuildP)
                .setBcc( bccBuildN)
                .setSubject (subjectP)
                .setMessage( messageP);

    }

    @Test
    public void testEmailPreenchido(){
        emailP = emailBuilderP.build();
        Assertions.assertEquals( Email.EMAIL_ESTÁ_PREENCHIDO, emailP.emailPreenchido( emailP ));

    }

    @Test
    public void testEmailNaoPreenchido(){
        emailN = emailBuilderN.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailN.emailPreenchido( emailN ));

    }

    @Test
    public void testEmailFromNaoPreenchido(){
        emailF = emailBuilderF.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailF.emailPreenchido( emailF ));

    }

    @Test
    public void testEmailCreationDateNaoPreenchido(){
        emailC = emailBuilderC.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailC.emailPreenchido( emailC ));

    }

    @Test
    public void testEmailMessageNaoPreenchido(){
        emailM = emailBuilderM.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailM.emailPreenchido( emailM ));

    }

    @Test
    public void testEmailSubjectNaoPreenchido(){
        emailS = emailBuilderS.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailS.emailPreenchido( emailS ));

    }

    @Test
    public void testEmailToNaoPreenchido(){
        emailT = emailBuilderT.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailT.emailPreenchido( emailT ));

    }

    @Test
    public void testEmailCcNaoPreenchido(){
        emailCc = emailBuilderCc.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailCc.emailPreenchido( emailCc ));

    }

    @Test
    public void testEmailBccNaoPreenchido(){
        emailB = emailBuilderB.build();
        Assertions.assertEquals( Email.EMAIL_NÃO_ESTÁ_PREENCHIDO, emailB.emailPreenchido( emailB ));

    }


    @Test
    public void testGetSubjectValid(){
        emailP = emailBuilderP.build();
        Assertions.assertEquals( subjectP, emailP.getSubject());
    }

    @Test
    public void testGetSubjectNotValid(){
        emailN = emailBuilderN.build();
        Assertions.assertEquals( subjectN, emailN.getSubject());
    }

    @Test
    public void testGetMessageValid(){
        emailP = emailBuilderP.build();
        Assertions.assertEquals( messageP, emailP.getMessage());
    }

    @Test
    public void testGetMessageNotValid(){
        emailN = emailBuilderN.build();
        Assertions.assertEquals( messageN, emailN.getMessage());
    }





}
