import geb.Page

class IndexPage extends Page {
    static url = "/makumba/index"
    static at = { title == "Strona główna." }
    static content = {
        article { $("article") }
        navbarLinks { $("#navbar ul li a") }
//        navbar {$('#navbar .nav .navbar-nav',0)} //$("#header-content ul li", 0)
//        signinButton {$("button")}
    }
    
}

