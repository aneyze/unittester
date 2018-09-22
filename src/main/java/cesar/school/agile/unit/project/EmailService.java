package cesar.school.agile.unit.project;

import java.util.Collection;

public interface EmailService {

    public boolean sendEmail(Email email);

    Collection<Email> emailList(EmailAccount account);

}
