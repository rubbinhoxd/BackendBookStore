package backend

class Autor {

    String nome;
    String dataNasc;
    static hasMany = [livros:Livro]; //um autor pode ter varios livros


    static constraints = {
    }
}
