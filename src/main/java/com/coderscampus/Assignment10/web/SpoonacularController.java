package com.coderscampus.Assignment10.web;

import com.coderscampus.Assignment10.dto.DayResponse;
import com.coderscampus.Assignment10.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
public class SpoonacularController {

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return (ResponseEntity<WeekResponse>) getSpoonacularResponse(numCalories, diet, exclusions, "week", WeekResponse.class);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return (ResponseEntity<DayResponse>) getSpoonacularResponse(numCalories, diet, exclusions, "day", DayResponse.class);
    }

    private ResponseEntity<?> getSpoonacularResponse(String numCalories, String diet,
                                                     String exclusions, String timeFrame, Class<?> responseClass) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                                                           .queryParam("timeFrame", timeFrame)
                                                           .queryParam("apiKey", "01556ee7dd774e3a934b2ded27a71426")
        .queryParamIfPresent("targetCalories", java.util.Optional.of(Integer.parseInt(numCalories)))
                .queryParamIfPresent("diet", java.util.Optional.ofNullable(diet))
                .queryParamIfPresent("exclude", java.util.Optional.ofNullable(exclusions));

        URI uri = builder.build().toUri();

        RestTemplate rt = new RestTemplate();
        ResponseEntity<?> responseEntity = rt.getForEntity(uri, responseClass);
        return responseEntity;
    }
}