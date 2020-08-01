package com.dispolitics.server;

import com.dispolitics.server.models.City;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<City, Integer> {
}
