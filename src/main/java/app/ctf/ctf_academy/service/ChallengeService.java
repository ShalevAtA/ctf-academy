package app.ctf.ctf_academy.service;

import app.ctf.ctf_academy.domain.Challenge;
import app.ctf.ctf_academy.repo.ChallengeRepo;
import app.ctf.ctf_academy.api.dto.ChallengeOut;
import app.ctf.ctf_academy.api.dto.SubmitReq;
import app.ctf.ctf_academy.api.dto.SubmitRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private final ChallengeRepo challengeRepository;

    public ChallengeService(ChallengeRepo challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

  public List<ChallengeOut> listPublishedClassic() {
        List<Challenge> entities = challengeRepository.findByPublishedTrueOrderByIdAsc();
        List<ChallengeOut> result = new ArrayList<>(entities.size());
        for (Challenge ch : entities) {
            result.add(new ChallengeOut(ch));
        }
        return result;
    }

    public SubmitRes submitFlag(SubmitReq req) {
        Challenge challenge = challengeRepository.findBySlug(req.getSlug())
                .orElseThrow(() -> new RuntimeException("coukldnt find challenge"));
        boolean correct = challenge.getFlagStatic().equals(req.getFlag());
        return new SubmitRes(correct, challenge.getPointsBase());
    }
}
