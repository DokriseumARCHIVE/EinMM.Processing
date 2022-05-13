import processing.core.PApplet;

public class EinMMProcessing extends PApplet {
    private int buttonX, buttonY;      // position vom knopf
    private boolean buttonHover;
    private int buttonSize;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int pWidth = 640;
    private int pHeight = 480;

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("EinMMProcessing");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(pWidth, pHeight);
    }

    // identical use to setup in Processing IDE except for size()
    public void setup() {
        size(pWidth, pHeight);
        buttonSize = 90;
        red = 0;
        green = 0;
        blue = 0;
        buttonX = (width / 2) - (buttonSize - 10);
        buttonY = (height / 2) - (buttonSize / 2);
        buttonHover = false;
        ellipseMode(CENTER);
    }

    // identical use to draw in Prcessing IDE
    public void draw() {
        update(mouseX, mouseY);
        ///////////////////////////////////////////////////
        ////                  Rechteck                 ////
        ///////////////////////////////////////////////////

        //background(red, green, blue);
        rect(5, 5, 256, 256); //links, oben, breite, länge
        fill(color(red, green, blue));
        ///////////////////////////////////////////////////
        ////                  Knopf                    ////
        ///////////////////////////////////////////////////
        button();
    }

    private void update(int x, int y) {
        if ( overButton(buttonX, buttonY, buttonSize, buttonSize) ) {
            buttonHover = true;
        } else {
            buttonHover = false;
        }
    }

    public void mousePressed() {
        if (buttonHover) {
            red = round(random(256));
            green = round(random(256));
            blue = round(random(256));
        }
    }

    /**
     public void mouseClicked(){
     red = round(random(256));
     green = round(random(256));
     blue = round(random(256));
     delay(100); //verzoegerung
     }
     */

    public boolean overButton(int x, int y, int width, int height) {
        if (mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

    public void button() {
        rect(320, 5, 26, 26); //links, oben, breite, länge
        text("Zufallsfarbe", 480, 240);
        if (buttonHover) {
            fill(100);
        } else {
            fill(256);
        }
        stroke(255);
        stroke(0);
    }
}
