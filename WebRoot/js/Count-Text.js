//Count Characters, Words, Sentences, Lines (Javascript) is Copyright 2012 TextMechanic.com All Rights Reserved

function monofnt(){
var fonttype = document.getElementById('input').style.fontFamily.replace(/[^a-z]/gi,'');
if(fonttype == 'arial') document.getElementById('input').style.fontFamily = 'courier new';
else document.getElementById('input').style.fontFamily = 'arial';}

function cleartext(){
document.getElementById('input').value = '';
document.getElementById('char_count').value = '0';
document.getElementById('word_count').value = '0';
document.getElementById('sent_count').value = '0';
document.getElementById('line_count').value = '0';
document.getElementById('custom_count').value = '0'}

var selctedtxt = 0;
function selectcount(state){
if(state == 'on') {selctedtxt = 0; document.onmousemove = selecttext;} else document.onmousemove = '';
function selecttext(){
var text = '';
var textarea = document.getElementById('input');
if(document.selection){
text = document.selection.createRange().text;}
else text = textarea.value.substring(textarea.selectionStart,textarea.selectionEnd);
selctedtxt = text.length;
charcnt(text);
sentcnt(text);
wrdcnt(text);
linecnt(text);
cuscnt(text);}}

function charcnt(selected){
var text = document.getElementById('input').value;
if(selected != 0) text = selected;
var ccnt = '';
if(document.getElementById('no_spaces').checked == true){
ccnt = text.replace(/\r/g,'').replace(/\n/g,'').replace(/[\s]/g,'').length;} else { ccnt = text.replace(/\r/g,'').replace(/\n/g,'').length;}
document.getElementById('char_count').value = ccnt;}

function sentcnt(selected){
var sentcont = document.getElementById('input').value;
if(selected != 0) sentcont = selected;
var belong2 = 'pbclevtug grkgzrpunavp.pbz';
sentcont = sentcont.replace(/\r/g,'');
sentcont = sentcont.replace(/ \n/g,'\n');
sentcont = sentcont + '\n';
sentcont1 = sentcont.split('. ').length -1;
sentcont1b = sentcont.split('.\n').length -1;
sentcont2 = sentcont.split('! ').length -1;
sentcont2b = sentcont.split('!\n').length -1;
sentcont3 = sentcont.split('? ').length -1;
sentcont3b = sentcont.split('?\n').length -1;
sentcontout = sentcont1 + sentcont1b + sentcont2 + sentcont2b + sentcont3 + sentcont3b;
document.getElementById('sent_count').value = sentcontout;}

function wrdcnt(selected){
var wcnt = 0;
var wcnk = document.getElementById('input').value;
if(selected != 0) wcnk = selected;
wcnk = wcnk.replace(/\r/g,'').replace(/\n/g,' ').replace(/[^\w\s\']/g,' ').split(' ');
var wcnklen = wcnk.length;
for(var x=0;x<wcnklen;x++){
if(wcnk[x].length > 0) wcnt++;}
document.getElementById('word_count').value = wcnt;}

function linecnt(selected){
var text = document.getElementById('input').value;
if(selected != 0) text = selected;
var textlength = text.length;
var lncnt = text.split('\n').length;
if(textlength > 0) document.getElementById('line_count').value = lncnt; else document.getElementById('line_count').value = '0';}

function cuscnt(selected){
var cntq = document.getElementById('custom_count_query').value;
var inpt = document.getElementById('input').value;
if(selected != 0) inpt = selected;
if(document.getElementById('case_sen').checked == false){cntq = cntq.toLowerCase(); inpt = inpt.toLowerCase();}
var cntqlen = cntq.length;
var cuscnt = inpt.split(cntq);
if(cntqlen > 0) cuscnt = cuscnt.length-1; else cuscnt = '0';
document.getElementById('custom_count').value = cuscnt;}

function SelectAll(id){
document.getElementById(id).focus();
document.getElementById(id).select();}