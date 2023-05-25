import java.util.ArrayList;
import java.util.List;

public class EmailBuilder {

    private String from;
    private List<String> to = new ArrayList<>();
    private String subject;
    private String body;
    private List<String> ccTo = new ArrayList<>();

    public EmailBuilder from(String from){
        if (this.from != null){
            throw new EmailBuilderException("Only one sender");
        }
        this.from = from;
        return this;    
    }

    public EmailBuilder to(String to){
        this.to.add(to);
        return this;    
    }

    public EmailBuilder subject(String subject){
        if (this.subject != null){
            throw new EmailBuilderException("Only one subject");
        }
        this.subject = subject;
        return this;    
    }

    public EmailBuilder body(String body){
        if (this.body != null){
            throw new EmailBuilderException("Only one body");
        }
        this.body = body;
        return this;    
    }

    public EmailBuilder ccTo(String ccTo){
        this.ccTo.add(ccTo);
        return this;    
    }

    public Email make(){
        if (to == null || to.size() < 1 || to.isEmpty() ){
            throw new EmailBuilderException("Needed at least 1 reciver");
        }
        if (from == null || from.isEmpty()){
            throw new EmailBuilderException("From can't be null");
        }
        if (subject == null || subject.isEmpty()){
            throw new EmailBuilderException("Subject can't be null");
        }
        if (body == null || body.isEmpty()){
            throw new EmailBuilderException("Body can't be null");
        }
        return new Email(from, to, subject, body, ccTo);
    }

    @Override
    public String toString() {
        return "EmailBuilder [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + ", ccTo="
                + ccTo + "]";
    }
    
    
}
