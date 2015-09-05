/*
 */
package foundation.softwaredesign.comuni.gui;

import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;

import org.eclipse.jetty.proxy.ProxyServlet;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class ProxyPass extends ProxyServlet {

  private static final long serialVersionUID = 1L;

  private static int PORT_OUT = 8021;
  private String CONTAINS_PATH = "";

  @Override
  public void init() throws ServletException {
    PORT_OUT = new Integer(super.getInitParameter("portOut"));
    CONTAINS_PATH = super.getInitParameter("containsPath");
    super.init();
  }

  @Override
  protected String rewriteTarget(HttpServletRequest clientRequest) {
    String path = clientRequest.getRequestURI();
    if (path.contains(CONTAINS_PATH)) {

      String url = clientRequest.getRequestURL().toString();
      if (clientRequest.getServerPort() != 80) {
        throw new WebApplicationException("Only works on port 80");
      }
      StringBuilder uri = new StringBuilder("");
      uri.append(url.replace("/comuni-conversations", "").replace(clientRequest.getServerName(), clientRequest.getServerName() + ":" + PORT_OUT));

      String query = clientRequest.getQueryString();
      if (query != null) {
        uri.append("?").append(query);
      }
      URI rewrittenURI = URI.create(uri.toString()).normalize();
      return rewrittenURI.toString();
    }
    return super.rewriteTarget(clientRequest);
  }

}
