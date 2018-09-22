package cesar.school.agile.unit.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestEmailService {

    @Mock EmailService emailService;

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

    private EmailBuilder emailBuilderV;
    private EmailBuilder emailBuilderN;
    private EmailClient emailClient;
    private Email emailV;
    private Email emailN;

    @BeforeEach
    public void setUp(){
        emailClient = new EmailClient();
        emailClient.setEmailService( emailService );
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

    }

    @Test
    public void sendEmail_emailServiceIsTrue_true(){
        emailV = emailBuilderV.build();
        when(emailService.sendEmail(any(Email.class) )).thenReturn(true);
        assertDoesNotThrow(()->emailClient.sendEmail( emailV));
    }

    @Test
    public void sendEmail_emailServiceIsTrue_false() throws RuntimeException{
        emailN = emailBuilderN.build();
        when(emailService.sendEmail(any(Email.class) )).thenReturn(false);
        Assertions.assertThrows(RuntimeException.class,()->emailClient.sendEmail( emailN));
    }


}