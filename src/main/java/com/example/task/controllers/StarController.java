package com.example.task.controllers;

import com.example.task.models.star.Star;
import com.example.task.services.StarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stars")
@RequiredArgsConstructor
@Tag(name = "Star", description = "Controller for star management")
public class StarController {

    private final StarService starService;

    @Operation(summary = "Get a star by its ID", description = "Returns a single star")
    @GetMapping("/{starId}")
    public ResponseEntity<Star> getStarById(
            @Parameter(description = "ID of the Star to retrieve", required = true)
            @PathVariable Long starId) {

        Star star = starService.getStarById(starId);
        return ResponseEntity.ok(star);
    }

    @Operation(summary = "Create a new star", description = "Creates a new star and returns the created star")
    @PostMapping
    public ResponseEntity<Star> createStar(@RequestBody Star star) {
        Star starResponse = starService.createStar(star);
        return new ResponseEntity<>(starResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a star", description = "Deletes a star by its ID")
    @DeleteMapping("/{starId}")
    public ResponseEntity<Void> deleteStar(
            @Parameter(description = "ID of the Star to delete", required = true)
            @PathVariable Long starId) {
        starService.deleteStar(starId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update an existing star", description = "Updates a star's information by its ID")
    @PutMapping("/{starId}")
    public ResponseEntity<Star> updateStar(
            @Parameter(description = "ID of the Star to update", required = true)
            @PathVariable Long starId,
            @RequestBody Star starDetails) {
        Star updatedStar = starService.updateStar(starId, starDetails);
        return new ResponseEntity<>(updatedStar, HttpStatus.OK);
    }

    @Operation(summary = "Find the closest stars", description = "Returns a list of the closest stars to the sun")
    @GetMapping("/closest")
    public List<Star> findClosestStars(
            @Parameter(description = "Number of closest stars to retrieve", required = true)
            @RequestParam int size) {
        return starService.findClosestStars(size);
    }

    @Operation(summary = "Get the number of stars by distance", description = "Returns a map with distances as keys and the number of stars at each distance as values")
    @GetMapping("/distances")
    public Map<Long, Integer> getNumberOfStarsByDistances() {
        return starService.getNumberOfStarsByDistances();
    }

    @Operation(summary = "Get unique stars", description = "Returns a collection of unique stars by name")
    @GetMapping("/unique")
    public Collection<Star> getUniqueStars() {
        return starService.getUniqueStars();
    }
}
