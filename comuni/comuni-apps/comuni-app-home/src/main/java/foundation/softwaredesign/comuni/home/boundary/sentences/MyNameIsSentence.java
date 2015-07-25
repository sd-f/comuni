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
public class MyNameIsSentence {

  @XmlElement(name = "my-name-is")
  private String name;

  public MyNameIsSentence() {
  }

  public MyNameIsSentence(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
