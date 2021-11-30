package com.digitalinnovationone.Animesapi.service;

import com.digitalinnovationone.Animesapi.document.Animes;
import com.digitalinnovationone.Animesapi.repository.AnimesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnimesService {
    private final AnimesRepository animesRepository;

    public AnimesService(AnimesRepository animesRepository) {
        this.animesRepository = animesRepository;
    }

    public Flux<Animes> findAll() {
        return Flux.fromIterable(this.animesRepository.findAll());
    }

    public Mono<Animes> findByIdHero(String id) {
        return Mono.justOrEmpty(this.animesRepository.findById(id));
    }

    public Mono<Animes> save(Animes animes) {
        return Mono.justOrEmpty(this.animesRepository.save(animes));
    }

    public Mono<Boolean> deleteByIdAnime(String id) {
        animesRepository.deleteById(id);
        return Mono.just(true);
    }
}
