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

  public List<ChallengeOut> listPublished() {
        List<Challenge> entities = challengeRepository.findByPublishedTrueOrderByIdAsc();
        List<ChallengeOut> result = new ArrayList<>(entities.size());
        for (Challenge ch : entities) {
            result.add(new ChallengeOut(ch));
        }
        return result;
    }

public SubmitRes submitFlag(String slug, SubmitReq req) {
    if (req == null || req.getFlag() == null) {
        return new SubmitRes(false, null);
    }
    String submitted = req.getFlag().trim();
    Challenge ch = challengeRepository.findBySlug(slug).orElseThrow();
    boolean correct = submitted.equals(ch.getFlagStatic());
    return correct
            ? new SubmitRes(true, ch.getPointsBase())
            : new SubmitRes(false, null);
}


    public Challenge getBySlug(String slug){
         return challengeRepository.findBySlug(slug).get();
        
    }
}
