package sn.ipd.gestionscolaire.controller;
import sn.ipd.gestionscolaire.model.User;
import sn.ipd.gestionscolaire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User u = userRepository.findByUsername(user.getUsername());
        if(u != null && u.getPassword().equals(user.getPassword())) {
            return "Login reussi - Bienvenue " + u.getRole();
        }
        return "Echec de connexion";
    }
}