/*
Author : Joseph Babilu Karippai
JarJarBinks.java ~ Assignment 05
*/

import com.google.gson.Gson; // Import Gson library for JSON serialization

import org.apache.commons.csv.CSVRecord; // Import CSVRecord class from Apache Commons CSV library
import org.apache.commons.csv.CSVFormat; // Import CSVFormat class from Apache Commons CSV library

import java.io.Reader; 
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.Writer; 
import java.io.File; 

import java.util.List; 
import java.util.ArrayList; 


class Character{
    // Declaring fields for character attributes
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    Character(){}

    //  Constructor for character attributes
    Character(String name,
            String height,
            String mass,
            String hairColor,
            String skinColor,
            String eyeColor,
            String birthYear,
            String gender,
            String homeworld,
            String species)
    {
        this.setName(name);
        this.setHeight(height);
        this.setMass(mass);
        this.setHairColor(hairColor);
        this.setSkinColor(skinColor);
        this.setEyeColor(eyeColor);
        this.setBirthYear(birthYear);
        this.setGender(gender);
        this.setHomeworld(homeworld);
        this.setSpecies(species);
    }

    // Setters
    void setName(String name){
        this.name = name;
    }

    void setHeight(String height){
        this.height = height;
    }

    void setMass(String mass){
        this.mass = mass;
    }

    void setHairColor(String hairColor){
        this.hairColor = hairColor;
    }

    void setSkinColor(String skinColor){
        this.skinColor = skinColor;
    }

    void setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
    }

    void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }

    void setGender(String gender){
        this.gender = gender;
    }

    void setHomeworld(String homeworld){
        this.homeworld = homeworld;
    }

    void setSpecies(String species){
        this.species = species;
    }

    // Getters 
    String getName(){
        return this.name;
    }

    String getHeight(){
        return this.height;
    }

    String getMass(){
        return this.mass;
    }

    String getHairColor(){
        return this.hairColor;
    }

    String getSkinColor(){
        return this.skinColor;
    }

    String getEyeColor(){
        return this.eyeColor;
    }

    String getBirthYear(){
        return this.birthYear;
    }

    String getGender(){
        return this.gender;
    }

    String getHomeworld(){
        return this.homeworld;
    }

    String getSpecies(){
        return this.species;
    }

    // Override toString method to display character information
    @Override
    public String toString(){
        return String.format("Name: %s\nHeight: %s\nMass: %s\nHair color: %s\nSkin color: %s\nEye color: %s\nBirth year: %s\nGender: %s\nHomeworld: %s\nSpecies: %s",
                            this.getName(), 
                            this.getHeight(),
                            this.getMass(),
                            this.getHairColor(),
                            this.getSkinColor(),
                            this.getEyeColor(),
                            this.getBirthYear(),
                            this.getGender(),
                            this.getHomeworld(),
                            this.getSpecies());
    }
}


public class JarJarBinks{
    
    public static void main(String args[]){
        List<Character> characterList = new ArrayList<>(); 
        try{
            Reader in = new FileReader("characters.csv"); 

            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build(); 
            Iterable<CSVRecord> records = CSVparser.parse(in); 
            for (CSVRecord record: records){ // Goes through each CSV record
                Character character = new Character(); // New character object

                // Set character attributes from CSV record fields
                character.setName(record.get("name"));
                character.setHeight(record.get("height"));
                character.setMass(record.get("mass"));
                character.setHairColor(record.get("hair_color"));
                character.setSkinColor(record.get("skin_color"));
                character.setEyeColor(record.get("eye_color"));
                character.setBirthYear(record.get("birth_year"));
                character.setGender(record.get("gender"));
                character.setHomeworld(record.get("homeworld"));
                character.setSpecies(record.get("species"));

                characterList.add(character); // Add character to the list
            }
        }
        catch(Exception E){} 

        try {
            Writer out = new FileWriter("characters.json"); 
            Gson gson = new Gson(); 
            gson.toJson(characterList, out); 
            out.close(); 
        }
        catch(Exception E){} 
    }
}
