package fi.hh.Wikidemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.hh.Wikidemo.domain.User;
import fi.hh.Wikidemo.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userrepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userrepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User currentuser = userrepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(currentuser.getRole()));
		return user;
	}
	
}
