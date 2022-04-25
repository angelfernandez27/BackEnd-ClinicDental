$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/dentist/findAll",
            success: function(response){
              $.each(response, (i, odontologo) => {  


                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            odontologo.id +
                                            '</button>';
                let get_More_danger_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                            ' type="button" class="btn btn-danger btn_delete_id">' + 
                                            odontologo.id +
                                            '</button>';
                
                let tr_id = 'tr_' + odontologo.id;
                let odontologoRow = '<tr  id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          
                          '<td class=\"td_first_name \">' + odontologo.name.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + odontologo.lastname + '</td>' +
                          '<td class=\"td_matricula\">' + odontologo.enrollment + '</td>' +
                          '<td>' + get_More_danger_Btn + '</td>' +
                          '</tr>';                
                $('#odontologoTable tbody').append(odontologoRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/odontologos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});