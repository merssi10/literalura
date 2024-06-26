package com.alura.literalura.service;

import java.util.List;

public class GutendexBook {
    private String title;
    private List<Author> authors;
    private List<String> languages;
    private int download_count;

    // Getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public static class Author {
        private String name;

        // Getters y setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
