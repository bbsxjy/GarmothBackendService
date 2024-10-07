package com.gbs.core.controller;

import com.gbs.core.datastore.GuideRepository;
import com.gbs.core.model.Guide;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/v1/guides")
public class GuideController {

    @Autowired
    private GuideRepository guideRepository;

    // Get all guides
    @GetMapping
    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    // Get a single guide by ID
    @GetMapping("/{id}")
    public Optional<Guide> getGuideById(@PathVariable String id) {
        return guideRepository.findById(id);
    }

    // Insert a new guide
    @PostMapping
    public Guide createGuide(@RequestBody Guide guide) {
        return guideRepository.save(guide);
    }

    // Update an existing guide
    @PutMapping("/{id}")
    public Guide updateGuide(@PathVariable String id, @RequestBody Guide guideDetails) {
        Optional<Guide> optionalGuide = guideRepository.findById(id);

        log.info("Updating exsiting guide.");

        if (optionalGuide.isPresent()) {
            Guide guide = optionalGuide.get();
            guide.setTitle(guideDetails.getTitle());
            guide.setDesc(guideDetails.getDesc());
            guide.setText(guideDetails.getText());
            guide.setLikes(guideDetails.getLikes());
            guide.setViews(guideDetails.getViews());
            guide.setPublished_at(guideDetails.getPublished_at());
            guide.setModified_at(guideDetails.getModified_at());
            guide.setAvatar(guideDetails.getAvatar());
            guide.setImg(guideDetails.getImg());
            guide.setFk_category(guideDetails.getFk_category());

            return guideRepository.save(guide);
        } else {
            throw new RuntimeException("Guide not found with id: " + id);
        }
    }

    // Delete a guide by ID
    @DeleteMapping("/{id}")
    public void deleteGuide(@PathVariable String id) {
        guideRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Guide> updateGuidePartially(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        Optional<Guide> optionalGuide = guideRepository.findById(id);

        if (optionalGuide.isPresent()) {
            Guide guide = optionalGuide.get();

            // Apply the updates to the guide (you can add more fields as necessary)
            updates.forEach((key, value) -> {
                switch (key) {
                    case "title":
                        guide.setTitle((String) value);
                        break;
                    case "desc":
                        guide.setDesc((String) value);
                        break;
                    case "listing":
                        guide.setListing((Boolean) value);
                        break;
                    case "incViews":
                        if ((Boolean) value) {
                            guide.setViews(guide.getViews() + 1);
                        }
                        break;
                }
            });

            guideRepository.save(guide);
            return ResponseEntity.ok(guide);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Guide> getGuideByTitle(@PathVariable String title) {
        Optional<Guide> optionalGuide = guideRepository.findByTitle(title);

        return optionalGuide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
