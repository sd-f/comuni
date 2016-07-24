/*
 */
package foundation.softwaredesign.comuni.home.boundary.sentences;

import foundation.softwaredesign.comuni.lib.boundary.AbstractSentence;
import foundation.softwaredesign.comuni.lib.boundary.annotation.Sentence;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Sentence
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProposingWelcome extends AbstractSentence implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "hello")
  private String welcomeMessage;

  /**
   * zero argument constructor for jaxb
   */
  public ProposingWelcome() {
    // zero argument constructor for jaxb
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
