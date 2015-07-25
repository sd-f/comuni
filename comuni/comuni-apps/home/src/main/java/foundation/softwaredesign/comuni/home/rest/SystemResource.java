/*
 */
package foundation.softwaredesign.comuni.home.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import foundation.softwaredesign.comuni.home.boundary.SystemDto;
import foundation.softwaredesign.comuni.home.control.SystemService;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Path("/")
@RequestScoped
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class SystemResource {

  @Inject
  SystemService service;

  @GET
  @Path("ping")
  public String ping() {
    return "pong";
  }

  @GET
  @Path("check")
  public SystemDto check() {
    return service.getSystemInfo();
  }

}
