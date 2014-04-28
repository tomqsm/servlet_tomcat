(function($, undefined) {
    var viewportWidth = $(window).width();
    var viewportHeight = $(window).height();
    $.widget('qs.demo', {
        options: {
            width: 300,
            height: 300,
            viewportHeight: $(window).height()
        },
        _create: function() {
            this.element.html('<div class="demo redBorder">height: '+this.options.viewportHeight+' width: ' +viewportWidth+ ' </div>');
            this.element.prependTo('body');
            $(window).bind('resize', function(event){
                
            });
            this.element.bind('mouseenter', function(event) {
                console.log("enetered");
            });

        },
        _setOption: function(key, value) {
            // something to do on change
            if (key === 'viewportHeight') { // hipotetical 
                alert('height changed');
            }
            this._super(key, value);
        },
        destroy: function() {
            this.element.html('<p>removed</p>');
            this._destroy();
        }
    });
}(jQuery));