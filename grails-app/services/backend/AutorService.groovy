package backend

import grails.gorm.services.Service

@Service (Autor)
interface AutorService {

    Autor get(Serializable id)

    List<Autor> list(Map args)

    Long count()

    Autor save(Autor autor)

    void delete(Serializable id)


}
