package Generics.WildcardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team <T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant){
        participants.add(participant);
        System.out.println("В команду " + name +
                " был добавлен новый участник по имени " +
                participant.getName());
    }

    public void playWith(Team<T> team){
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i == 0){
            winnerName = this.name;
        }
        else {
            winnerName = team.name;
        }
        System.out.println("Выиграла команда " + winnerName);
    }
}
