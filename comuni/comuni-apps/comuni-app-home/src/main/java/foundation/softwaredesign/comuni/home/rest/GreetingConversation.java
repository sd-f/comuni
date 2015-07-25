/*
 */
package foundation.softwaredesign.comuni.home.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import foundation.softwaredesign.comuni.boundary.lib.Answer;
import foundation.softwaredesign.comuni.boundary.lib.Question;
import foundation.softwaredesign.comuni.home.boundary.SystemInfoService;
import foundation.softwaredesign.comuni.home.boundary.sentences.MyNameIsSentence;
import foundation.softwaredesign.comuni.home.boundary.sentences.WelcomeSentence;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Path("/")
@RequestScoped
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class GreetingConversation {

  @Inject
  SystemInfoService systemInformationService;

  @GET
  @Path("/hello")
  public Answer<WelcomeSentence> hello() {
    WelcomeSentence sentence = new WelcomeSentence(systemInformationService.getSystemInformation().getWelcomeMessage());
    Answer<WelcomeSentence> answer = new Answer<>(sentence);
    answer.addPossibleQuestion(new Question("/what/is/your/name"));
    return answer;
  }

  @GET
  @Path("/what/is/your/name")
  public Answer<MyNameIsSentence> whatIsYourName() {
    MyNameIsSentence sentence = new MyNameIsSentence(systemInformationService.getSystemInformation().getName());
    Answer<MyNameIsSentence> answer = new Answer<>(sentence);
    answer.addPossibleQuestion(new Question("/hello/again"));
    return answer;
  }

  @GET
  @Path("/hello/again")
  public Answer<WelcomeSentence> helloAgain() {
    return this.hello();
  }

}
