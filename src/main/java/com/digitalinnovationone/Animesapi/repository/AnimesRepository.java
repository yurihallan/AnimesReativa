package com.digitalinnovationone.Animesapi.repository;

import com.digitalinnovationone.Animesapi.document.Animes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface AnimesRepository  extends CrudRepository<Animes, String> {
}
