package backend

class UrlMappings {

    static mappings = {
        //rotas
        get "/$controller(.$format)?"(action:"index")
        post "/$controller(.$format)?"(action:"save")
        get "/$controller/$id(.$format)?"(action:"show")
        delete "/$controller/$id(.$format)?"(action:"delete")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

