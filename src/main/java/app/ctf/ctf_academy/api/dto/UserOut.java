package app.ctf.ctf_academy.api.dto;

import java.time.Instant;
import java.util.List;

public class UserOut {
    private Long id;
private String username;
private List<String> roles; 
private Instant createdAt;


public UserOut() { }
public UserOut(Long id, String username, List<String> roles, Instant createdAt) {
this.id = id; this.username = username; this.roles = roles; this.createdAt = createdAt;
}


public Long getId() { return id; }
public String getUsername() { return username; }
public List<String> getRoles() { return roles; }
public Instant getCreatedAt() { return createdAt; }


public void setId(Long id) { this.id = id; }
public void setUsername(String username) { this.username = username; }
public void setRoles(List<String> roles) { this.roles = roles; }
public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

}
