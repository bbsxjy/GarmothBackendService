package com.gbs.core.controller;

import com.gbs.core.interfase.GuideRepository;
import com.gbs.core.model.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
