package dhbw.vs.uniplaner;

import dhbw.vs.uniplaner.domain.UniUser;
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
		return uniUser.getPassword();
	}
	
	@Override
	public String getUsername() {
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
