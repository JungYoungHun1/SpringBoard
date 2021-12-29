function moveToDetail(iboard){
    location.href='/board/detail?iboard=' + iboard;
}

var detailElem = document.querySelectorAll('.record');
for(var i = 0; i < detailElem.length; i++) {
    var tr = detailElem[i];
    setEvent(tr);
    }
function setEvent(tr){
    tr.addEventListener('click', function (e){
        moveToDetail(tr.dataset.iboard);
    })
}