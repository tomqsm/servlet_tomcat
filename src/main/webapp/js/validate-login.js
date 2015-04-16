var app = (function f($, doc, _) {
    $(doc).ready(function() {
        $("#loginForm").validate();
    });
})($, document, _);