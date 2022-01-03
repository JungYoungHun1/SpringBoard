// function moveToDel(iboard){
//     location.href='/board/del?iboard=' + iboard;
// }
var btnContainerElem = document.querySelector('#btnContainer');
var btnDelElem = document.querySelector('#btnDel')
if(btnContainerElem) {
    btnDelElem.addEventListener('click', function () {
        if (confirm('삭제하시겠습니까?')) {
            location.href = "/board/del?iboard=" + btnContainerElem.dataset.iboard;
            // return moveToDel(btnContainerElem.dataset.iboard);
        }
    });
}


