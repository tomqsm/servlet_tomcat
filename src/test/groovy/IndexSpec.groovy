import geb.spock.GebReportingSpec

class IndexSpec extends GebReportingSpec {

    def "can get to the Index Page"() {
        when:
        def page = to IndexPage

        then:
        at IndexPage
        page.article.size() == 1        
    }
    def "can get to cennik"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[1].click()
        
        then: 
        at CennikPage
    }
    def "can get to firma"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[2].click()
        
        then: 
        at FirmaPage
    }
    def "can get to realizacje"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[3].click()
        
        then: 
        at RealizacjePage
    }
    def "can get to kontakt"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[4].click()
        
        then: 
        at KontaktPage
    }

    def "can get to oferta"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[5].click()
        
        then: 
        at IndexPage
    }
    def "can get to oferta - cyklinowanie"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[5].click()
//                interact{
//                    moveToElement( $(".dropdown-menu li a", 0).click() )
//                }
        $(".dropdown-menu li a", 0).click()
        then: 
        at CyklinowaniePage
    }
    def "can get to oferta - lakierowanie"(){
        when:
        def page = to IndexPage
        
        and:
        page.navbarLinks[5].click()
        $(".dropdown-menu li a", 1).click()
        then: 
        at LakierowaniePage
    }

}