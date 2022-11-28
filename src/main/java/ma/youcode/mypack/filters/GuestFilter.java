package ma.youcode.mypack.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import ma.youcode.mypack.services.interfaces.IAuthService;

import java.io.IOException;

@WebFilter(filterName = "GuestFilter")
public class GuestFilter implements Filter {

    @Inject
    private IAuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;

        if (authService.isLoggedIn()) {
            res.sendError(403, "You are already logged in");
        } else {
            chain.doFilter(request, response);
        }
    }
}
