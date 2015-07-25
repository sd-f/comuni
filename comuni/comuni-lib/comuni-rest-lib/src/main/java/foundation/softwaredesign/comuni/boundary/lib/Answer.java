/*
 */
package foundation.softwaredesign.comuni.boundary.lib;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 * @param <T>
 */
@XmlRootElement
public class Answer<T> {

  @XmlElement(name = "sentences")
  public T sentences;

  @XmlElementWrapper(name = "you-can")
  @XmlAnyElement
  public List<Question> questions = new ArrayList<>();

  public Answer() {
  }

  public Answer(T sentences) {
    this.sentences = sentences;
  }

  public void addPossibleQuestion(Question question) {
    questions.add(question);
  }

}
