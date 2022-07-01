package backend

import enums.Idiomas


class Livro {

    String titulo;
    Integer numPaginas;
    static hasMany = [autores:Autor];
    static belongsTo = [editora: Editora]; //sem autor E editora não tem livro
    Idiomas idioma; //enum do tipo idioma

    static constraints = {
        autores nullable: false, blank: false //n pode criar se n tiver autores e campos em branco n deixa
        editora nullable: false, blank: false //n pode criar se n tiver editora e campos em branco n deixa
        numPaginas min: 0; //numero minimo de paginas 0
    }



}


