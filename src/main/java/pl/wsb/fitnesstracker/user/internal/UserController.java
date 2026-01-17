package pl.wsb.fitnesstracker.user.internal;

import jakarta.websocket.MessageHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.exception.api.NotFoundException;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserSimpleDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 * It provides endpoints for retrieving and creating users.
 */
@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    public UserController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/simple")
    public List<UserSimpleDto> getAllUsersSimple() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toSimpleDto)
                .toList();

    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {

        Optional<User> dto = userService.getUser(id);
        if (dto.isPresent()) {
            return userMapper.toDto(dto.get());
        }

        throw new NotFoundException("Id not found");
    }

    @GetMapping("/email")
    public List<UserDto> getUserByEmail(@RequestParam("email") String email) {
        Optional<User> dto = userService.getUserByEmail(email);
        if (dto.isPresent()) {
            return dto.stream().map(userMapper::toDto).toList();
        }

        throw new NotFoundException("Email not found");
    }

    @GetMapping("/older/{time}")
    public List<UserDto> getUsersOlderThan(@PathVariable LocalDate time) {
        return userService.getUsersOlderThan(time).stream().map(userMapper::toDto).toList();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.toEntity(userDto));
        return ResponseEntity.status(201).body(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dropUser(@PathVariable Long id) {
        userService.dropUser(id);
    }

    @PutMapping("/{target}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long target) {
        userService.updateUser(userMapper.toEntity(userDto), target);
    }
}

