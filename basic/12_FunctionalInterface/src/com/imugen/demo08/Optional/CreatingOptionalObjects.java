package com.imugen.demo08.Optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Daniel Liu 2020/4/16 17:53
 */

class CreatingOptionalObjects {

    @Test
    public void whenCreateEmptyOptional_thenCorrect(){
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "Jin";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test
    void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name =null;
        Optional.of(name);
    }

    @Test
    void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "Jin";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    @Test
    void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }
}