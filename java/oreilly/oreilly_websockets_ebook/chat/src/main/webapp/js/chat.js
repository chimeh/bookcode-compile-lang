(function() {
    'use strict';

    var commands = {
        getUUID : 'getUUID',
        message : 'message'
    },
    clientUUID = null,
    messageEmptyElem = $('#messages-empty'),
    messageElem = $('#messages');
    
    $('#name').focus();

    if ("WebSocket" in window) {
        var ws = new WebSocket('ws://localhost:8080/chat/chatEndpoint');
        
        ws.onopen = function() {
            ws.send(JSON.stringify(composeUUIDCommand()));
        };
        
        ws.onmessage = function(e) {
            var data = JSON.parse(e.data);
            if (data.command === commands.getUUID) {
                clientUUID = data.uuid;
            } else if (data.command === commands.message) {
                messageEmptyElem.hide();
                var name = data.name;
                var message = data.message;
                var senderUUID = data.senderClientUUID;
                messageElem.append(
                    ['<h2 class="inline"><span class="label label-default" ',
                        'style="background-color: #', getColorFromUUID(senderUUID),
                        ';">', name, '</span></h2>', 
                    '<div class="bubble">', message, '</div>', 
                    '<br />'].join('')
                );
                messageElem.show();
            }
        };

        $('#new-message-form').submit(function(e) {
            e.preventDefault();
            ws.send(JSON.stringify(composeMessageCommand(clientUUID, $('#name').val(), $('#text').val())));
            $('#text').val('');
        });
    } else {
        console.log('WebSockets are not supported by your browser!');
    }
    
    function composeUUIDCommand() {
        return {
            command : commands.getUUID
        };
    }
    
    function composeMessageCommand(uuid, name, message) {
        return {
            command : commands.message,
            data : {
                uuid : uuid,
                name : name,
                message : message
            }
        };
    }

    function getColorFromUUID(senderUUID) {
        if (!senderUUID) {
            throw "SenderUUID is null!";
        }
        return senderUUID.substring(0, 6);
    }

})();