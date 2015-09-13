/*
 */
package foundation.softwaredesign.comuni.boundary.lib;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@XmlRootElement(name = "ask")
public class Question {

  @XmlElement(name = "question")
  private String questionText;

  public Question() {
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
