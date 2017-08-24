/***************************/
//@Author: Adrian "yEnS" Mato Gondelle
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;

var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	
	if(popupStatus==0){
		$(".backgroundPopup").css({
			"opacity": "0.7"
		});
		$(".backgroundPopup").fadeIn("fast");
		$(".popupContact").fadeIn("fast");
		popupStatus = 1;
	}
	centerPopup();
}

function loadPopup1(){
	//loads popup only if it is disabled
	
	if(popupStatus==0){
		$(".backgroundPopup1").css({
			"opacity": "0.7"
		});
		$(".backgroundPopup1").fadeIn("fast");
		$(".popupContact1").fadeIn("fast");
		popupStatus = 1;
	}
	centerPopup1();
}
function loadPopup2(){
	//loads popup only if it is disabled
	
	if(popupStatus==0){
		$(".backgroundPopup2").css({
			"opacity": "0.7"
		});
		$(".backgroundPopup2").fadeIn("fast");
		$(".popupContact2").fadeIn("fast");
		popupStatus = 1;
	}
	centerPopup2();
}
function loadPopup3(){
	//loads popup only if it is disabled
	
	if(popupStatus==0){
		$(".backgroundPopup3").css({
			"opacity": "0.7"
		});
		$(".backgroundPopup3").fadeIn("fast");
		$(".popupContact3").fadeIn("fast");
		popupStatus = 1;
	}
	centerPopup3();
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$(".backgroundPopup").fadeOut("fast");
		$(".popupContact").fadeOut("fast");
		popupStatus = 0;
	}
}
function disablePopup1(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$(".backgroundPopup1").fadeOut("fast");
		$(".popupContact1").fadeOut("fast");
		popupStatus = 0;
	}
}

function disablePopup2(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$(".backgroundPopup2").fadeOut("fast");
		$(".popupContact2").fadeOut("fast");
		popupStatus = 0;
	}
}
function disablePopup3(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$(".backgroundPopup3").fadeOut("fast");
		$(".popupContact3").fadeOut("fast");
		popupStatus = 0;
	}
}
//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $(".popupContact").height();
	var popupWidth = $(".popupContact").width();
	//centering
	$(".popupContact").css({
	"position": "absolute",
	"top": windowHeight/2-popupHeight/2,
	"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$(".backgroundPopup").css({
		"height": windowHeight
	});
	
}
function centerPopup1(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $(".popupContact1").height();
	var popupWidth = $(".popupContact1").width();
	//centering
	$(".popupContact1").css({
	"position": "absolute",
	"top": windowHeight/2-popupHeight/2,
	"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$(".backgroundPopup1").css({
		"height": windowHeight
	});
	
}
function centerPopup2(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $(".popupContact2").height();
	var popupWidth = $(".popupContact2").width();
	//centering
	$(".popupContact2").css({
	"position": "absolute",
	"top": windowHeight/2-popupHeight/2,
	"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$(".backgroundPopup2").css({
		"height": windowHeight
	});
	
}
function centerPopup3(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $(".popupContact3").height();
	var popupWidth = $(".popupContact3").width();
	//centering
	$(".popupContact3").css({
	"position": "absolute",
	"top": windowHeight/2-popupHeight/2,
	"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$(".backgroundPopup3").css({
		"height": windowHeight
	});
	
}
//CONTROLLING EVENTS IN jQuery
$(document).ready(function(){
	
	//LOADING POPUP
	//Click the button event!
	$("#button").click(function(){
		//centering with css
		//centerPopup();
		//load popup
		loadPopup();
	});
				
				$("#button1").click(function(){
		//centering with css
		//centerPopup();
		//load popup
		loadPopup1();
	});
				$("#button2").click(function(){
		//centering with css
		//centerPopup();
		//load popup
		loadPopup2();
	});
				$("#button3").click(function(){
		//centering with css
		//centerPopup();
		//load popup
		loadPopup3();
	});
	//CLOSING POPUP
	//Click the x event!
	$(".popupContactClose").click(function(){
		disablePopup();
	});
	$(".popupContactClosebutton").click(function(){
		disablePopup();
	});
	$("#ok-button").click(function(){
		disablePopup();
	});
	$("#ok-button1").click(function(){
		disablePopup1();
	});
	$("#ok-button2").click(function(){
		disablePopup2();
	});
	$("#ok-button3").click(function(){
		disablePopup3();
	});
	//Click out event!
	$(".backgroundPopup").click(function(){
		disablePopup();
		
	});
	$(".backgroundPopup1").click(function(){
		disablePopup1();
		
	});
	$(".backgroundPopup2").click(function(){
		disablePopup2();
		
	});
	$(".backgroundPopup3").click(function(){
		disablePopup3();
		
	});
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});

});