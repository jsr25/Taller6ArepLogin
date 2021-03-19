const app = (function () {
    let user;
    let pass;

    function login() {
        user = $("#usuario").val();
        pass = $("#password").val();
        const promise = $.post({
            url: "/login",
            contentType: "application/json",
            data: "{\"user\":\"" + user + "\",\"pass\":" + "\"" + pass + "\"}",
        })
        promise.then(data => {
            if (data == "true") {
                const promise2 = $.get({
                    url: "/login",
                    contentType: "text/html",
                });
                promise2.then((data) => {

                    calc()

                }, (error) => {
                    alert("No existen datos del autor!")


                })
            }
        })
    }
    function calc() {

        $("#contenedor").empty()
        $("#contenedor").append($("<label id=\"label1\"> ingese numero 1</label>"));
        $("#contenedor").append($("<input id=\"numa\" placeholder=\"numa\"></input>"));
        $("#contenedor").append($("<label id=\"label2\"> ingese numero 2</label>"));
        $("#contenedor").append($("<input id=\"numb\" placeholder=\"numb\"></input>"));
        $("#contenedor").append($("<label id=\"label3\">  ingese alguna operacion suma-div-resta-multi</label>"));
        $("#contenedor").append($("<input id=\"oper\" placeholder=\"numb\"></input>"));
        $("#contenedor").append($("<button id=\"butonlogin\" onclick=\"app.opreacionCalc()\">operacion</button>"));
    }

    function opreacionCalc() {
        let numa = $("#numa").val();
        let numb = $("#numb").val();
        let ope = $("#oper").val();
        if (ope == "div" && numb == "0") {
            alert("mi chino eso esta mal")
        }
        else {
            const promise2 = $.get({
                url: "/opera/" + numa + "/" + numb + "/" + ope,
                contentType: "application/json",
            });
            promise2.then((data) => {
                console.log(data)
                result(data)
            }, (error) => {
                alert("fcita")
            })
        }
    }

    function result(data) {
        $("#contenedor").empty()
        $("#contenedor").append($("<label id=\"label1\"> Resultado</label>"));
        $("#contenedor").append($("<h1>" + data + "</h1>"));
        $("#contenedor").append($("<button id=\"volver\" onclick=\"app.calc()\">volver</button>"));
    }


    return {

        login: login,
        opreacionCalc: opreacionCalc,
        calc: calc
    }



})();