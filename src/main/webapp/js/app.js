var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(document).ready(function() {

        $('a.back').click(function(event) {
            event.preventDefault();
            history.back(1);
        });
        
    });
})($, document, _);