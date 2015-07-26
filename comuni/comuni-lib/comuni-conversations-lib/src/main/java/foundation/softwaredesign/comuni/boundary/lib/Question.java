/*
 */
package foundation.softwaredesign.comuni.boundary.lib;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@XmlRootElement(name = "ask")
public class Question {

  private String question;

  public Question() {
  }

  public Question(String question) {
    this.question = question;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

}
