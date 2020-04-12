/**
 * @作者 leokkzhang
 * @创建时间 2020/4/9 21:53
 */
package com.lin.missyou.optional;


import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional(){
        Optional<String> empty = Optional.empty();
//        Optional<String> t1 = Optional.of("test");
        Optional<String> t2 = Optional.ofNullable(null);
//        t1.get();
//        empty.get();
//        String s = t2.get();
        String s1 = t2.orElse("moren");
    }
}
