package backend

import javax.xml.bind.ValidationException





import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class EditoraController {

    EditoraService editoraService;


    static responseFormats = ["json"]; //formatos desejados
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]; //metodos que serão usados

    //lista editoras
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100);
        respond editoraService.list(params), model: [editoraCount: editoraService.count()];
    }

    def save(Editora editora){
        if(editora == null){
            render status: NOT_FOUND
            return
        }
        try {
            editoraService.save(editora)
        }
        catch (ValidationException e) {
            respond editora.errors, view: 'create'
            return
        }
        respond editora, [status: CREATED, view: "show"]
    }
    //mostrar editora pelo id
    def show(Long id){
        respond editoraService.get(id)
    }
    //put atualiza editora
    def update(Editora editora){
        println(params)
        if(editora == null){
            render status: NOT_FOUND
            return
        }
        try{
            editoraService.save(editora)
        }
        catch (ValidationException e){
            respond editora.errors, view: 'edit'
            return
        }
        respond editora, [status: OK, view:"show"]
    }
    def delete(Long id){
        if(id == null){
            render status: NOT_FOUND
            return
        }
        editoraService.delete(id)
        println("Editora excluída")
        render status: NO_CONTENT
    }


}
