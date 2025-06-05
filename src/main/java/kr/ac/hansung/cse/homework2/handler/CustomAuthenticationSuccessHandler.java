package kr.ac.hansung.cse.homework2.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String email = authentication.getName(); // email로 로그인하는 구조
        String message = email + " 님, 환영합니다!";
        response.sendRedirect("/products?success&email=" + URLEncoder.encode(email, "UTF-8") +
                "&message=" + URLEncoder.encode(message, "UTF-8"));
    }
}
