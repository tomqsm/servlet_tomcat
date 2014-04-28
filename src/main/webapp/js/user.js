(function($, undefined) {
    $.widget('qs.demo', {
        options: {
            width: 300,
            height: 300
        },
        _create: function() {
            var name = this.name;
            this.element.html('<div style="height:300px, width:400px">test</div>');
            this.element.appendTo('body');

        },
        destroy: function() {
            this.element.html('<p>removed</p>');
            this._destroy();
        }
    });
}(jQuery));