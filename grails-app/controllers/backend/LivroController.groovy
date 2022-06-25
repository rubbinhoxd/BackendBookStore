package backend

import javax.xml.bind.ValidationException
import static org.springframework.http.HttpStatus.*

class LivroController {

    LivroService livroService;

    static responseFormats = ["json"]; //formatos desejados
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]; //metodos que serão usados

    //lista all livros
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100);
        respond livroService.list(params), model: [livroCount: livroService.count()];
    }
    //salva livro (post)
    def save(Livro livro){
        if(livro == null){
            render status: NOT_FOUND
            return
        }
        try {
            livroService.save(livro)
        }
        catch (ValidationException e) {
            respond livro.errors, view: 'create'
            return
        }
        respond livro, [status: CREATED, view: "show"]
    }
    //mostrar livro pelo id
    def show(Long id){
        respond livroService.get(id)
    }
    //put atualiza livro
    def update(Livro livro){
        if(livro == null){
            render status: NOT_FOUND
            return
        }
        try{
            livroService.save(livro)
        }
        catch (ValidationException e){
            respond livro.errors, view: 'edit'
            return
        }
        respond livro, [status: OK, view:"show"]
    }

    def delete(Long id){
        if(id == null){
            render status: NOT_FOUND
            return
        }
        livroService.delete(id)
        println("Livro excluído")
        render status: NO_CONTENT
    }

}

