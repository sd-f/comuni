/*
 */
package foundation.softwaredesign.comuni.home.boundary.sentences;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import foundation.softwaredesign.comuni.boundary.lib.annotation.Sentence;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Sentence
@XmlRootElement
public class ProposingWelcome implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "hello")
  private String welcomeMessage;

  /**
   * zero argument constructor for jaxb
   */
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
