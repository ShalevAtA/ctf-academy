package app.ctf.ctf_academy.api.dto;

import app.ctf.ctf_academy.domain.Challenge;

public class ChallengeOut {
    private final String slug;
    private final String title;
    private final String category;
    private final String difficulty;
    private final String descriptionMd;
    private final int pointsBase;

    public ChallengeOut(String slug, String title, String category, String difficulty,
                        String descriptionMd, int pointsBase) {
        this.slug = slug;
        this.title = title;
        this.category = category;
        this.difficulty = difficulty;
        this.descriptionMd = descriptionMd;
        this.pointsBase = pointsBase;
    }

    public ChallengeOut(Challenge ch) {
        this(ch.getSlug(), ch.getTitle(), ch.getCategory(), ch.getDifficulty(),
             ch.getDescriptionMd(), ch.getPointsBase());
    }

    public String getSlug() { return slug; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDifficulty() { return difficulty; }
    public String getDescriptionMd() { return descriptionMd; }
    public int getPointsBase() { return pointsBase; }
}
