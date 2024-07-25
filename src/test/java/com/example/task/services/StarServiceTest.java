package com.example.task.services;

import com.example.task.models.star.Star;
import com.example.task.repositories.StarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StarServiceTest {

    @Mock
    private StarRepository starRepository;
    @InjectMocks
    private StarService starService;
    private List<Star> starList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        starList = new ArrayList<>();
        starList.add(createStar("Mars", 4L));
        starList.add(createStar("Earth", 6L));
        starList.add(createStar("Uranus", 8L));
        starList.add(createStar("Saturn", 25L));
        starList.add(createStar("Jupiter", 433L));
        starList.add(createStar("Pluto", 4L));
    }
    private Star createStar(String name, Long distance) {
        Star star = new Star();
        star.setItemName(name);
        star.setDistance(distance);
        return star;
    }

    @Test
    void getNumberOfStarsByDistancesTest() {
        when(starRepository.findAll()).thenReturn(starList);

        Map<Long, Integer> starsByDistance = starService.getNumberOfStarsByDistances();

        assertEquals(5, starsByDistance.size());
        assertEquals(2, starsByDistance.get(4L));
        assertEquals(1, starsByDistance.get(6L));
        assertEquals(1, starsByDistance.get(8L));
        assertEquals(1, starsByDistance.get(25L));
        assertEquals(1, starsByDistance.get(433L));
    }

    @Test
    void findClosestStarsTest() {
        when(starRepository.findAll()).thenReturn(starList);

        List<Star> closestStars = starService.findClosestStars(3);

        assertEquals(3, closestStars.size());
        assertEquals("Mars", closestStars.get(0).getItemName());
        assertEquals("Pluto", closestStars.get(1).getItemName());
        assertEquals("Earth", closestStars.get(2).getItemName());
    }
    @Test
    void getUniqueStarsTest() {
        when(starRepository.findAll()).thenReturn(starList);

        Collection<Star> uniqueStars = starService.getUniqueStars();

        assertEquals(6, uniqueStars.size());
        Set<String> starNames = new HashSet<>();
        uniqueStars.forEach(star -> starNames.add(star.getItemName()));
        assertTrue(starNames.contains("Earth"));
        assertTrue(starNames.contains("Pluto"));
        assertTrue(starNames.contains("Saturn"));
        assertTrue(starNames.contains("Jupiter"));
    }

    @Test
    void findClosestStarsSizeLargerThanListTest() {
        when(starRepository.findAll()).thenReturn(starList);

        List<Star> closestStars = starService.findClosestStars(10);

        assertEquals(6, closestStars.size());
    }
    @Test
    void getNumberOfStarsByDistancesEmptyListTest() {
        when(starRepository.findAll()).thenReturn(Collections.emptyList());

        Map<Long, Integer> starsByDistance = starService.getNumberOfStarsByDistances();

        assertTrue(starsByDistance.isEmpty());
    }
    @Test
    void getUniqueStarsWithSameNameTest() {
        List<Star> starsWithSameName = new ArrayList<>(starList);
        starsWithSameName.add(createStar("Earth", 10L));

        when(starRepository.findAll()).thenReturn(starsWithSameName);

        Collection<Star> uniqueStars = starService.getUniqueStars();

        assertEquals(6, uniqueStars.size());
        Set<String> starNames = new HashSet<>();
        uniqueStars.forEach(star -> starNames.add(star.getItemName()));
        assertTrue(starNames.contains("Mars"));
        assertTrue(starNames.contains("Earth"));
        assertTrue(starNames.contains("Uranus"));
        assertTrue(starNames.contains("Saturn"));
        assertTrue(starNames.contains("Jupiter"));
        assertTrue(starNames.contains("Pluto"));
    }


}