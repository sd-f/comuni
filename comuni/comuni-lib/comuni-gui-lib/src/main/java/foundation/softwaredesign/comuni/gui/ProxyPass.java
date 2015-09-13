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

  private static int PORT = 8021;
  private static String PATH = "";
  private static String REPLACE = "";
  private static String WITH = "";

  @Override
  public void init() throws ServletException {
    if (super.getInitParameter("portOut") != null) {
      PORT = new Integer(super.getInitParameter("portOut"));
    }
    if (super.getInitParameter("path") != null) {
      PATH = super.getInitParameter("path");
    }
    if (super.getInitParameter("replace") != null) {
      REPLACE = super.getInitParameter("replace");
    }
    if (super.getInitParameter("with") != null) {
      WITH = super.getInitParameter("with");
    }
    super.init();
  }

  @Override
  protected String rewriteTarget(HttpServletRequest clientRequest) {
    String oldPath = clientRequest.getRequestURI();
    if (oldPath.contains(PATH)) {

      String url = clientRequest.getRequestURL().toString();
      if (clientRequest.getServerPort() != 80) {
        throw new WebApplicationException("Only works on port 80");
      }
      StringBuilder uri = new StringBuilder("");
      uri.append(url.replace(REPLACE, WITH).replace(clientRequest.getServerName(), clientRequest.getServerName() + ":" + PORT));

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
