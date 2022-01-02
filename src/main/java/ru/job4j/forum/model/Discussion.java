package ru.job4j.forum.model;

public class Discussion {

    private int id;
    private int idPost;
    private String description;

    public Discussion(int idPost) {
        this.idPost = idPost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
