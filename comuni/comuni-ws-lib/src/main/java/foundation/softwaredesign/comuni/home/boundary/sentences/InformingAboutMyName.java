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
public class InformingAboutMyName extends AbstractSentence implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "myNameIs")
  private String name;

  /**
   * zero argument constructor for jaxb
   */
  public InformingAboutMyName() {
    // zero argument constructor for jaxb
  }

  public InformingAboutMyName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
