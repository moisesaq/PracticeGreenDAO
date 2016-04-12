package com.apaza.moises.greendao_generator;

import android.util.Log;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


public class MainGenerator {

    private String name;
    private float rating;
    private String address;
    private String description;
    private String pathImage;

    public static final String TAG = "GENERATOR GREEN DAO";

    public static void main(String[] args){
        Schema schema = new Schema(1, "com.apaza.moises.practicegreendao.database");

        Entity user = schema.addEntity("User");
        user.addIdProperty();
        user.addStringProperty("fullName");
        user.addStringProperty("address");
        user.addStringProperty("phone");
        user.addStringProperty("email");
        user.addStringProperty("pathImage");

        Entity place = schema.addEntity("Place");
        place.addIdProperty();
        Property namePlace = place.addStringProperty("name").notNull().getProperty();
        place.addFloatProperty("rating");
        place.addStringProperty("address");
        place.addStringProperty("description");
        place.addStringProperty("pathImage");
        Property userId = place.addLongProperty("userId").notNull().getProperty();

        //Llave foranea de usuario en la tabla de lugares
        place.addToOne(user, userId); //Un mismo lugar solo puede ser sugerido por un usuario

        //Para obtener los lugares sugeridos por el usuario
        ToMany userToPlace = user.addToMany(place, userId); //Es decir que un usuario puede sugerir varios lugares
        userToPlace.setName("Places");
        userToPlace.orderAsc(namePlace);

        Entity rating = schema.addEntity("Rating");
        Property placeIdInRating = rating.addLongProperty("placeId").notNull().getProperty();
        Property userIdInRating = rating.addLongProperty("userId").notNull().getProperty();
        rating.addFloatProperty("qualification");
        rating.addStringProperty("comment");

        rating.addToOne(user, userIdInRating);

        ToMany ratingOfPlace = place.addToMany(rating, placeIdInRating);
        ratingOfPlace.setName("RatingPlace");

        try{
            DaoGenerator daoGenerator = new DaoGenerator();
            daoGenerator.generateAll(schema, "./app/src/main/java");
        }catch(Exception e){
            e.printStackTrace();
            Log.d(TAG, "Error in generator DAO");
        }
    }
}
