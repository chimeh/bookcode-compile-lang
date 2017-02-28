package cafe.wrong;

public class Drink {

    protected String description;
    private boolean milk;
    private boolean soyMilk;
    private boolean chocolate;
    private boolean cream;

    public double Cost(){
        return 2.5d;
    }

    public String getDescription() {
        return description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoyMilk() {
        return soyMilk;
    }

    public void setSoyMilk(boolean soyMilk) {
        this.soyMilk = soyMilk;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
    }

    public boolean isCream() {
        return cream;
    }

    public void setCream(boolean cream) {
        this.cream = cream;
    }
}
