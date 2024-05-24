package ru.sber.test.app.sbertestapp.model;


public enum Genre {

    ACTION("Боевик"),
    COMEDY("Комедия"),
    DRAMA("Драма"),
    FANTASY("Фантастика"),
    HORROR("Ужасы"),
    MYSTERY("Фэнтэзи"),
    ROMANCE("Романтика"),
    THRILLER("Триллер"),
    WESTERN("Вэстерн");

    private final String filmDisplayGenre;
    Genre (String genre){
        this.filmDisplayGenre = genre;

    }

    public String getFilmDisplayGenre(){
        return filmDisplayGenre;
    }

    }
