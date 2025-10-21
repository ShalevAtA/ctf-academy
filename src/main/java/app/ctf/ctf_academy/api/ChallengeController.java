package app.ctf.ctf_academy.api;

import app.ctf.ctf_academy.api.dto.ChallengeOut;
import app.ctf.ctf_academy.api.dto.SubmitReq;
import app.ctf.ctf_academy.api.dto.SubmitRes;
import app.ctf.ctf_academy.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService service;

    public ChallengeController(ChallengeService service) {
        this.service = service;
    }

    // GET  "/api/challenges/"
    @GetMapping("/")
    public List<ChallengeOut> list() {
        return service.listPublished();
    }

    // GET "/api/challenges/{slug}"
    @GetMapping("/{slug}")
    public ChallengeOut get(@PathVariable String slug) {
        try {
            return new ChallengeOut(service.getBySlug(slug));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Challenge wasnt found");
        }
    }

    // POST "/api/challenges/{slug}/submit"
    @PostMapping("/{slug}/submit")
    public SubmitRes submit(@PathVariable String slug, @RequestBody SubmitReq body) {
        try {
            return service.submitFlag(slug, body);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Challenge not found");
        }
    }
}
