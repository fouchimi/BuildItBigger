package com.example.ousmane.myapplication.backend;

/**
 * Created by ousmane on 9/19/16.
 */
import java.util.Arrays;
import java.util.List;

public class JokeBean {

    private String joke;
    private List<String> jokeList = Arrays.asList("What's your advice for coming generations ? Please don't come",
            "Always borrow money from a pessimist. He won't expect it back",
            "The scientific theory I like best is that the rings of Saturn are composed entirely of lost airline luggage",
            "Friendship is like peeing on yourself: everyone can see it, but only you get the warm feeling that it brings",
            "A successful man is one who makes more money than his wife can spend. A successful woman is one who can find such a man",
            "How do you get a sweet little 80-year-old lady to say the F word? Get another sweet little 80-year-old lady to yell BINGO!",
            "Dogs have masters. Cats have staff",
            "Knowledge is knowing a tomato is a fruit; wisdom is not putting it in a fruit salad",
            "I love deadlines. I like the whooshing sound they make as they fly by",
            "By all means, marry. If you get a good wife, you'll become happy; if you get a bad one, you'll become a philosopher",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness",
            "The best way to lie is to tell the truth... Carefully edited truth",
            "Do not argue with an idiot. He will drag you down to his level and beat you with experience",
            "Men have only two emotions: hungry and horny. If you see him without an erection, make him a sandwich",
            "if you can't have midnight snack why do we have a light in the fridge",
            "A bargain is something you don't need at a price you can't resist.");

    public JokeBean(){}

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getJokeList() {
        return jokeList;
    }

    public void setJokeList(List<String> jokeList) {
        this.jokeList = jokeList;
    }


}
