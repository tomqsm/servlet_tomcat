var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(doc).ready(function() {
        var w = $('#showSize').showSize();
        $('.form-signin input').click(function(event) {
            event.stopPropagation();
        });
    });
})($, document, _);