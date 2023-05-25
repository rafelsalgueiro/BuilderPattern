import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;


public class EmailTest {

    Email email1 = Email.builder()
    .to("aasdf")
    .from("aaa")
    .subject("werafwer")
    .body("this is a body :)")
    .to("pepe")
    .ccTo("giemeno")
    .ccTo("giemenoMamaguevo")
    .make();


    @Test
    public void noReciver(){
        System.out.println(email1.toString());

        assertThrows( EmailBuilderException.class, () ->  Email.builder().from("a").subject("aaa").body("werafwer").make());
        
    }

    @Test
    public void noFrom(){
        assertThrows( EmailBuilderException.class, () ->  Email.builder().to("aasdf").subject("aaa").body("werafwer").from("vv").from("v1v").make());
    }

    @Test
    public void noSubject(){
        assertThrows( EmailBuilderException.class, () ->  Email.builder().to("aasdf").from("aaa").body("werafwer").make());
    }
    
    @Test
    public void noBody(){
        assertThrows( EmailBuilderException.class, () ->  Email.builder().to("aasdf").from("aaa").subject("werafwer").make());
    }

    @Test
    public void MoreThan1Reciver(){
        assertDoesNotThrow(() ->  Email.builder()
            .to("aasdf")
            .from("aaa")
            .subject("werafwer")
            .body("this is a body :)")
            .to("pepe")
            .make());
    }

    @Test
    public void MoreThan1ReciverAndccTo(){
        assertDoesNotThrow(() ->  Email.builder()
            .to("aasdf")
            .from("aaa")
            .subject("werafwer")
            .body("this is a body :)")
            .to("pepe")
            .ccTo("giemeno")
            .ccTo("giemenoMamaguevo")
            .make());
    }
}
