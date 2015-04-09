var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(document).ready(function() {

//       $("#maincontainer > div:nth-child(2) > h1").text('makumba');

    });
})($, document, _);