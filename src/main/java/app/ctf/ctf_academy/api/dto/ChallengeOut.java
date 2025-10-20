package app.ctf.ctf_academy.api.dto;

public record ChallengeOut(
    String slug,
    String title,
    String category,
    String difficulty,
    String descriptionMd,
    int pointsBase
) {}
