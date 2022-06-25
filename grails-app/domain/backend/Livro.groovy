package backend

import enums.Idiomas


class Livro {

    String titulo;
    Integer numPaginas;
    //static hasMany = [autores:Autor];
    //static belongsTo = [Autor, Editora]; //sem autor E editora não tem livro
    Idiomas idioma; //enum do tipo idioma

    static constraints = {
    }



}


