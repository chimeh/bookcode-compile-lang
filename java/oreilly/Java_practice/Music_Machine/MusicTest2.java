import javax.sound.midi.*;

public class MusicTest2 {

    public void play() {

        try {

            Sequencer sequencer = MidiSystem.getSequencer();

            System.out.println("We got a sequencer.");

        } catch(MidiUnavailableException ex) {

            System.out.println("Bummer.");

        }

    }
            
    public static void main(String[] args) {


        MusicTest2 mt = new MusicTest2();

        mt.play();

    }

}
