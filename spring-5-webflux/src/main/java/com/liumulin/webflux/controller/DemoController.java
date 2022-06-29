package com.liumulin.webflux.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * webflux 练习
 *
 * @author liuqiang
 * @date 2022/06/24
 */
public class DemoController {

    public static void main(String[] args) {
//        List<String> it = Arrays.asList("1", "2");

//        Flux<Long> intervalFlux = Flux.interval(Duration.ofMillis(100));
//        intervalFlux.subscribe(System.out::println);
        fluxRange();

        Supplier<Double> nextDouble = new Random()::nextDouble;
        Supplier<Double> nextDouble1 = new Random()::nextDouble;

        Mono.fromSupplier(new Random()::nextDouble).subscribe(System.out::println);
        Flux.fromArray(new List[]{Arrays.asList(1, 2)}).doOnNext(System.out::println).subscribe(System.out::println);
        Flux.fromIterable(Arrays.asList(1, 2))
                .map(l -> {
                    System.out.println(l);
                    return l;
                })
                .subscribe();
    }

    private static void fluxRange() {
        Flux.range(1, 5).subscribe(System.out::println);
    }

}
