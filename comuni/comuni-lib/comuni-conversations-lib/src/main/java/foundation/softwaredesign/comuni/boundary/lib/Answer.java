/*
 */
package foundation.softwaredesign.comuni.boundary.lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * @param <T>
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer<T extends Serializable> implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElementWrapper(name = "sentences")
  @XmlAnyElement
  public List<T> sentences = new ArrayList<>();

  @XmlElementWrapper(name = "you-can")
  @XmlAnyElement
  public List<Question> questions = new ArrayList<>();

  /**
   * zero argument constructor for jaxb
   */
  public Answer() {
    // zero argument constructor for jaxb
  }

  public void addPossibleQuestion(Question question) {
    this.questions.add(question);
  }

  public void addSentence(T sentence) {
    this.sentences.add(sentence);
  }

}
