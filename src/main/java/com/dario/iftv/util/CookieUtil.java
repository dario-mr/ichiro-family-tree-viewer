package com.dario.iftv.util;

import com.dario.iftv.core.domain.AppCookie;
import com.vaadin.flow.server.VaadinRequest;
import jakarta.servlet.http.Cookie;

import java.util.Arrays;

public class CookieUtil {

    public static String getCookie(AppCookie appCookie) {
        return Arrays.stream(VaadinRequest.getCurrent().getCookies())
                .filter(cookie -> cookie.getName().equals(appCookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(appCookie.getDefaultValue());
    }
}
