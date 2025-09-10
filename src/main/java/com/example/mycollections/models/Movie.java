package com.example.mycollections.models;

public class Movie extends LibraryItem {
    //Setting up auto-incrementing id. Food for thought: if all of our child classes will have an id, should we make
    //this here or our parent class? I've added the ID to the HTML returned in MovieController just so we can see it.
    private static int nextId = 1;

    private final int id;
    private String director;
    private int runtime;


    public Movie(String name, int year, String director, int runtime) {
        super(name, year);
        this.id = nextId;
        this.director = director;
        this.runtime = runtime;
        //Increment nextId to make sure subsequent objects have a new id!
        nextId++;
    }

    //Getter for id
    public int getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    //To String method now prints our movie info rather than memory location. Keep in mind that printing this string as a
    //list item, as we do in this practice, will print it all on one line, even though the triple """ acts as a kind of
    // template literal that is sensitive to newlines. I've gone ahead and modified the HTML returned in MovieController
    // to have nested lists.
    @Override
    public String toString() {
        return String.format("""
                %s
                Year: %d
                Director: %s
                Runtime: %d minutes
                """, name, year, director, runtime);
    }
}
