package com.scomein.reminder.service.api.model.occasion.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scomein.reminder.service.api.model.ApiConstants;
import lombok.Builder;
import lombok.Data;

import java.time.MonthDay;

@Data
@Builder
public class OccasionGetResponse {
    private String id;
    @JsonFormat(pattern = ApiConstants.OCCASION_DATE_FORMAT)
    private MonthDay date;
    private String description;
}
