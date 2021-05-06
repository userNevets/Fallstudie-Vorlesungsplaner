package dhbw.vs.uniplaner.service;

import dhbw.vs.uniplaner.Custom_UniUserDetails;
import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.repository.UniUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class Custom_UniUserService implements UserDetailsService {
	
	@Autowired
	private UniUserRepository uniUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UniUser user = uniUserRepository.findByEmail(s);
		System.out.println(s.toString());
		return new Custom_UniUserDetails(user);
	}
	
}
