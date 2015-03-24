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
    $.widget("qs.loadJsonOnClick", {
        options: {
            callback: $.noop,
            template: $.noop,
            app_context: appInit['context'],
            url: 'ajax',
            data: '',
            ajaxloader: $('<img/>', {id: "ajaxloader", src: appInit['context'] + '/images/ajaxloader.gif', style: "visibility:hidden"})
        },
        _create: function() {
            _.templateSettings = {
                interpolate: /\<\@\=(.+?)\@\>/gim,
                evaluate: /\<\@([\s\S]+?)\@\>/gim,
                escape: /\<\@\-(.+?)\@\>/gim
            };
            this.element.bind('click', $.proxy(function() {
                this.get();
            }, this));
            this.element.bind('mouseenter', $.proxy(function() {
                this.element.css('cursor', 'pointer');
            }, this));
        },
        _setOption: function(key, value) {
            this.options[key] = value;
            this._update();
        },
        _update: function() {
            this.options.el = this.element;
        },
        get: function() {
            console.log('trying to load');
            this.element.prepend(this.options.ajaxloader);
            $('#fail-cause').remove(); // removes fail info
            this.options.ajaxloader.css('visibility', 'visible');
            var jqxhr = $.ajax({
                url: this.options['app_context'] + '/' + this.options.url,
                type: 'GET',
                timeout: 4000
            }).then(
                    $.proxy(function(data) {
                        this._setOption('data', data);
                        var funct = this.options['callback'];
                        if (funct instanceof Function) {
                            this.element.css('cursor', 'default');
                            this.element.unbind();
                            funct(this.element, data);
                            this.options.ajaxloader.remove();
                        }
                    }, this),
                    $.proxy(function(data) {
                        var cause = data.statusText + " ",
                        causeSpan = $('<div/>', {id: "fail-cause", class:"alert alert-warning", text:"Sorry, " + cause + "please try again later."});
                        causeSpan.append('<a href="#" class="close" data-dismiss="alert">&times;</a>');
                        this.element.after(causeSpan);
                    }, this),
                    $.proxy(function() {
                        this.options.ajaxloader.css('visibility', 'hidden');
                    }), this);
            jqxhr.always($.proxy(function() {
                this.options.ajaxloader.remove();
            }, this));
        },
        _destroy: function() {
            this.element.unbind();
            this.element.remove(this.options.ajaxloader);
            this._destroy();
        }
    });
}(jQuery, _));