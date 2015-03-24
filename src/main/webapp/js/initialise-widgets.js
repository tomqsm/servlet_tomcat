var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(doc).ready(function() {
        initialiseWidges();
    });
    function initialiseWidges(){
        var w = $('#showSize').showSize();
    }
})($, document, _);