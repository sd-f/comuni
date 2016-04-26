/*
 */
package foundation.softwaredesign.comuni.boundary.lib;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@XmlRootElement(name = "ask")
@XmlAccessorType(XmlAccessType.FIELD)
public class Question implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "question")
  private String questionText;

  /**
   * zero argument constructor for jaxb
   */
  public Question() {
    // zero argument constructor for jaxb
  }

  public Question(String question) {
    this.questionText = question;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

}
