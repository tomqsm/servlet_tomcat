(function($, undefined) {
    $.widget('qs.demo', {
        options: {
            width: 300,
            height: 300,
            viewportHeight: $(window).height(),
            viewportWidth: $(window).width()
        },
        _create: function() {
            this.element.html('<div class="demo redBorder">height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth + ' </div>');
            this.element.prependTo('body');
            var that = this;
            $(window).bind('resize', function(event) {

                that._setOption('viewportHeight',$(window).height());
                that._setOption('viewportWidth',$(window).width());
            });
            this.element.bind('mouseenter', function(event) {
                console.log("enetered");
            });

        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function(){
          this.element.find('div').text('height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth);
        },
        destroy: function() {
            this.element.html('<p>removed</p>');
            this._destroy();
        }
    });
}(jQuery));