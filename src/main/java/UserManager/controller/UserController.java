package UserManager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import UserManager.model.User;
import UserManager.service.UserService;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.StringJoiner;

@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    public static final String REST_URL = "/rest/users";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id) {
        LOGGER.info("get");
        return service.get(id);
    }

    @GetMapping
    public List<User> getAll() {
        LOGGER.info("getAll");
        return service.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        LOGGER.info("update");
        service.update(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@RequestBody User user) {
        LOGGER.info("create");
        User created = service.save(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdate(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        LOGGER.info("createOrUpdate");

        if (user.isNew()) {
            service.save(user);
        } else {
            service.update(user);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static ResponseEntity<String> getErrorResponse(BindingResult result) {
        StringJoiner joiner = new StringJoiner("<br>");
        result.getFieldErrors().forEach(
                fe -> {
                    String message = fe.getDefaultMessage();
                    if (!message.startsWith(fe.getField())) {
                        message = fe.getField() + ' ' + message;
                    }
                    joiner.add(message);
                });
        return new ResponseEntity<>(joiner.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
