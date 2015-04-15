var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(doc).ready(function() {
            alert('yhm');
//       $("#maincontainer > div:nth-child(2) > h1").text('makumba');
        $('input[type="email"]').bind('invalid', function() {
            alert('yhm');
            return false;
        });

    });
})($, document, _);