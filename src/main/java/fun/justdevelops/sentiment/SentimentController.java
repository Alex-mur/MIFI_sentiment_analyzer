package fun.justdevelops.sentiment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.random.RandomGenerator;

@RestController
@RequestMapping("/api")
public class SentimentController {

    @GetMapping("/sentiment")
    public SentimentResponse sentiment(@RequestParam("text") String text) {
        String sentiment = "positive";
        if (RandomGenerator.getDefault().nextInt() % 2 > 0) {
            sentiment = "negative";
        }
        return new SentimentResponse(sentiment);
    }

    public record SentimentResponse(String sentiment) {}
}
