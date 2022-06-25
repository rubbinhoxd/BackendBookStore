package backend

import grails.gorm.services.Service


@Service (Editora)
interface EditoraService {

    Editora get(Serializable id)

    List<Editora> list(Map args)

    Long count()

    Editora save(Editora editora)

    void delete(Serializable id)




}
