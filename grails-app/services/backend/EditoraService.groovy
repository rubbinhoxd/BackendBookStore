package backend

import javax.transaction.Transactional


@Transactional
class EditoraService {

    Editora get(Serializable id){
        return Editora.get(id);
    }

    List<Editora> list(Map args){
        return  Editora.list();
    }

    Long count(){
        return Editora.count();
    }

    Editora save(Editora editora){
        return editora.save(validate: false)
    }

    void delete(Serializable id){
        /*
        def editora = Editora.get(id)
        editora.delete(flush: true);
        */
        Editora.read(id)?.delete(failOnError: true)
    }
}
