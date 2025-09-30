package com.Mood_to_Quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class Controller {

    private static final Map<String, List<String>> quotes = new HashMap<>();

    static {
        quotes.put("happy", Arrays.asList(
                "Happiness is not by chance, but by choice.",
                "Smile, it’s free therapy.",
                "Happiness shared is the flower multiplied."
        ));
        quotes.put("sad", Arrays.asList(
                "Tears come from the heart, not from the brain.",
                "Every storm runs out of rain.",
                "Sadness flies away on the wings of time."
        ));
        quotes.put("motivated", Arrays.asList(
                "Don’t watch the clock; do what it does. Keep going.",
                "Push yourself, because no one else is going to do it for you.",
                "Dream it. Wish it. Do it."
        ));
        quotes.put("stressed", Arrays.asList(
                "Almost everything will work again if you unplug it for a few minutes.",
                "You don’t have to control your thoughts. Just stop letting them control you.",
                "Take a deep breath, and let it go."
        ));
    }

    @GetMapping("/quote")
    public String getQuote(@RequestParam String mood) {

        String key = mood.toLowerCase().trim();


        List<String> moodQuotes = quotes.getOrDefault(
                key,
                Collections.singletonList("Mood not found. Try happy, sad, motivated, stressed.")
        );


        return moodQuotes.get(new Random().nextInt(moodQuotes.size()));
    }

}