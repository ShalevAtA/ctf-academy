package app.ctf.ctf_academy.domain;
import jakarta.persistence.*;
@Entity
@Table(name = "challenges")
public class Challenge {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 100)
  private String slug;

  @Column(nullable = false, length = 200)
  private String title;

  @Column(nullable = false, length = 50)
  private String category;

  @Column(nullable = false, length = 20)
  private String difficulty;

  @Column(name = "description_md", nullable = false, columnDefinition = "TEXT")
  private String descriptionMd;

  @Column(name = "flag_static", nullable = false, length = 255)
  private String flagStatic;

  @Column(nullable = false)
  private boolean published = true;

  @Column(name = "points_base", nullable = false)
  private int pointsBase = 100;

  //getters and setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getSlug() { return slug; }
  public void setSlug(String slug) { this.slug = slug; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public String getDifficulty() { return difficulty; }
  public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

  public String getDescriptionMd() { return descriptionMd; }
  public void setDescriptionMd(String descriptionMd) { this.descriptionMd = descriptionMd; }

  public String getFlagStatic() { return flagStatic; }
  public void setFlagStatic(String flagStatic) { this.flagStatic = flagStatic; }

  public boolean isPublished() { return published; }
  public void setPublished(boolean published) { this.published = published; }

  public int getPointsBase() { return pointsBase; }
  public void setPointsBase(int pointsBase) { this.pointsBase = pointsBase; }

}
