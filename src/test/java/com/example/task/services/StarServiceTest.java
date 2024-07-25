package com.example.task.services;

import com.example.task.models.star.Star;
import com.example.task.repositories.StarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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


}