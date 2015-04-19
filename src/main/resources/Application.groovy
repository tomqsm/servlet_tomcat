grails.webflow.stateless = true
smtp {
    mail.host = 'smtp.myisp.com'
    mail.auth.user = 'server'
}
resources.URL = "http://localhost:80/resources"
binding {
t = test()
}
def test() {"Hello ${date}"}