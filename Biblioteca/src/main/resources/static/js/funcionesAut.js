function eliminar (id){
swal({
  title: "Estas seguro de Eliminar?",
  text: "Recuerda revisar que ningun autor este en uso en la sección libro!, deseas continuar?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
  $.ajax({
  url:"/eliminar/"+id,
  success: function(res){
  console.log(res);
  }
  });
    swal("Poof! Se elimino correctamente el Registro!", {
      icon: "success",
    }).then((ok)=>{
    if(ok){
    location.href="/autores"
    }
    });
  } else {
    swal("No se Elimino el registro!");
  }
});
}