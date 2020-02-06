//var wsUri = "ws://" + document.location.host + document.location.pathname + "api";
var wsUri = "ws://127.0.0.1:8080/websocketsampleapp-app/serverWebSocket";
var websocket = new WebSocket(wsUri);
websocket.onmessage = onMessage;


function makeAction() {
    alert("Send message to server");
    websocket.send("SomeUIContent");
}

//server push event
function onMessage(evt) {
    alert("Consume message from server" + evt);
}

