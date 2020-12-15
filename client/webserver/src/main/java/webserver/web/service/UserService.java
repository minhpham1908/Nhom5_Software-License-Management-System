package webserver.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.util.Assert;
import webserver.web.model.MyUserDetails;
import yuhnim.client.Client;
import yuhnim.rmi.model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailService")
public class UserService implements UserDetailsService {
    @Autowired
    Client client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        User user = null;
//        UserBuilder builder = null;
        try {
            user = findUserByUserName(username);
//            builder = org.springframework.security.core.userdetails.User.withUsername(user.getName());
//            builder.password(user.getEncryptedPassword());
//            builder.roles("USER");
            System.out.println(user);
        } catch (RemoteException e) {
            System.out.println("REMOTE EXCEPTION: " + e.toString());
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("NOT BOUND EXCEPTION: " + e.toString());
            e.printStackTrace();
        }
        MyUserDetails myUserDetails = new MyUserDetails(user.getID(), user.getName(), user.getEncryptedPassword(), new ArrayList(dumbGetRoles("USER")));
        return myUserDetails;
    }

    private User findUserByUserName(String userName) throws RemoteException, NotBoundException {
        return client.getUserByUsername(userName);
    }

    private List<GrantedAuthority> dumbGetRoles(String... roles) {
        List<GrantedAuthority> authorities = new ArrayList(roles.length);
        String[] var3 = roles;
        int var4 = roles.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String role = var3[var5];
            Assert.isTrue(!role.startsWith("ROLE_"), () -> {
                return role + " cannot start with ROLE_ (it is automatically added)";
            });
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }
}
