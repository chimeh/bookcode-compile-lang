import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener{
    public static void main(String[] args){
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }// close main method
    public void go(){
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);
            
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            
            for (int i = 5; i < 61; i += 4){
                track.add(makeEvent(144,1,i,100,i));
                
                track.add(makeEvent(176,1,127,0,i));
                
                track.add(makeEvent(128,1,i,100,i+2));
            }//close for loop
            
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }// close try
        catch(Exception ex){ ex.printStackTrace(); }// close catch   
    }//close go()
    
    public void controlChange(ShortMessage event){
        System.out.println("la");
    }// close controlChange()
    
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }//close try
        catch(Exception ex){  }//close catch
        return event;
    }// close MidiEvent()
} // close class