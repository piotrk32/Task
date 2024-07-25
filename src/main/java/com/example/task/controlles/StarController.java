package com.example.task.controlles;


import com.example.task.models.star.Star;
import com.example.task.services.StarService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stars")
@RequiredArgsConstructor
@Tag(name = "Star", description = "Controller for star management")
public class StarController {

    private final StarService starService;

    @GetMapping("/{starId}")
    public ResponseEntity<Star> getStarById(
            @Parameter(description = "ID of the Star to retrieve", required = true)
            @PathVariable Long starId) {

        Star rowRequest = starService.getStarById(starId);
        return ResponseEntity.ok(rowRequest);
    }

    @PostMapping
    public ResponseEntity<Star> createStar(@RequestBody Star star) {
        Star starResponse = starService.createStar(star);
        return new ResponseEntity<>(starResponse, HttpStatus.CREATED);
    }
}
