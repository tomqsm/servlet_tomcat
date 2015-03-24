var app = (function f($, doc, _) {
    $(doc).on("focus", "#menu li.selected", function() {
        console.log('initialise something on focus');
    });
    $(doc).ready(function() {
        initialiseWidges();
    });
    function initialiseWidges() {
        var w = $('#showSize').showSize();
        var l = $('#loadJsonOnClick').loadJsonOnClick(
                {url: "json/user", callback: function(thisEl,data) {
                        thisEl.text(data.date);
                    }}
        );
        var l = $('#loadJsonOnClick7secDelay').loadJsonOnClick(
                {url: "json/user/delayed/5/sec", callback: function(thisEl,data) {
                        thisEl.text(data.date);
                    }}
        );

    }
})($, document, _);