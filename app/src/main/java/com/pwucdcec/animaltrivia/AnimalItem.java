package com.pwucdcec.animaltrivia;

/**
 * Created by mykelneds on 07/02/2018.
 */

public class AnimalItem {

    int id;
    int category;
    String name;
    int drawable;
    int isSolved;
    String scientificName;
    String description;

    public AnimalItem(int id, int category, String name, int drawable, int isSolved, String scientificName, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.drawable = drawable;
        this.isSolved = isSolved;
        this.scientificName = scientificName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getDrawable() {
        return drawable;
    }

    public int getIsSolved() {
        return isSolved;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() {
        return description;
    }

    //    public AnimalItem(int drawable, int isSolved) {
//        this.drawable = drawable;
//        this.isSolved = isSolved;
//    }
//
//    public int getDrawable() {
//        return drawable;
//    }
//
//    public int getIsSolved() {
//        return isSolved;
//    }
}
