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

  private int port = 8021;
  private String path = "";
  private String replace = "";
  private String with = "";

  @Override
  public void init() throws ServletException {
    if (super.getInitParameter("portOut") != null) {
      port = new Integer(super.getInitParameter("portOut"));
    }
    if (super.getInitParameter("path") != null) {
      path = super.getInitParameter("path");
    }
    if (super.getInitParameter("replace") != null) {
      replace = super.getInitParameter("replace");
    }
    if (super.getInitParameter("with") != null) {
      with = super.getInitParameter("with");
    }
    super.init();
  }

  @Override
  protected String rewriteTarget(HttpServletRequest clientRequest) {
    String oldPath = clientRequest.getRequestURI();
    if (oldPath.contains(path)) {

      String url = clientRequest.getRequestURL().toString();
      if (clientRequest.getServerPort() != 80) {
        throw new WebApplicationException("Only works on port 80");
      }
      StringBuilder uri = new StringBuilder("");
      uri.append(url.replace(replace, with).replace(clientRequest.getServerName(), clientRequest.getServerName() + ":" + port));

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
