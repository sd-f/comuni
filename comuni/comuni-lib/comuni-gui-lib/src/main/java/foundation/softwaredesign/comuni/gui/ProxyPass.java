/*
 */
package foundation.softwaredesign.comuni.gui;

import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.proxy.ProxyServlet;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class ProxyPass extends ProxyServlet {

  private static final long serialVersionUID = 1L;

  private int portOut = 8021;
  private String containsPath = "";

  @Override
  public void init() throws ServletException {
    portOut = new Integer(super.getInitParameter("portOut"));
    containsPath = super.getInitParameter("containsPath");
    super.init();
  }

  @Override
  protected String rewriteTarget(HttpServletRequest clientRequest) {
    String path = clientRequest.getRequestURI();
    if (path.contains(containsPath)) {

      String url = clientRequest.getRequestURL().toString();
      if (clientRequest.getServerPort() != 80) {
        throw new RuntimeException("Only works on port 80");
      }
      StringBuilder uri = new StringBuilder("");
      uri.append(url.replace("/comuni-conversations", "").replace(clientRequest.getServerName(), clientRequest.getServerName() + ":" + portOut));

      String query = clientRequest.getQueryString();
      if (query != null) {
        uri.append("?").append(query);
      }
      URI rewrittenURI = URI.create(uri.toString()).normalize();
      System.out.println("Proxy redirect to " + rewrittenURI);
      return rewrittenURI.toString();
    }
    System.out.println("Proxy bypass");
    return super.rewriteTarget(clientRequest);
  }

}
