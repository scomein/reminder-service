package com.scomein.reminder.service.db.dao;

import com.scomein.reminder.service.db.model.Occasion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OccasionDao extends MongoRepository<Occasion, String> {

}
