/*
 */
package foundation.softwaredesign.comuni.home.boundary.sentences;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import foundation.softwaredesign.comuni.boundary.lib.annotation.Sentence;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Sentence
@XmlRootElement
public class ProposingWelcome {

  @XmlElement(name = "hello")
  private String welcomeMessage;

  public ProposingWelcome() {
  }

  public ProposingWelcome(String welcomeMessage) {
    this.welcomeMessage = welcomeMessage;
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public void setWelcomeMessage(String welcomeMessage) {
    this.welcomeMessage = welcomeMessage;
  }

}
