function pulse(){
    $.get("/pulse", function(data, status){
        console.log(status);
        window.location.reload();
    });
}

function addCard(){
    window.location.assign("http://localhost:8080/add_card_form");
}

function addColumn(){
    window.location.assign("http://localhost:8080/add_column_form");
}