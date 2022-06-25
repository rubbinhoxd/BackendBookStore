package backend

import javax.xml.bind.ValidationException
import static org.springframework.http.HttpStatus.*

class AutorController {

    AutorService autorService;

    static responseFormats = ["json"]; //formatos desejados
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]; //metodos que serão usados

    //lista all autor (get)
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100);
        respond autorService.list(params), model: [autorCount: autorService.count()];
    }
    //salva autor (post)
    def save(Autor autor){
        if(autor == null){
            render status: NOT_FOUND
            return
        }
        try {
            autorService.save(autor)
        }
        catch (ValidationException e) {
            respond autor.errors, view: 'create'
            return
        }
        respond autor, [status: CREATED, view: "show"]
    }
    //mostrar autor pelo id
    def show(Long id){
        respond autorService.get(id)
    }
    //put atualiza autor
    def update(Autor autor){
        if(autor == null){
            render status: NOT_FOUND
            return
        }
        try{
            autorService.save(autor)
        }
        catch (ValidationException e){
            respond autor.errors, view: 'edit'
            return
        }
        respond autor, [status: OK, view:"show"]
    }

    def delete(Long id){
        if(id == null){
            render status: NOT_FOUND
            return
        }
        autorService.delete(id)
        println("Autor excluído")
        render status: NO_CONTENT
    }


}
