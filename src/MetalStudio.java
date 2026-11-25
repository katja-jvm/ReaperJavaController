public class MetalStudio {
    public static void main(String[] args){
        // Create a new Track instance
        Track myTrack = new Track();
        myTrack.title = "Master Of Puppets";
        myTrack.bpm = 220;

        // Trigger playback in REAPER
        myTrack.playInReaper();
    }
}
