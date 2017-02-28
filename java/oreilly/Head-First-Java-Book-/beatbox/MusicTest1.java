import javax.sound.midi.*;

public class MusicTest1{
    public void play(){
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We got a sequencer");
        } 
        catch(MidiUnavailableException ex){
            System.out.println("Technical issues. Please try again later.");       
        }
    }// close play
    
    public static void main(String[] args){
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }// close main
}// close class