package com.imugen.demo08.Optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 检查值存在
 *
 * @author Daniel Liu 2020/4/17 11:23
 */
public class CheckValuePresence {
    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect(){
        Optional<String> opt = Optional.of("Jin");
        assertTrue(opt.isPresent());

        Optional<Object> opt1 = Optional.ofNullable(null);
        assertFalse(opt1.isPresent());
    }

    @Test
    void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
        Optional<String> opt = Optional.of("Jin");
        assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());
    }
}