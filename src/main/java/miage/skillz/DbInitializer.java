package miage.skillz;

import miage.skillz.entity.ERole;
import miage.skillz.entity.Role;
import miage.skillz.entity.User;
import miage.skillz.repository.RoleRepository;
import miage.skillz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.AuthProvider;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("DB initializes...");
        List<Role> roles = roleRepository.findAll();
        List<User> users = userRepository.findAll();


        if(roles.isEmpty()){
            roleRepository.save(new Role(ERole.ROLE_CONCEPTEUR));
            roleRepository.save(new Role(ERole.ROLE_PARTICIPANT));
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
            System.out.println("--- Roles initialized");

        }

        if(users.isEmpty()){
            User admin = new User(
                    "admin", "admin@skillz.com",
                    encoder.encode("adminskillz")

            );

            Set<Role> newRole = new HashSet<>();
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            System.out.println("Role = " + adminRole.toString());
            newRole.add(adminRole);
            admin.setRoles(newRole);

            userRepository.save(admin);

            System.out.println("--- Admin user initialized");
        }


    }
}