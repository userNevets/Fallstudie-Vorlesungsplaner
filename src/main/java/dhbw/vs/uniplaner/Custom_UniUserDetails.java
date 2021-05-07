package dhbw.vs.uniplaner;

import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.repository.UniUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Custom_UniUserDetails  implements UserDetails {
	private UniUser uniUser;
	
	
	public Custom_UniUserDetails(UniUser uniUser) {
		this.uniUser = uniUser;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		System.out.println(uniUser.getPassword());
		return uniUser.getPassword();
	}
	
	@Override
	public String getUsername() {
		System.out.println(uniUser.getemail());
		return uniUser.getemail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		return false;
	}
}
