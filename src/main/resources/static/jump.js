function changeUrl(base, find, value) {
    var offset = base.indexOf(find);
    var index;
    var rr = '';
    if(offset < 0){
        if(base.indexOf('?') < 0) {
            base += '?';
        }else{
            base += '&';
        }
        base += find + '=' + value;
    }else{
        left = base.substr(0, offset);
        right = base.substr(offset);
        index = right.indexOf('&');
        if(index >= 0){
            rr = right.substr(index);
        }
        base = left + find + "=" + value + rr;
    }
    return base;
}
function jump(find,page) {
    var url=window.location.href;
    console.log(changeUrl(url,'page',page));
    window.location.href=changeUrl(url,find,page)
}