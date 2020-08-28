$(function(){
    bindEvent();
});

function bindEvent() {
    $("#test").on("click",function (event) {
            alert("div is clicekd")
        sendAjax();
    });

}
function sendAjax(){
    var obj = {};
    $.ajax("https://www.yiibai.com/hibernate/collection-mapping.html",{
        contentType:"application/json;charset:UTF-8",
        type:"get",
        data:obj,
        success:function(data){
            console.log("请求数据成功");
            console.log(JSON.stringify(data))
            
        },
        error:function (error) {
            紧急
        }

    });
}