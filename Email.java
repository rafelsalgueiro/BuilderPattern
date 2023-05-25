
import java.util.ArrayList;
import java.util.List;

public final class Email {
    private final String from;
    private final List<String> to;
    private final String subject;
    private final String body;
    private final List<String> ccTo;

    public Email(
        String from, List<String> to, String subject, String body) {
        this(from, to, subject, body, new ArrayList<>());
    }
    public Email( String from, List<String> to, String subject, String body, List<String> ccTo) {
        this.from = from; 
        this.to = to; 
        this.subject = subject;
        this.body = body; 
        this.ccTo = ccTo;
    }

    public static EmailBuilder builder(){
        return new EmailBuilder();
    }
    
    @Override
    public String toString() {
        return "Email [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + ", ccTo=" + ccTo
                + "]";
    }

    
    
}
