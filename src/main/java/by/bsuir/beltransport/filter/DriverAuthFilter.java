package by.bsuir.beltransport.filter;

import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Status;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/driver/*")
public class DriverAuthFilter extends HttpFilter {
  @Override
  protected void doFilter(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    final HttpSession session = request.getSession();
    final Driver driver = (Driver) session.getAttribute("driver");
    if (driver == null || driver.getStatus().equals(Status.BANNED)) {
      String message = driver == null ? "You must log in before start" : "You are banned";
      final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
      request.setAttribute("message", message);
      requestDispatcher.forward(request, response);
    }
    chain.doFilter(request, response);
  }
}
