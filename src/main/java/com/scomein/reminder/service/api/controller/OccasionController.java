package com.scomein.reminder.service.api.controller;

import com.scomein.reminder.service.api.model.occasion.request.OccasionCreateRequest;
import com.scomein.reminder.service.api.model.occasion.response.OccasionCreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/occasions")
public class OccasionController {

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OccasionCreateResponse createOccasion(@RequestBody @Valid OccasionCreateRequest request) {
        log.info("Requested occasion with params: date {}, description: {}",
                request.getDate(), request.getDescription());
        return new OccasionCreateResponse(UUID.randomUUID().toString());
    }
}
