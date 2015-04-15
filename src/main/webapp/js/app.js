var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(doc).ready(function() {
////       $("#maincontainer > div:nth-child(2) > h1").text('makumba');
        $('input[type="email"]').bind('invalid', function() {
//            alert('invalid email ' + this.value);
            this.validationMessage = 'makumba';
            return false;
        });
        $('input[type="password"]').bind('invalid', function() {
//            alert('invalid password');
            return false;
        });

    });
})($, document, _);