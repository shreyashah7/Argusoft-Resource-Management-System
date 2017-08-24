/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $ = jQuery;
    $(":input.required").each(function() {
        comp(this);
    });
    $(":input.required").blur(function() {
        comp(this);
    });
    $(":input.required").keyup(function() {
        comp(this);
    });
    $(":input.required").click(function() {
        comp(this);
    });

    function comp(a) {
        if ($(a).val() !== "") {

            $(a).css({
                "border-top-color": "#cccccc",
                "border-right-color": "#cccccc",
                "border-bottom-color": "#cccccc",
                "border-left-color": "#cccccc",
                "border": "1px solid #cccccc !important",
                "background": "#FFF"
            });
        }
        else {
            $(a).css({
                "border-top-color": "#cd0a0a",
                "border-right-color": "#cd0a0a",
                "border-bottom-color": "#cd0a0a",
                "border-left-color": "#cd0a0a",
                "border": "1px solid #FF0000 !important",
                "background": "#FFF"
            });
        }
    }
});