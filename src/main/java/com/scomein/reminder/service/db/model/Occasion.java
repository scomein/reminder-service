package com.scomein.reminder.service.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Occasion {

    @Id
    private String id;
    private String userId;
    private String description;
    private int day;
    private int month;
}
