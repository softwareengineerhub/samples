var wsUri = "ws://" + document.location.host + document.location.pathname + "api";
var websocket = new WebSocket(wsUri);
websocket.onopen = onOpen;
websocket.onmessage = onMessage;
websocket.onclose = onClose;
websocket.onerror = onError;


function makeAction(){
   // $("#button1").click(function(){
        alert("Test"); 
        websocket.send("SomeUIContent");
    //});
}

function onOpen(evt) {
    alert("InitSocket.evt=" + evt);
    //    websocket.send("SomeUIContent");
    // websocket.send(JSON.stringify(DeviceAction));
}

function onMessage(evt) {
    alert("onMessage." + evt);
}

function onClose(evt) {
    alert("CloseSocket.evt=" + evt);
}

function onError(evt) {
    alert(evt);
}

