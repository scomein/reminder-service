package com.scomein.reminder.service.api.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.scomein.reminder.service.api.model.ApiConstants;

import java.io.IOException;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MonthDayDeserializer extends JsonDeserializer<MonthDay> {
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(ApiConstants.OCCASION_DATE_FORMAT);

    @Override
    public MonthDay deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getValueAsString();
        try {
            return MonthDay.parse(date, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw  e;
            //throw new ValidatorException("is invalid");
        }
    }
}
