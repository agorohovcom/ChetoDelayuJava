package Sequencer;

import javax.sound.midi.*;

public class Main {

    public static void main(String[] args) {
        play();
    }

    public static void play(){
        try{
            // получить синтезатор и открыть его
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            // создать новую последовательность
            Sequence seq = new Sequence(Sequence.PPQ,4);

            // получить новый трек из последовательности
            Track track = seq.createTrack();

            // заполнить трек midi-событиями и
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            // передать последовательность в синтезатор
            player.setSequence(seq);

            // запускаем синтезатор (жмём Play)
            player.start();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
