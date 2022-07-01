package backend

import grails.gorm.services.Service

import javax.transaction.Transactional

@Transactional
class LivroService {

    Livro get(Serializable id){
        return Livro.get(id)
    }

    List<Livro> list(Map args){
        Livro.list();
    }

    Long count(){
        Livro.count();
    }

    Livro save(Livro livro){
        livro.save(flush:true, failOnError: true)
    }

    void delete(Serializable id){
        def livro = Livro.get(id)
        livro.delete();
    }


}