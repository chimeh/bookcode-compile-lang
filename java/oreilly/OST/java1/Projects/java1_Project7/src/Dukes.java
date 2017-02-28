import java.awt.Color;


public class Dukes {
  
  private Color noseColor = Color.red; // default Dukes have red noses
  private String action = "../../images/duke/dukeWave.gif"; //default Dukes are friendly
  private String whatDoing = "Give me something to do";
  private String message = "";
  
  public Dukes ()
  {
    int rint = (int)(Math.random() * 3); // randomly generates a 0,1, or 2
    
    switch (rint){
      case 0: action = this.write(); break;
      case 1: action= this.think(); break;
      case 2: action= this.wave(); break;
    }
  }
  
  public String getAction() {
    return whatDoing;
  }
  
  public String getActionImage() {
    return action;
  }
  
  public Color getNoseColor() {
    return noseColor;
  }
  
  public String getMessage() {
    return message;
  }
  
  public String write() {
    whatDoing = "I am a writing Duke";
    if (noseColor == Color.red) {
      action = "../../images/duke/penduke.gif";
      message = "";
    }
    else {
      action = "../../images/duke/penduke2.gif";
      message = "My nose feels funny";
    }
    return action;
  }
  
  public String think() {
    whatDoing = "I am a thinking Duke";
    if (noseColor == Color.red) {
      action = "../../images/duke/thinking.gif";
      message = "";
    }
    else {
      action = "../../images/duke/thinking2.gif";
      message = "My nose feels funny";
    }
    return action;
  }
  
  public String wave() {
    whatDoing = "I am a waving Duke";
    if (noseColor == Color.red) {
      action = "../../images/duke/dukeWave.gif";
      message ="";
    }
    else {
      action = "../../images/duke/dukeWave2.gif";
      message = "My nose feels funny";
    }
    return action;
  }
}
