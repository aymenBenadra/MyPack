package ma.youcode.mypack.helpers;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;

public class SessionManager {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSession(false);
    }

    public static Object getAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public static void setAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static boolean removeAttribute(String key) {
        try {
            getSession().removeAttribute(key);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
