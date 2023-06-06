package az.atl.demosecurity.controller;

import az.atl.demosecurity.model.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/security")
@Slf4j
public class SecurityController {

    @GetMapping("/test")
    public ResponseDTO getTest() {
        return new ResponseDTO("Hello world");
    }

    @GetMapping("/login")
    public ResponseDTO getLogin() {
        return new ResponseDTO("Login Page");
    }

    @GetMapping("/admin")
    public ResponseDTO getAdmin(Principal principal) {
        return new ResponseDTO("Hello " + principal.getName());
    }

    @GetMapping("/user")
    public ResponseDTO getUser(Principal principal) {
        return new ResponseDTO("Hello " + principal.getName());
    }

    @PostMapping("/post")
    public ResponseDTO setPost(@RequestBody ResponseDTO responseDTO) {
        return responseDTO;
    }
}
