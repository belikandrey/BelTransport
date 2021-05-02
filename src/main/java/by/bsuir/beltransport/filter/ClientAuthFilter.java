package by.bsuir.beltransport.filter;

import by.bsuir.beltransport.entity.Client;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** The type Client auth filter. */
@WebFilter("/client/*")
public class ClientAuthFilter extends HttpFilter {
  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    final HttpSession session = request.getSession();
    final Client client = (Client) session.getAttribute("client");
    if (client == null) {
      final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
      request.setAttribute("message", "You must log in before start");
      requestDispatcher.forward(request, response);
    }
    chain.doFilter(request, response);
  }
}
