package backend

class Autor {

    String nome;
    String dataNasc;
    static hasMany = [livros:Livro]; //um autor pode ter varios livros


    static constraints = {
        livros nullable: true, blank: true //podemos criar autores sem livros linkados a ele
        nome nullable: false, blank: false
        dataNasc nullable: false, blank: false
    }
}
