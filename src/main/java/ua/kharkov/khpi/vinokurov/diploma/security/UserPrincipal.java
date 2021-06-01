package ua.kharkov.khpi.vinokurov.diploma.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.UserRole;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {
    private static final Map<UserRole, List<GrantedAuthority>> authoritiesMap;
    private final UserDto user;

    static {
        authoritiesMap = new EnumMap<>(UserRole.class);
        authoritiesMap.put(UserRole.CUSTOMER, Collections.singletonList(UserAccessLevel.CUSTOMER::toString));
        authoritiesMap.put(UserRole.ADMIN, Arrays.asList(UserAccessLevel.CUSTOMER::toString, UserAccessLevel.ADMIN::toString));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritiesMap.get(user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public long getId() {
        return user.getId();
    }

    public boolean isAdmin() {
        return UserRole.ADMIN.equals(user.getRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
