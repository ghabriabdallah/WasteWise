package codadoor.pfe.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import codadoor.pfe.repository.UserRepository;
import codadoor.pfe.entity.User;


public class GroupUserDetailsService implements UserDetailsService{
    
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<User>	user = Optional.of(repository.findByUsername(username));
		return user.map(GroupUserDetails::new).orElseThrow();
	}

}

