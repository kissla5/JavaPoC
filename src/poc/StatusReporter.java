/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

/**
 *
 * @author kissla
 */
public class StatusReporter {
// important to note that the argument "color" is declared final
// otherwise, the local inner class DescriptiveColor will not be able to use it!!

    static Shape.Color getDesciptiveColor(final Shape.Color color) {
// local class DescriptiveColor that extends Shape.Color class
        class DescriptiveColor extends Shape.Color {

            public DescriptiveColor() {
            }

            private DescriptiveColor(int red, int green, int blue) {
                super(red, green, blue);
            }

            @Override
            public String toString() {
                return "You selected a color with RGB values / red = " + m_red + " green = " + m_green + " blue = " + m_blue;
            }

            @Override
            protected String toString2() {
                return "You selected a color with RGB values " + color;
            }
        }
        return new DescriptiveColor();
    }

    public static void main(String[] args) {
        Shape.Color descriptiveColor
                = StatusReporter.getDesciptiveColor(new Shape.Color(0, 0, 0));
        System.out.println(descriptiveColor);
    }
}
