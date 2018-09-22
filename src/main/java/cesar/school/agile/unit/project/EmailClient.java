package cesar.school.agile.unit.project;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailClient{

    public static final String SENHA_INVÁLIDA = "Senha inválida";
    private Collection<EmailAccount> accounts;

    private EmailService emailService;

    public void setAccounts(Collection<EmailAccount> accounts) {
        this.accounts = accounts;
    }

    public void setEmailService(EmailService emailS) {
        emailService = emailS;
    }


    public boolean isValidAddress(String emailAddress){
        boolean isEmailIdValid = false;
        if (emailAddress != null ) {
            String expression = "^[A-Za-z0-9_.-]{3,16}+@[a-zA-Z0-9][a-zA-Z0-9-]{1,61}[a-zA-Z0-9]\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailAddress);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;

    }



    public boolean isValidEmail(Email email){

        boolean v1=false;
        boolean v2=false;
        boolean v3=false;
        boolean v4=false;
        boolean v5=false;
        boolean v6=false;
        boolean v7=false;
        if(email.getCreationDate()!=null){
            v1=true;
        }
        else{
            v1=false;
        }
        if(this.isValidAddress(email.getFrom())){
            v2=true;
        }
        else{
            v2=false;
        }

        if(email.getSubject()!=null){
            v6=true;
        }
        else{
            v6=false;
        }
        if(email.getMessage()!=null){
            v7=true;
        }
        else{
            v7=false;
        }

        for (String s : email.getCc()) {
            if (this.isValidAddress( s )) {
                v3 = true;
            }
            else{
                v3 = false;
            }
        }

        for (String s : email.getTo()) {
            if (this.isValidAddress( s )) {
                v4 = true;
            }
            else{
                v4=false;
            }
        }

        for (String s : email.getBcc()) {
            if (this.isValidAddress( s )) {
                v5 = true;
            }
            else{
                v5=false;
            }
        }
        return v1&&v2&&v3&&v4&&v5&&v6&&v7;
    }



    public Collection<Email> emailList(EmailAccount account){
        Collection <Email> arrayEmail = new ArrayList<Email>( );
        Email email = new Email();
        emailService = new EmailService() {
            @Override
            public boolean sendEmail(Email email) {
                return false;
            }

            @Override
            public Collection<Email> emailList(EmailAccount account) {
                return null;
            }
        };
        if(account.isPasswordValid() && account.verifyPasswordExpiration()){
            arrayEmail.add(email);
            emailService.emailList( account );
            return emailService.emailList( account );
        }
        else{
            throw new RuntimeException( SENHA_INVÁLIDA );
        }

    }

    public boolean createAccount(EmailAccount account){
        boolean v1 = false;
        boolean v2 = false;
        boolean v3 = false;
        if(account.isUserValid()){
            v1=true;
        }
        else{
            v1=false;
        }
        if(account.isDomainValid()){
            v2=true;
        }
        else{
            v2=false;
        }
        if(account.isPasswordValid()){
            v3=true;
        }
        else{
            v3=false;
        }

        //setando o campo LastPasswordUpdate com a data atual
        account.setLastPasswordUpdate( LocalDate.now() );

        //adicionando objeto a coleção accounts
        Collection<EmailAccount> acc = new ArrayList<EmailAccount>();
        acc.add( account );

        boolean b = v1 && v2 && v3;
        return b;
    }

    public void sendEmail(Email email) {
        EmailClient cli = new EmailClient();
        if (cli.isValidEmail( email )) {
            EmailService service = new EmailService() {
                @Override
                public boolean sendEmail(Email email) {
                    return true;
                }

                @Override
                public Collection<Email> emailList(EmailAccount account) {
                    return null;
                }
            };
            service.sendEmail( email );
        }
            else {
                throw new RuntimeException( "Return false!" );
            }

        }


}