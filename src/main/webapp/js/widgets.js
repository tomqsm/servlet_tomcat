(function($, _) {
    $.widget('qs.showSize', {
        options: {
            viewportHeight: $(window).height(),
            viewportWidth: $(window).width(),
        },
        _create: function() {
            $(window).bind('resize', $.proxy(function(event) {
                this._setOption('viewportHeight', this.getViewport()[1]);
                this._setOption('viewportWidth', this.getViewport()[0]);
            }, this));
            this.element.bind('mouseenter', function(event) {
                console.log("enetered");
            });
            this.element.text('height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth);
            this.element.prependTo('body');
        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function() {
            this.element.text('height: ' + this.options.viewportHeight + ' width: ' + this.options.viewportWidth);
        },
        destroy: function() {
            this.element.remove();
            this._destroy();
        },
        getViewport: function() {
            //http://stackoverflow.com/questions/1766861/find-the-exact-height-and-width-of-the-viewport-in-a-cross-browser-way-no-proto
            var viewPortWidth, viewPortHeight;
            // the more standards compliant browsers (mozilla/netscape/opera/IE7) use window.innerWidth and window.innerHeight
            if (typeof window.innerWidth !== 'undefined') {
                viewPortWidth = window.innerWidth,
                        viewPortHeight = window.innerHeight;
            }
            // IE6 in standards compliant mode (i.e. with a valid doctype as the first line in the document)
            else if (typeof doc.documentElement !== 'undefined'
                    && typeof doc.documentElement.clientWidth !==
                    'undefined' && doc.documentElement.clientWidth !== 0) {
                viewPortWidth = doc.documentElement.clientWidth,
                        viewPortHeight = doc.documentElement.clientHeight;
            }
            // older versions of IE
            else {
                viewPortWidth = doc.getElementsByTagName('body')[0].clientWidth,
                        viewPortHeight = doc.getElementsByTagName('body')[0].clientHeight;
            }
            return [viewPortWidth, viewPortHeight];
        }
    });
    $.widget('qs.contextTest', {
        options: {
            context: appInit.context
        },
        _create: function() {

            this.element.bind('mouseenter', $.proxy(function(event) {
                console.log(this.options.context);
            }, this));
        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function() {
        },
        destroy: function() {
            this.element.remove();
            this._destroy();
        }
    });
    $.widget('qs.login', {
        options: {
            context: appInit.context
        },
        _create: function() {
            console.log('trying to load');
            this.element.load(appInit.context + "/login.html", function() {
                alert("Load was performed.");
            });
        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function() {
        },
        destroy: function() {
            this.element.remove();
            this._destroy();
        }
    });
}(jQuery, _));