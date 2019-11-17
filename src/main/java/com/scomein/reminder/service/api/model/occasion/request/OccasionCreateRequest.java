package com.scomein.reminder.service.api.model.occasion.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.scomein.reminder.service.api.model.ApiConstants;
import com.scomein.reminder.service.api.model.deserializer.MonthDayDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.MonthDay;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OccasionCreateRequest {

    @NotNull(message = ApiConstants.EMPTY_FIELD_ERROR_MESSAGE)
    @JsonDeserialize(using = MonthDayDeserializer.class)
    private MonthDay date;

    @NotNull(message = ApiConstants.EMPTY_FIELD_ERROR_MESSAGE)
    @Size(min = ApiConstants.OCCASION_DESCRIPTION_MIN_LENGTH,
            max = ApiConstants.OCCASION_DESCRIPTION_MAX_LENGTH)
    private String description;
}
