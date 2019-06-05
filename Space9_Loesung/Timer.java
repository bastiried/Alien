import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer
{
    Spielsteuerung st;
    public Timer(Spielsteuerung st_){
        st = st_;
    }

    @Override
    public void handle(long now) {
        st.update();
    }

    @Override
    public void start(){
        super.start();
    }

    @Override
    public void stop(){
        super.stop();
    }
}
