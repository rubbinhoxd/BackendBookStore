package backend

import grails.gorm.services.Service

@Service (Livro)
interface LivroService {

    Livro get(Serializable id)

    List<Livro> list(Map args)

    Long count()

    Livro save(Livro livro)

    void delete(Serializable id)


}
