package com.kodilla.drinks_frontend.votedIngredients;

import com.kodilla.drinks_frontend.connectionsToBackend.VotesConnections;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VotesService {

    @Autowired
    private VotesConnections votesConnections;

    private Set<Votes> votes;
    private static VotesService votesService;

    private VotesService() {
        this.votes = exampleData();
    }

    public static VotesService getInstance() {
        if (votesService == null) {
            votesService = new VotesService();
        }
        return votesService;
    }

    public Set getVotes() {
        return new HashSet<>(votes);
    }

    public Set exampleData() {
        Set voted = new HashSet();
        voted.add(new Votes(1L,"Beer",5));
        return voted;
    }

    public Set findByIngredient(String ingredient) {
        return votes.stream().filter(v -> v.getIngredient().contains(ingredient)).collect(Collectors.toSet());
    }

    public void vote(Votes vote) {
        //votesConnections.voteIngredient(vote);
    }
}




