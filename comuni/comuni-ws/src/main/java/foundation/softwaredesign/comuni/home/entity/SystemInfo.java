package foundation.softwaredesign.comuni.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Entity
@Table
public class SystemInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column
  private String name;

  @Column
  private String welcomeMessage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public void setWelcomeMessage(String welcomeMessage) {
    this.welcomeMessage = welcomeMessage;
  }

}
