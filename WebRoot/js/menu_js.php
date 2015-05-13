//Tool Menu (Javascript) is Copyright 2012 TextMechanic.com All Rights Reserved

var mycntry = 'NOTUS';

var windo = 'target="_self"';
var windochk = '';
function windotargt(){
if(document.getElementById('newwin').checked == true){
windo = 'target="_blank"';
windochk = 'CHECKED';
} else {
windo = 'target="_self"';
windochk = '';}}

var supporter = '';
function readCookie(name){
var nameEQ = name + "=";
var ca = document.cookie.split(';');
for(var i=0;i < ca.length;i++){
var c = ca[i];
while (c.charAt(0)==' ') c = c.substring(1,c.length);
if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);}
return null;}

function createCookie(name,value,days){
if(days){
var date = new Date();
date.setTime(date.getTime()+(days*24*60*60*1000));
var expires = "; expires="+date.toGMTString();}
else var expires = "";
document.cookie = name+"="+value+expires+"; path=/";
document.getElementById('mesge').innerHTML = '';
supporter = setTimeout('readCookie(\'supporte\')',100);
setTimeout('resizepage()',150);}

function loadmenu(){
supporter = readCookie('supporter');
if(document.all){
document.styleSheets[0].addRule('.nav','display:block; margin:0px; padding:0px; background-color:#ECE9D8; text-decoration:none;');
document.styleSheets[0].addRule('.navhover','display:block; margin:0px; padding:0px; background-color:#FFFFFF; text-decoration:none;');
} else {
document.styleSheets[0].insertRule('.nav {display:block; margin:0px; padding:0px; background-color:#ECE9D8; text-decoration:none;}',0);
document.styleSheets[0].insertRule('.navhover {display:block; margin:0px; padding:0px; background-color:#FFFFFF; text-decoration:none;}',0);}
var suprtblk =
'<div style="padding:0px 0px 0px 10px; font-size:16px; font-weight:bold; font-style:italic;">Support This Website:</div>'+
'<a rel="nofollow" ' + 'target="_blank" ' + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://www.amazon.com/?_encoding=UTF8&camp=1789&creative=9325&linkCode=ur2&tag=textmechanic-20" onClick="createCookie(\'supporter\',\'yes\',1);"><span style="padding-left:10px;">Browse &amp; Shop Amazon.com</span></a>'+
'<a rel="nofollow" ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Amazon-Affiliate-Disclosure.html"><span style="padding-left:10px;">Amazon Affiliate Disclosure</span></a>';
if(mycntry != 'US') suprtblk = '';
document.getElementById('menu').innerHTML =
'<nav>'+
'<a ' + windo + ' href="http://textmechanic.com/"><img src="http://textmechanic.com/TMLogo.png" alt="" style="width:210px; height:48px; margin:10px 0px 0px 10px; border:0px;" /></a>'+
'<div style="padding:5px 0px 0px 10px; font-size:14px;"><input type="checkbox" id="newwin" style="padding:0px; margin:0px;" onClick="windotargt(); setTimeout(\'loadmenu()\',100);" ' + windochk + ' /> Open tools in new window.</div>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/"><span style="padding-left:10px;">Homepage | Descriptive Index</span></a>'+
suprtblk +
'<div style="padding:0px 0px 0px 10px; font-size:16px; font-weight:bold; font-style:italic; clear:left;">Text Line Tools:</div>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Add-Prefix-Suffix-to-Text.html"><span style="padding-left:10px;">Add Prefix/Suffix into Line</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Add-Remove-Line-Breaks.html"><span style="padding-left:10px;">Add/Remove Line Breaks</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Count-Text.html"><span style="padding-left:10px;">Count Characters...Lines</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Merge-Text-Line-by-Line.html"><span style="padding-left:10px;">Merge Text (Line by Line)</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Number-Each-Line.html"><span style="padding-left:10px;">Number Each Line</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Remove-Duplicate-Lines.html"><span style="padding-left:10px;">Remove Duplicate Lines</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Remove-Empty-Lines.html"><span style="padding-left:10px;">Remove Empty Lines</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Remove-Lines-of-Text-Containing.html"><span style="padding-left:10px;">Remove Lines Containing...</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Sort-Text-Lines.html"><span style="padding-left:10px;">Sort Text Lines</span></a>'+
'<div style="padding:0px 0px 0px 10px; font-size:16px; font-weight:bold; font-style:italic;">Text Randomizing Tools:</div>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Random-Line-Picker.html"><span style="padding-left:10px;">Random Line Picker</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Random-Number-Generator.html"><span style="padding-left:10px;">Random Number Generator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Random-String-Generator.html"><span style="padding-left:10px;">Random String Generator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Randomize-List.html"><span style="padding-left:10px;">Randomize List</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/String-Randomizer.html"><span style="padding-left:10px;">String Randomizer</span></a>'+
'<div style="padding:0px 0px 0px 10px; font-size:16px; font-weight:bold; font-style:italic;">Text Obfuscation Tools:</div>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Binary-Code-Translator.html"><span style="padding-left:10px;">Binary Code Translator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Encryption-Generator.html"><span style="padding-left:10px;">Encryption Generator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Reverse-Text-Generator.html"><span style="padding-left:10px;">Reverse Text Generator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/ROT13-Caesar-Cipher.html"><span style="padding-left:10px;">ROT13 Caesar Cipher</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Word-Scrambler.html"><span style="padding-left:10px;">Word Scrambler/Descrambler</span></a>'+
'<div style="padding:0px 0px 0px 10px; font-size:16px; font-weight:bold; font-style:italic;">Other Text Tools:</div>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/ASCII-Hex-Unicode-Base64-Converter.html"><span style="padding-left:10px;">ASCII, Hex, Unicode...Converter</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Delimited-Column-Extractor-Tool.html"><span style="padding-left:10px;">Delimited Column Extractor</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Find-and-Replace-Text.html"><span style="padding-left:10px;">Find and Replace Text</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Generate-List-of-Numbers.html"><span style="padding-left:10px;">Generate List of Numbers</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Letter-Case-Converter.html"><span style="padding-left:10px;">Letter Case Converter</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Permutation-Generator.html"><span style="padding-left:10px;">Permutation Generator</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Remove-Extra-Spaces.html"><span style="padding-left:10px;">Remove Extra Spaces</span></a>'+
'<a ' + windo + ' class="nav" onMouseover="this.className=\'navhover\'" onMouseout="this.className=\'nav\'" href="http://textmechanic.com/Remove-Letter-Accents.html"><span style="padding-left:10px;">Remove Letter Accents</span></a>'+
'<div>&nbsp;</div>'+
'</nav>';
document.getElementById('footer').innerHTML =
'<footer>'+
'<div style="padding:10px 0px 0px 0px;">Tools provided "as-is" without warranty of any kind and used at your own risk. &copy;2012 <a href="http://textmechanic.com" style="color:#0000FF;">TextMechanic.com</a> | <a rel="nofollow" target="_blank" href="http://textmechanic.com/Privacy-Policy.html" style="color:#0000FF;">Privacy Policy</a></div>'+
'</footer>';
var client_height = document.body.parentNode.clientHeight;
document.getElementById('menu').style.height = client_height + 'px';
document.getElementById('tool').style.height = client_height + 'px';
var hgtvar = 90;
adjhgt(hgtvar);
if(supporter == null && mycntry == 'US') document.getElementById('mesge').innerHTML = '<div style="padding:7px 5px 7px 10px; font-size:16px; font-weight:bold; background-color:#FFFFCC;">Support this website by always browsing/shopping Amazon.com via it\'s <a rel="nofollow" target="_blank" href="http://www.amazon.com/?_encoding=UTF8&camp=1789&creative=9325&linkCode=ur2&tag=textmechanic-20" style="color:#0000FF;" onClick="createCookie(\'supporter\',\'yes\',1);">Amazon associate entrance</a>.</div>';
resizepage();}

window.onresize = resizepage;
function resizepage(){
var client_width = document.body.parentNode.clientWidth;
if(client_width < 800){
document.getElementById('menu').style.width = '125px';
document.getElementById('toolpadding').style.paddingLeft = '135px';
if(client_width < 800){
document.getElementById('mesge').style.width = '800px';
document.getElementById('tool').style.width = '800px';
} else {
document.getElementById('mesge').style.width = '100%';
document.getElementById('tool').style.width = '100%';}
} else {
document.getElementById('menu').style.width = '250px';
document.getElementById('toolpadding').style.paddingLeft = '260px';
if(client_width >= 800){
document.getElementById('mesge').style.width = '100%';
document.getElementById('tool').style.width = '100%';}}
var client_height = document.body.parentNode.clientHeight;
var mesge_height = document.getElementById('mesge').clientHeight;
if(client_height > 400 + mesge_height){
client_height = client_height - mesge_height;
} else {
client_height = client_height;
mesge_height = 0;}
var hgtvar = 90 - mesge_height;
adjhgt(hgtvar);
if(client_height > 400){
document.getElementById('menu').style.top = mesge_height + 'px';
document.getElementById('tool').style.top = mesge_height + 'px';
document.getElementById('menu').style.height = client_height + 'px';
document.getElementById('tool').style.height = client_height + 'px';
} else {
document.getElementById('menu').style.top = '0px';
document.getElementById('tool').style.top = '0px';
document.getElementById('menu').style.height = 400 + 'px';
document.getElementById('tool').style.height = 400 + 'px';}}

function supportercheckmessge(){
alert('Support this website by visiting it\'s "Amazon associate entrance" and I won\'t need to remind you again!');}

function supportercheck(){
if(supporter == null && mycntry == 'US') setTimeout('supportercheckmessge()',500);}