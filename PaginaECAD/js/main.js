$(window).on("load", () => {
    const XHRNome = new XMLHttpRequest();
    XHRNome.open("GET", "http://localhost:8080/filesInfo/nomes");

    XHRNome.responseType = "json";

    XHRNome.addEventListener("load", function (event) {
        updateSelect(this.response, "arquivo");
        console.log(this.response);
        const XHRBanco = new XMLHttpRequest();
        XHRBanco.open("GET", "http://localhost:8080/filesInfo/bancos");

        XHRBanco.responseType = "json";

        XHRBanco.addEventListener("load", function (event) {
            console.log(this.response);
            updateSelect(this.response, "banco");
        });

        XHRBanco.send();
    });

    XHRNome.send();

    function updateSelect(_array, _id) {
        var selectElements = document.getElementById(_id).innerHTML.trim();
        console.log(_array);
        for (i = 0; i < _array.length; i++) {
            console.log(_array[i]);
            selectElements += '<option >' + _array[i] + '</option>'
        }
        console.log(selectElements);
        document.getElementById(_id).innerHTML = selectElements;
    }
})

window.addEventListener("load", function () {
    try {
        function sendData() {
            const XHR = new XMLHttpRequest();
            const FD = buildJsonFormData(form);

            XHR.open("GET", "http://localhost:8080/filesInfo");

            XHR.responseType = "json";

            XHR.addEventListener("load", function (event) {
                updateTable(this.response);
            });

            XHR.addEventListener("error", function (event) {
                alert('Sorry, something went wrong.');
            });

            XHR.setRequestHeader("Content-Type", "application/json");

            const dataToSend = JSON.stringify(FD);
            console.log(dataToSend);

            XHR.send(dataToSend);
        }
    } catch (error) {
        alert('Sorry, something went wrong.');
        console.log("error caught");
    }

    function buildJsonFormData (form) {
        const JsonFormData = { };
        for (const pair of new FormData(form)){
            JsonFormData[pair[0]] = pair [1];
        }
        return JsonFormData;
    }


    function updateTable(_array) {
        var tableElements = "";
        for (i = 0; i < _array.length; i++) {
            tableElements += '<tr>' +
                '<td class="text-center">' + _array[i].banco + '</td>' +
                '<td class="text-center">' + _array[i].tipo + '</td>' +
                '<td class="text-center">' + _array[i].arquivo + '</td>' +
                '<td class="text-center">' + _array[i].dtGeracao + '</td>' +
                '<td class="text-center">' + _array[i].geradoPor + '</td>' +
                '<td class="text-center">' + _array[i].dtEnvio + '</td>' +
                '<td class="text-center">' + _array[i].qtdLinhas + '</td>' +
                '<td class="text-center">' + _array[i].carteira + '</td>' +
                '<td class="text-end">' + _array[i].vlrTotal + '</td>' +
                '<td class="text-center"><a href="http://localhost:8080/' + _array[i].id + '">Download</a></td>' +
                '</tr>';
        }
        document.getElementById("dadosTabela").innerHTML = tableElements;
    }

    const form = document.getElementById("docSelection");

    const geradoPor = document.getElementById("geradoPor");
    const tipo = document.getElementById("tipo");
    const dtEnvio = document.getElementById("dtEnvio");
    const dtGeracao = document.getElementById("dtGeracao");
    const banco = document.getElementById("banco");
    const arquivo = document.getElementById("arquivo");

    form.addEventListener("submit", function (event) {
        event.preventDefault();
        console.log("trying to send data");
        sendData();
    });
});

