import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
    Clip clip;

    URL soundURL[] = new URL[30];

    public Sound(){

        soundURL[0] = getClass().getResource("/sound/doorsound.wav");
        soundURL[1] = getClass().getResource("/sound/chestSound.wav");
        soundURL[2] = getClass().getResource("/sound/chicken.wav");
        soundURL[3] = getClass().getResource("/sound/chestSound.wav");
        soundURL[4] = getClass().getResource("/sound/shadow.wav");
        soundURL[5] = getClass().getResource("/sound/cow.wav");
        soundURL[6] = getClass().getResource("/sound/pig.wav");
        soundURL[7] = getClass().getResource("/sound/creeper.wav");
        soundURL[8] = getClass().getResource("/sound/zombie.wav");
        soundURL[9] = getClass().getResource("/sound/tadah.wav");
        soundURL[10] = getClass().getResource("/sound/anvil.wav");
    }
    public void setFile(int i){
        try{

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }
    public void play(){

        clip.start();
    }
    public void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){

        clip.stop();

    }

}

