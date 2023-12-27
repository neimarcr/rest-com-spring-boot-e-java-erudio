package br.com.neimar.apirest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingsController {
    private static final String template = "Hello, dear %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/greetings")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
