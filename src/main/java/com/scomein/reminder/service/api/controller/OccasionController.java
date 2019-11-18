package com.scomein.reminder.service.api.controller;

import com.scomein.reminder.service.api.model.occasion.request.OccasionCreateRequest;
import com.scomein.reminder.service.api.model.occasion.response.OccasionCreateResponse;
import com.scomein.reminder.service.db.dao.OccasionDao;
import com.scomein.reminder.service.db.model.Occasion;
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

    private OccasionDao occasionDao;

    public OccasionController(OccasionDao occasionDao) {
        this.occasionDao = occasionDao;
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OccasionCreateResponse createOccasion(@RequestBody @Valid OccasionCreateRequest request) {
        log.info("Requested occasion with params: date {}, description: {}",
                request.getDate(), request.getDescription());
        Occasion occasion = occasionDao.insert(Occasion.builder()
                .day(request.getDate().getDayOfMonth())
                .month(request.getDate().getMonthValue())
                .description(request.getDescription())
                .build());
        return new OccasionCreateResponse(occasion.getId());
    }
}
