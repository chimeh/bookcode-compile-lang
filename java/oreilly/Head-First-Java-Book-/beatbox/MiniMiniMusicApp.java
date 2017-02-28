import javax.sound.midi.*;

public class MiniMiniMusicApp{
    
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }// close main
    
    public void play(){
        try{
            Sequencer player = MidiSystem.getSequencer(); // get a sequencer
            player.open(); // open the sequencer because it doesn't come opened
            
            Sequence seq = new Sequence(Sequence.PPQ, 4); // arguments yet unknowned
            
            Track track = seq.createTrack(); // Ask the Sequence for a track because track lives in Sequence.
            
            
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
            
            player.setSequence(seq);
            
            player.start();
        }// close try
        catch(Exception ex){
            ex.printStackTrace();
        }// close catch    
    }// close play
}// close class
