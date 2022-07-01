package backend

import grails.gorm.services.Service

import javax.transaction.Transactional

@Transactional
class AutorService {

    Autor get(Serializable id){
        return Autor.get(id);
    }

    List<Autor> list(Map args){
        Autor.list();
    }

    Long count(){
        Autor.count();
    }

    Autor save(Autor autor){
        autor.save(flush:true, failOnError: true)
    }

    void delete(Serializable id){
        def autor = Autor.get(id)
        autor.delete();
    }


}







