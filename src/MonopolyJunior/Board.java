package MonopolyJunior;

import java.util.Vector;

public class Board {
    private Vector<Field> fields = new Vector<>();

    public Board()
    {
        fields.add(new Field("start",2));
        fields.add(new Field("Burgerbaren",1));
        fields.add(new Field("Pizzariaet",1));
        fields.add(new Field("Chance Kort",0));
        fields.add(new Field("Slikbutikken",1));
        fields.add(new Field("Iskiosken",1));
        fields.add(new Field("Fængslet",0));
        fields.add(new Field("Museet",2));
        fields.add(new Field("Biblioteket",2));
        fields.add(new Field("Chance kort",0));
        fields.add(new Field("Skaterparken",2));
        fields.add(new Field("Swimmingpoolen",2));
        fields.add(new Field("Gratis Parkering",0));
        fields.add(new Field("Spillehallen",3));
        fields.add(new Field("Biografen",3));
        fields.add(new Field("Chance Kort",0));
        fields.add(new Field("Legetøjs butikken",3));
        fields.add(new Field("Dyre handlen",3));
        fields.add(new Field("Gå i Fængsel",0));
        fields.add(new Field("Bowling hallen",4));
        fields.add(new Field("Zoo",4));
        fields.add(new Field("Chance Kort", 0));
        fields.add(new Field("Vandlandet",5));
        fields.add(new Field("Strandpromenaden",5));

    }
    public Field getField(int location)
    {
        return fields.get(location);
    }
}
