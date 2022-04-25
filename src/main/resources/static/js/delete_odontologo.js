$(document).ready(function(){
    $("#update_odontologo_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let odontologoId = $("#odontologo_id").val();
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_delete_id", function(){
        let id_of_button = (event.srcElement.id);
        let odontologoId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/dentist/deleteById/' + odontologoId,
            type: 'DELETE',
            success: function(response) {
                let odontologo = response;   
                console.log(response);  
                location. reload();          
               
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});