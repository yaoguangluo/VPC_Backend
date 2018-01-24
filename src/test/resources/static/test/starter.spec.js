document.writeln("<script type='text/javascript' src='base/src/main/resources/static/test/starter.js'></script>");
document.writeln("<div id=\"push_value\" ng-app=\"push_value\" ng-controller=\"push_value\" ng-click=\"click()\">{{info}}</div>");

describe('hello world', function () {
    it('should contains world', function () {
        expect('Hello world').toContain('world');
        expect(greet(1)).toContain('llo');
    });
});