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
        Star star = starRepository.findById(starId)
                .orElseThrow(() -> new EntityNotFoundException("Item", "No item found with id: " + starId));
        return star;
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
            uniqueStars.putIfAbsent(star.getItemName(), star);
        }
        return uniqueStars.values();
    }
}
