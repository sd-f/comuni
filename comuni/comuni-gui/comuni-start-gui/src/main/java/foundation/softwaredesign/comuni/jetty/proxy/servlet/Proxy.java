/*
 */
package foundation.softwaredesign.comuni.jetty.proxy.servlet;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.proxy.ProxyServlet;

/**
 * When a request cannot be satisfied on the local machine, it asynchronously proxied to the destination box. Define the
 * rule
 */
public class Proxy extends ProxyServlet {

  private static final long serialVersionUID = 1L;

  private int portOut = 8021;

  public void init() throws ServletException {
    super.init();
    portOut = new Integer(this.getInitParameter("RedirectPort"));
  }

  protected URI rewriteURI(HttpServletRequest request) {

    if (request.getRequestURI().contains("/comuni/r/")) {

    }

    String query = request.getQueryString();
    return URI.create(request.getQueryString().replace(request.getRemoteHost(), request.getRemoteHost() + ":" + portOut));
  }

}
