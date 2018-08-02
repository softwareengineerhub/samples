var wsUri = "ws://" + document.location.host + document.location.pathname + "endpoint";
var websocket = new WebSocket(wsUri);
websocket.onmessage = onMessage;

websocket.onerror = function (evt) {
    onError(evt);
};

websocket.onopen = function (evt) {
    //onError(evt);
    alert("InitSocket.evt="+evt);
    websocket.send("SomeUIContent");
   // websocket.send(JSON.stringify(DeviceAction));
};

function onMessage(evt) {
    //onError(evt);
    alert("onMessage."+evt);
    //output.innerHTML += evt + "<br>";
};


websocket.onclose = function (evt) {
    //onError(evt);
    //alert("CloseSocket");
    alert("CloseSocket.evt="+evt);
};



function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

