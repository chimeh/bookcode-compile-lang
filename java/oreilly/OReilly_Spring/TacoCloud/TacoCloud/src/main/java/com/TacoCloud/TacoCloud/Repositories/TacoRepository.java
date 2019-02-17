package com.TacoCloud.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.TacoCloud.TacoCloud.Domain.Entities.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
