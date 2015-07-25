/*
 */
package foundation.softwaredesign.comuni.home.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import foundation.softwaredesign.comuni.home.boundary.SystemInformation;
import foundation.softwaredesign.comuni.home.boundary.SystemInformationService;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Path("/")
@RequestScoped
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class GreetingConversation {

  @Inject
  SystemInformationService systemInformationService;

  @GET
  @Path("hello")
  public SystemInformation hello() {
    return systemInformationService.getSystemInformation();
  }

}
