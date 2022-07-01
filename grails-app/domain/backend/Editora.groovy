package backend

class Editora {

    String nome;
    String endereco;
    static hasMany = [livros:Livro] //uma editora pode ter varios livros

    static constraints = {
        livros nullable: true
        nome nullable: false, blank: false;
        endereco nullable: false, blank: false;
    }
}
