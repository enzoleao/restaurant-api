package com.example.basicapi.auditing;

import com.example.basicapi.entity.User;
import com.example.basicapi.principal.UserPrincipal;
import lombok.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    @NullMarked
    public Optional<User> getCurrentAuditor() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || Objects.equals(auth.getPrincipal(), "anonymousUser")) {
            return Optional.empty();
        }

        if (!(auth.getPrincipal() instanceof UserPrincipal userPrincipal)) {
            return Optional.empty();
        }

        User user = new User();
        user.setId(userPrincipal.getId());

        return Optional.of(user);
    }
}