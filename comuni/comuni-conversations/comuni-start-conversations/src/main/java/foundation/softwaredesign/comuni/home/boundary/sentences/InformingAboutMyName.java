/*
 */
package foundation.softwaredesign.comuni.home.boundary.sentences;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import foundation.softwaredesign.comuni.boundary.lib.annotation.Sentence;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Sentence
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InformingAboutMyName implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "my-name-is")
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
