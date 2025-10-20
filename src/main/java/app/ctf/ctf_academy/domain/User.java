package app.ctf.ctf_academy.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 255)
  private String email;

  @Column(name = "pass_hash", nullable = false, length = 255)
  private String passHash;

  @Column(nullable = false, length = 32)
  private String role = "student";

  // getters and setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getPassHash() { return passHash; }
  public void setPassHash(String passHash) { this.passHash = passHash; }

  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }

}
