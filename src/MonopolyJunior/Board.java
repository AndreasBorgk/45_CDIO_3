package Monopoly;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;

public class Board {
    private GUI_Field[]Fields = new GUI_Field[24];

    public GUI_Field[] getFields() {
        return Fields;
    }

    public Board() {
        int i = 0;
        Fields[i++] = new GUI_Street("Start", "Modtag 2M når du passere", "0", "200", Color.WHITE, Color.BLACK);
        Fields[i++] = new GUI_Street("Burgerbar", "Koster M1", "Burgerbar", "200", new Color(156, 52, 4), Color.BLACK);
        Fields[i++] = new GUI_Street("Pizzahuset", "Koster M1", "Pizzahuset", "200", new Color(156, 52, 4), Color.BLACK);
        Fields[i++] = new GUI_Street("Chance", "Træk et chance kort", "Træk et chance kort", "200", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Slikbutikken", "Koster M1", "Slikbutikken", "200", new Color(169, 157, 232), Color.BLACK);
        Fields[i++] = new GUI_Street("Iskiosken", "Koster 2M", "Iskiosken", "200", new Color(169, 157, 232), Color.BLACK);
        Fields[i++] = new GUI_Street("På besøg", "I fængsel", "På Besøg / Fængsel", "200", Color.orange, Color.BLACK);
        Fields[i++] = new GUI_Street("Museet", "Koster M2", "Museet", "200", new Color(182, 125, 142), Color.BLACK);
        Fields[i++] = new GUI_Street("Bibliotek", "Koster M2", "Bibliotek", "200", new Color(182, 125, 142), Color.BLACK);
        Fields[i++] = new GUI_Street("Chance", "Træk et chance kort", "Træk et chance kort", "200", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Skateparken", "Koster M2", "Skateparken", "200", new Color(250, 241, 151), Color.BLACK);
        Fields[i++] = new GUI_Street("Swimmingpoolen", "Koster M2", "Swimmingpoolen", "200", new Color(250, 241, 151), Color.BLACK);
        Fields[i++] = new GUI_Street("Gratis Parkering", "Gratis", "Gratis Parkering", "200", Color.RED, Color.BLACK);
        Fields[i++] = new GUI_Street("Spillehallen", "Koster M3", "Spillehallen", "300", new Color(181, 102, 75), Color.BLACK);
        Fields[i++] = new GUI_Street("Biografen", "Koster M3", "Biografen", "300", new Color(181, 102, 75), Color.BLACK);
        Fields[i++] = new GUI_Street("Chance", "Træk et chance kort", "Træk et chance kort", "200", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Lejetøjsbutik", "Koster M3", "Lejetøjsbutik", "300", new Color(252, 254, 117), Color.BLACK);
        Fields[i++] = new GUI_Street("Dyrehandlen", "Koster M3", "Dyrehandlen", "300", new Color(252, 254, 117), Color.BLACK);
        Fields[i++] = new GUI_Street("Gå i fængsel", "Gå i fængsel", "Gå i fængsel", "200", Color.blue, Color.BLACK);
        Fields[i++] = new GUI_Street("Bowlinghallen", "Koster M4", "Bowlinghallen", "400", new Color(12, 94, 30), Color.BLACK);
        Fields[i++] = new GUI_Street("Zoologisk have", "Koster M4", "ZOO", "400", new Color(12, 94, 38), Color.BLACK);
        Fields[i++] = new GUI_Street("Chance", "Træk et chance kort", "Træk et chance kort", "200", Color.BLACK, Color.yellow);
        Fields[i++] = new GUI_Street("Vandfaldet", "Koster M5", "Vandfaldet", "200", new Color(0, 0, 250), Color.BLACK);
        Fields[i++] = new GUI_Street("Strandpromenaden", "Koster M5", "Strandpromenaden", "5", new Color(0, 0, 250), Color.BLACK);

    }
    public GUI_Field getField(int location) {
        return Fields[location];
    }
}
