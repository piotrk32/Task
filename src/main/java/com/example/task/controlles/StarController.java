package com.example.task.controlles;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stars")
@RequiredArgsConstructor
@Tag(name = "Star", description = "Controller for star management")
public class StarController {
}
