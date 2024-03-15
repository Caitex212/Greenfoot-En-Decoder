import greenfoot.*;
import java.util.Scanner;

public class encoder extends Actor
{
    private String encoded = "";
    
    public void act()
    {
    }
    
    public void coder(String text, int method) {
        encoded = "";
        if(method == 1) {
            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                encoded += decodeCharacter(c, ((MyWorld) getWorld()).offset);
            }
            System.out.println(encoded);       
        } else if(method == 0) {
            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                encoded += encodeCharacter(c, ((MyWorld) getWorld()).offset);
            }
            System.out.println(encoded);
        }
    }
    
    private char encodeCharacter(char c, int offset) {
        if (Character.isLetter(c)) {
            int start = Character.isLowerCase(c) ? 'a' : 'A';
            return (char)(((c - start + offset) % 26) + start);
        } else if (Character.isDigit(c)) {
            return (char)(((c - '0' + offset) % 10) + '0');
        } else {
            return c;
        }
    }
    private char decodeCharacter(char c, int offset) {
        if (Character.isLetter(c)) {
            int start = Character.isLowerCase(c) ? 'a' : 'A';
            int decoded = ((c - start - offset + 26) % 26) + start;
            return (char) decoded;
        } else if (Character.isDigit(c)) {
            int decoded = ((c - '0' - offset + 10) % 10) + '0';
            return (char) decoded;
        } else {
            return c;
        }
    }
}
