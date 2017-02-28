package weather;

public interface Subject {

   void addObserver(Observer observer);
   void removeObserver(Observer observer);
   void sendData();
}
