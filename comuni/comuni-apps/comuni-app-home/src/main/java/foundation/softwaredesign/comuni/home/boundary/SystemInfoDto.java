/*
 */
package foundation.softwaredesign.comuni.home.boundary;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class SystemInfoDto {

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
