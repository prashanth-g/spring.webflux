package com.prashanth.spring.webflux.init;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KaleController {

    private Map<Integer, Kale> kales = new HashMap<Integer, Kale>() {{
        put(1, new Kale("name01"));
        put(2, new Kale("name02"));
    }};

    @GetMapping("/kales")
    public Flux<Kale> getKales() {
        return Flux.fromIterable(kales.values());
    }

    @GetMapping("/kales/{id}")
    public Mono<Kale> getKaleById(@PathVariable int id) {
        return Mono.justOrEmpty(kales.get(id));
    }
}
