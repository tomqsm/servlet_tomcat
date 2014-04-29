(function($, _) {
    $.widget('qs.demo', {
        options: {
            width: 300,
            height: 300,
            viewportHeight: $(window).height(),
            viewportWidth: $(window).width(),
            ajaxList: [
                {name: "Alexander"},
                {name: "Barklay"},
                {name: "Chester"},
                {name: "Domingo"},
                {name: "Edwardo"},
                {name: "..."},
                {name: "Yolando"},
                {name: "Zachary"}
            ]
        },
        _create: function() {
            var sum = _.reduce([1, 2, 3], function(memo, num) {
                    return memo + num
                }, []);
                console.log(sum);
            this.element.html('<div class="demo redBorder">height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth + ' </div>');
            this.element.prependTo('body');
            var that = this;
            $(window).bind('resize', function(event) {

                that._setOption('viewportHeight', $(window).height());
                that._setOption('viewportWidth', $(window).width());
            });
            this.element.bind('mouseenter', function(event) {
                console.log("enetered");
            });
            $("#target").html(_.template($("#usageList").html(), {items: this.options.ajaxList}));
        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function() {
            this.element.find('div').text('height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth);
        },
        destroy: function() {
            this.element.remove();
            this._destroy();
        }
    });
}(jQuery, _));