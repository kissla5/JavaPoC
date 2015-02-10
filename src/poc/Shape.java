/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;


enum ABC {A, B ,C};
class Shapy {
    
};

/**
 *
 * @author kissla
 */
public abstract class Shape {

    public static class Color {

        int m_red, m_green, m_blue;
        ABC a;

        protected Color() {
            this(0, 0, 0);
        }

        public Color(int red, int green, int blue) {
            m_red = red;
            m_green = green;
            m_blue = blue;
        }
        
        protected String toString2() {
            return "";
        }

        public String toString() {
            return " red = " + m_red + " green = " + m_green + " blue = " + m_blue;
        }
// other color members elided
    }
// other Shape members elided
}
