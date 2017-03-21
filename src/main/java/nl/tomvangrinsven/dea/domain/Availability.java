package nl.tomvangrinsven.dea.domain;


public class Availability {
    private boolean offlineAvailable;

    public void toggle(){
        offlineAvailable =! offlineAvailable;
    }

    public boolean isOfflineAvailable(){
        if(offlineAvailable){
            return true;
        }
        return false;
    }
}
