package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.kharkov.khpi.vinokurov.diploma.mapper.UserMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.UserRole;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.UserRepository;
import ua.kharkov.khpi.vinokurov.diploma.security.UserPrincipal;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${spring.admin.username:#{null}}")
    private String username;
    @Value("${spring.admin.password:#{null}}")
    private String password;
    @Value("${spring.admin.email:#{null}}")
    private String email;
    @Value("${spring.admin.name:#{null}}")
    private String name;
    @Value("${spring.admin.surname:#{null}}")
    private String surname;
    @Value("${spring.admin.phone:#{null}}")
    private String phone;

    @PostConstruct
    public void testAdminInit() {
        allHaveText(username, password, email, name, surname, phone)
                .map(value -> UserDto.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .surname(surname)
                        .name(name)
                        .phone(phone)
                        .role(UserRole.ADMIN)
                        .build())
                .ifPresent(this::addIfNotExist);
    }

    private UserDto addIfNotExist(UserDto userDto) {
        return findByUsername(userDto.getUsername())
                .orElseGet(() -> add(userDto));
    }

    private Optional<Boolean> allHaveText(String... strings) {
        return Objects.isNull(strings) ?
                Optional.of(false) :
                Arrays.stream(strings)
                        .map(StringUtils::hasText)
                        .reduce((bool1, bool2) -> bool1 && bool2);
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::entityToDto);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getById(long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToDto);
    }

    @Override
    public UserDto add(UserDto user) {
        if (Objects.isNull(user.getRole())) {
            user.setRole(UserRole.CUSTOMER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.entityToDto(
                userRepository.save(userMapper.dtoToEntity(user)));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto update(UserDto updatedUser) {
        return userMapper.entityToDto(
                userRepository.save(userMapper.dtoToEntity(updatedUser)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::entityToDto)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("No such username is present"));
    }
}
