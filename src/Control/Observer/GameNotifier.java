package Control.Observer;

public interface GameNotifier {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
