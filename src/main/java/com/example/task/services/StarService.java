package com.example.task.services;

import com.example.task.models.star.Star;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarService {

    public List<Star> findClosestStars(List<Star> stars, int size) {
        return stars.stream()
                .sorted(Comparator.comparingLong(Star::getDistance))
                .limit(size)
                .collect(Collectors.toList());
    }
}
