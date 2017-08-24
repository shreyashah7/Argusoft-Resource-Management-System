/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/// for richfaces file upload customization (max one file) i.e hide AddUpload whenever something is already added.

if(RichFaces && RichFaces.ui && RichFaces.ui.FileUpload) {
    jQuery.extend(RichFaces.ui.FileUpload.prototype, {
        __updateButtons: function() {
            if(this.list.children(".rf-fu-itm").size()) {
                if (this.items.length) {
                    //                                        this.uploadButton.css("display", "inline-block");
                    this.uploadButton.click();
                    this.addButton.hide();
                                        
                } else {
                    this.uploadButton.hide();
                    this.addButton.hide();
                }
            }else{
                this.uploadButton.hide();
                this.addButton.show();
            }
                        
        }
    });  
}

////////////////////////////////

function disableEnter(e)
{
    var k;     
    if(window.event)
        k = window.event.keyCode; //IE
    else
        k = e.which; //FF    
 
    return (k != 13);
}

function isEnter(e)
{    
    var k;     
    if(window.event)
        k = window.event.keyCode; //IE
    else
        k = e.which; //FF    
 
    return (k == 13);
}

function counterForTextArea(fieldName,counter,limit)
{
    //        alert(document.getElementById(fieldName));
    if(document.getElementById(fieldName).value.length > limit){
        limitText(document.getElementById(fieldName), limit);
    }
    var browserName = navigator.appName;
    if (browserName == 'Netscape') {
        document.getElementById(counter).textContent =(limit- (document.getElementById(fieldName).value.length));
    } else {
        document.getElementById(counter).innerText =(limit- (document.getElementById(fieldName).value.length));
    }

}
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
    
}

function formatContact(e, objectId){
    
    var keyCode;
    if(window.event) {
        keyCode = window.event.keyCode;	// IE
    } else {
        keyCode = e.which;	 // Firefox
    }
    if(keyCode!=37 && keyCode!=39)
    {
        if (keyCode != 8) {
            var contact = document.getElementById(objectId).value;
            contact = contact.replace(/-/gi,"");
            if(contact.length > 3){
                contact = contact.substring(0,3) +'-'+contact.substring(3,contact.length);
            }
            if(contact.length > 6){
                contact = contact.replace(/-/gi,"");
                contact = contact.substring(0,3) +'-'+contact.substring(3,contact.length);
                contact = contact.substring(0,7) +'-'+contact.substring(7,contact.length);
            }
            if (contact.length > 12) {
                document.getElementById(objectId).value = contact.substring(0,12);
            } else {
                document.getElementById(objectId).value = contact;            
            }
        }
    }
}

function formatZipCode(e, objectId){
    
    var keyCode;
    if(window.event) {
        keyCode = window.event.keyCode;	// IE
    } else {
        keyCode = e.which;	 // Firefox
    }
    if(keyCode!=37 && keyCode!=39)
    {
        if (keyCode != 8) {
            var zipCode = document.getElementById(objectId).value;
            zipCode = zipCode.replace(/-/gi,"");
            if(zipCode.length > 5){
                zipCode = zipCode.substring(0,5) +'-'+zipCode.substring(5,zipCode.length);
            }
            if (zipCode.length > 10) {
                document.getElementById(objectId).value = zipCode.substring(0,10);
            } else {
                document.getElementById(objectId).value = zipCode;            
            }
        }
    }
}


function loadWaitPanel(id)
{
    $("#"+id).mask("Loading...");
}
    
function stopWaitPanel(id)
{
    $("#"+id).unmask();
}


function roundNumber(num, dec) {
    var result = Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);
    return result;
}

function textboxHint(id, options) {
    var o = {
        selector: 'input:text[title]', 
        blurClass:'blur'
    }, $e = $('#'+id);
    $.extend(true, o, options || {});
  			
    if ($e.is(':text')) {
        if (!$e.attr('title')) $e = null;
    } else {
        $e = $e.find(o.selector);
    }
    if ($e) {
  
        $e.each(function() {
            var $t = $(this);
  
            if ($.trim($t.val()).length == 0) {
                $t.val($t.attr('title'));
            }
  
            if ($t.val() == $t.attr('title')) {
                $t.addClass(o.blurClass);
            } else {
                $t.removeClass(o.blurClass);
            }
  
            $t.focus(function(){
                if ($.trim($t.val()) == $t.attr('title')) {
                    $t.val('');
                    $t.removeClass(o.blurClass);
                }
            }).blur(function() {
                var val = $.trim($t.val());
                if (val.length == 0 || val == $t.attr('title')) {
                    $t.val($t.attr('title'));
                    $t.addClass(o.blurClass);
                }
            });
  					
            $(this.form).submit(function(){
                if ($.trim($t.val()) == $t.attr('title')) $t.val('');
            });
        });
    }		
}
function clearBlurredData(id) {

    var o = {
        selector: 'input:text[title]', 
        blurClass:'blur'
    }, $e = $('#'+id);
    //    $.extend(true, o, options || {});
  			
    if ($e.is(':text')) {
        if (!$e.attr('title')) $e = null;
    } else {
        $e = $e.find(o.selector);
    }
    if ($e) {
  
        $e.each(function() {
            var $t = $(this);
            if ($.trim($t.val()) == $t.attr('title')) $t.val('');
        });
    }
}

function convertToLowerCase(id) {
    document.getElementById(id).value = document.getElementById(id).value.toLowerCase();
}

function convertToLowerCase(id,event) {
    if(event.keyCode!=37 && event.keyCode!=39)
    {
        document.getElementById(id).value = document.getElementById(id).value.toLowerCase();
    }
}

function getDatePickerForRange(fromDateId,toDateId)
{
    var dates = $( '#'+fromDateId+',#'+toDateId ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        numberOfMonths: 1,
        required:true,
        onSelect: function( selectedDate ) {
            var option = this.id == fromDateId ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    })
    .attr( 'readOnly' , 'true' );
}
function getDatePickerForRangeWithFormat(fromDateId,toDateId)
{
    var dates = $( '#'+fromDateId+',#'+toDateId ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd-mm-yy',
        numberOfMonths: 1,
        required:true,
        onSelect: function( selectedDate ) {
            var option = this.id == fromDateId ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    })
    .attr( 'readOnly' , 'true' );
}

function getDatePickerForRangeForFuture(fromDateId,toDateId)
{    
    var dates = $( '#'+fromDateId+',#'+toDateId ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        maxDate:+0,
        numberOfMonths: 1,
        required:true,
        onSelect: function( selectedDate ) {
            var option = this.id == fromDateId ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    })
    .attr( 'readOnly' , 'true' );
}

function getEnabledDatesForRange(fromDateId,toDateId)
{    
    var from= document.getElementById(fromDateId).value;
    var to= document.getElementById(toDateId).value;
    var dates = $( '#'+fromDateId+',#'+toDateId ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        minDate:from,
        maxDate:to,
        numberOfMonths: 1,
        required:true,
        onSelect: function( selectedDate ) {
            var option = this.id == fromDateId ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    })
    .attr( 'readOnly' , 'true' );
}

function getDatePickerForFutureDate(id) {
    id = "#" + id;
    $(id).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        minDate:+0,
        height: 200,
        width:200
                       
    })
    .attr( 'readOnly' , 'true' );
}

function getDatePicker(id){
    id = "#" + id;
    $(id).datepicker();
}

function getDatePickerForFuture(id){
    id = "#" + id;
    $(id).datepicker({
        minDate: 0
    }).attr('readonly', 'true');
}

function getDateTimePicker12hr(id){
    id = "#" + id;
    $(id).datetimepicker({
        ampm:true
    }).attr('readonly', 'true');
}

function getDatePickerForFutureAllocation(id){
    id = "#" + id;
    $(id).datepicker({
        dateFormat: 'dd/mm/yy',
        minDate: 0
    }).attr('readonly', 'true');
}

function getDateTimePickerForFuture12hrAllocation(id){
    id = "#" + id;
    $(id).datetimepicker({
        dateFormat: 'dd/mm/yy',
        minDate: 0,
        ampm:true
    }).attr('readonly', 'true');
}

function getMultiselect(id){
    id = "#" + id;
    jQuery(id).multiselect();
}

function trim (str)  
{  
    str = str.replace(/^\s+/, '');
    for (var i = str.length - 1; i >= 0; i--) {
        if (/\S/.test(str.charAt(i))) {
            str = str.substring(0, i + 1);
            break;
        }
    }
    return str;
}

jQuery.fn.dataTableExt.oSort['numeric-comma-asc']  = function(a,b) {
    var x = (a == "-") ? 0 : a.replace( /,/, "" );
    var y = (b == "-") ? 0 : b.replace( /,/, "" );
    x = parseFloat( x );
    y = parseFloat( y );
    return ((x < y) ? -1 : ((x > y) ?  1 : 0));
}
                   
jQuery.fn.dataTableExt.oSort['numeric-comma-desc'] = function(a,b) {
    var x = (a == "-") ? 0 : a.replace( /,/, "" );
    var y = (b == "-") ? 0 : b.replace( /,/, "" );
    x = parseFloat( x );
    y = parseFloat( y );
    return ((x < y) ?  1 : ((x > y) ? -1 : 0));
}; 

function calculate_date(date) {
    var date = date.replace(" ", "");
     
    if (date.indexOf('.') > 0) {
        /*date a, format dd.mn.(yyyy) ; (year is optional)*/
        var eu_date = date.split('.');
    } else {
        /*date a, format dd/mn/(yyyy) ; (year is optional)*/
        var eu_date = date.split('/');
    }
     
    /*year (optional)*/
    if (eu_date[2]) {
        var year = eu_date[2];
    } else {
        var year = 0;
    }
     
    /*month*/
    var month = eu_date[1];
    if (month.length == 1) {
        month = 0+month;
    }
     
    /*day*/
    var day = eu_date[0];
    if (day.length == 1) {
        day = 0+day;
    }
     
    return (year + month + day) * 1;
}
 
jQuery.fn.dataTableExt.oSort['eu_date-asc'] = function(a, b) {
    x = calculate_date(a);
    y = calculate_date(b);
     
    return ((x < y) ? -1 : ((x > y) ?  1 : 0));
};
 
jQuery.fn.dataTableExt.oSort['eu_date-desc'] = function(a, b) {
    x = calculate_date(a);
    y = calculate_date(b);
     
    return ((x < y) ? 1 : ((x > y) ?  -1 : 0));
};
//start roobroo
var cawLocation;
var examinerId;
var candidateId;
var cawKey;
var cawReturnUrl;
var type = "1";
var cawparam;
var displayName; 
var cawPath;

function callCAWApplicationForExaminer(url,examinerUserId,candidateUserId,key,cawurl,examinerName,cawUserNameForExaminer,cawPasswordForExaminer,cawCloseIframeUrl) {    
    cawPath = cawurl;
    examinerId = examinerUserId;
    candidateId = candidateUserId;
    cawKey = key;
    cawLocation = cawurl + "/cw/runRoobroo.zip";
    cawReturnUrl = url + '?notificationId=' + key;
    displayName = 'Examiner';
    cawparam = type + "#~" + examinerId + "#~" + candidateId + "#~" + cawKey + "#~" +  cawReturnUrl + "#~" +  displayName;        
    loadIframeForExaminer(cawKey,displayName,cawReturnUrl,cawurl,cawUserNameForExaminer,cawPasswordForExaminer,cawCloseIframeUrl);
}

function callCAWApplicationForCandidate(url,examinerUserId,candidateUserId,key,cawurl,candidateName,cawUserNameForCandidate,cawPasswordForCandidate,cawCloseIframeUrl) { 
    cawPath = cawurl;
    examinerId = examinerUserId;
    candidateId = candidateUserId;
    cawKey = key;    
    cawReturnUrl = url + '?notificationId=' + key;
    cawLocation = cawurl + "/cw/runRoobroo.zip";
    displayName = 'Candidate';
    cawparam = type + "#~" + candidateId + "#~" + examinerId + "#~" + cawKey + "#~" +  cawReturnUrl + "#~" +  displayName;    
    loadIframeForCandidate(cawKey,displayName,cawReturnUrl,cawurl,cawUserNameForCandidate,cawPasswordForCandidate,cawCloseIframeUrl);
}
function loadIframeForExaminer(key,displayName,url,cawPath,cawUserNameForExaminer,cawPasswordForExaminer,cawCloseIframeUrl){            
    var urlSrc = cawPath + "/enterIntoNewMeeting.jsp?param1=" + cawUserNameForExaminer + "&#38;param2=" + cawPasswordForExaminer + "&#38;param3=" + key + "&#38;param4=" + displayName + "&#38;param5=true&#38;param6=Scope&#38;param7=" + url + "&#38;param8=" + cawCloseIframeUrl;        
    document.getElementById('frameDiv').innerHTML = '<iframe id="frameId" src="'+urlSrc+'" width="0px" height="0px"><p>Your browser does not support iframes.</p></iframe>';
}

function loadIframeForCandidate(key,displayName,url,cawPath,cawUserNameForCandidate,cawPasswordForCandidate,cawCloseIframeUrl){                    
    var urlSrc = cawPath + "/enterIntoNewMeeting.jsp?param1=" + cawUserNameForCandidate + "&#38;param2=" + cawPasswordForCandidate + "&#38;param3=" + key + "&#38;param4=" + displayName + "&#38;param5=false&#38;param6=Scope&#38;param7=" + url + "&#38;param8=" + cawCloseIframeUrl;    
    document.getElementById("frameDiv").innerHTML = '<iframe id="frameId" src="'+urlSrc+'" width="0px" height="0px"><p>Your browser does not support iframes.</p></iframe>';
}

function getDatePickerForRangeWithCurrentDateReference(fromDateId,toDateId)
{    
    var dates = $( '#'+fromDateId+',#'+toDateId ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        numberOfMonths: 1,
        required:true,
        onSelect: function( selectedDate ) {
            var option = this.id == fromDateId ? "minDate" : "maxDate",
            instance = $( this ).data( "datepicker" ),
            date = $.datepicker.parseDate(
                instance.settings.dateFormat ||
                $.datepicker._defaults.dateFormat,
                selectedDate, instance.settings );
            dates.not( this ).datepicker( "option", option, date );
        }
    })
    .attr( 'readOnly' , 'true' );
}
