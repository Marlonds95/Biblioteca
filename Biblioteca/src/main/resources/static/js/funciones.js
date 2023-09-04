function eliminar (id){
swal({
  title: "Estas seguro de Eliminar?",
  text: "Once deleted, you will not be able to recover this imaginary file!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
  $.ajax({
  url:"/eliminar-libro/"+id,
  success: function(res){
  console.log(res);
  }
  });
    swal("Poof! Se elimino correctamente el Registro!", {
      icon: "success",
    }).then((ok)=>{
    if(ok){
    location.href="/libros"
    }
    });
  } else {
    swal("No se Elimino el registro!");
  }
});
}