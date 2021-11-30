package com.digitalinnovationone.Animesapi.controller;
import com.digitalinnovationone.Animesapi.document.Animes;
import com.digitalinnovationone.Animesapi.repository.AnimesRepository;
import com.digitalinnovationone.Animesapi.service.AnimesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.digitalinnovationone.Animesapi.constans.AnimesConstant.ANIMES_ENDPOINT_LOCAL;


@RestController
@Slf4j
public class AnimesController {
    AnimesService animesService;
    AnimesRepository animesRepository;

    public static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(AnimesController.class);

    public AnimesController(AnimesService animesService, AnimesRepository animesRepository){
        this.animesService =animesService;
        this.animesRepository = animesRepository;
    }

    @GetMapping(ANIMES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Animes> getAllItems(){
        log.info("requesting the list of all Animes");
        return animesService.findAll();
    }

    @GetMapping(ANIMES_ENDPOINT_LOCAL+"/id")
    public Mono <ResponseEntity<Animes>> findByIdAnimes(@PathVariable String id){
        log.info("requesting the Anime with id {}",id);
        return animesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(ANIMES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public  Mono<Animes> createAnime(@RequestBody Animes anime){
        log.info("A new Anime was created!");
        return animesService.save(anime);
    }

    @DeleteMapping(ANIMES_ENDPOINT_LOCAL+"/id")
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<HttpStatus> deleteByIdAnime(@PathVariable String id){
        animesService.deleteByIdAnime(id);
        log.info("Delete an anime with id {}", id);
        return  Mono.just(HttpStatus.OK);
    }

}
