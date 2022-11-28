package ma.youcode.mypack.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.mypack.services.interfaces.IAuthService;

import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter")
public class AuthorizationFilter implements Filter {

    @Inject
    private IAuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String pathInfo = req.getPathInfo(); // /{action}
        String[] pathParts = pathInfo.split("/");
        String action = pathParts[1];

        switch (authService.getCurrentUser().getClass().getSimpleName()) {
            case "ClientEntity" -> {
                if (action.equals("/client")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendError(403, "You are not authorized to access this page");
                }
            }
            case "AdminEntity" -> {
                if (action.equals("/admin")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendError(403, "You are not authorized to access this page");
                }
            }
            case "ManagerEntity" -> {
                if (action.equals("/manager")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendError(403, "You are not authorized to access this page");
                }
            }
        }
    }
}
