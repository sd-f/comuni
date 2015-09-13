/*
 */
package foundation.softwaredesign.comuni.home.boundary;

import java.io.Serializable;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class SystemInfoDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

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
