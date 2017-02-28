import java.awt.*;

public class Calculator {
  
  private int firstNumber, secondNumber, answer;
  private boolean isReady;
  


  public Calculator(int num1, int num2, boolean isReady) {
    setFirstNumber(num1);
    setSecondNumber(num2);
    setReady(isReady);
  }
  
  public int getFirstNumber() {
    return firstNumber;
  }

  public void setFirstNumber(int firstNumber) {
    this.firstNumber = firstNumber;
  }

  public int getSecondNumber() {
    return secondNumber;
  }

  public void setSecondNumber(int secondNumber) {
    this.secondNumber = secondNumber;
  }

  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }
  
  public boolean isReady() {
    return isReady;
  }

  public void setReady(boolean isReady) {
    this.isReady = isReady;
  }
  
  
}
