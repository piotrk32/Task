package com.example.task.services;

import com.example.task.exceptions.EntityNotFoundException;
import com.example.task.models.star.Star;
import com.example.task.repositories.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarService {

    private final StarRepository starRepository;

    public Star getStarById(Long starId) {
        return starRepository.findById(starId)
                .orElseThrow(() -> new EntityNotFoundException("Star", "No star found with id: " + starId));
    }

    public List<Star> findClosestStars(int size) {
        List<Star> stars = starRepository.findAll();
        return stars.stream()
                .sorted(Comparator.comparingLong(Star::getDistance))
                .limit(size)
                .collect(Collectors.toList());
    }

    public Map<Long, Integer> getNumberOfStarsByDistances() {
        List<Star> stars = starRepository.findAll();
        return stars.stream()
                .collect(Collectors.groupingBy(
                        Star::getDistance,
                        TreeMap::new,
                        Collectors.collectingAndThen(Collectors.toList(), List::size)
                ));
    }

    public Collection<Star> getUniqueStars() {
        List<Star> stars = starRepository.findAll();
        Map<String, Star> uniqueStars = new HashMap<>();
        for (Star star : stars) {
            uniqueStars.putIfAbsent(star.getStarName(), star);
        }
        return uniqueStars.values();
    }

    public Star createStar(Star star) {
        return starRepository.save(star);
    }
    public void deleteStar(Long starId) {
        Star star = getStarById(starId);
        starRepository.delete(star);
    }
    public Star updateStar(Long starId, Star starDetails) {
        Star star = getStarById(starId);

        if (starDetails.getStarName() != null) {
            star.setStarName(starDetails.getStarName());
        }
        if (starDetails.getDistance() != null) {
            star.setDistance(starDetails.getDistance());
        }

        return starRepository.save(star);
    }



}
