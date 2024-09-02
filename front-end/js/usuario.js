var url = "http://localhost:8080/api/v1/usuario/";

function listaUsuario() {
    var capturarFiltro = document.getElementById("SearchName").value;
    var urlLocal = url;
    if (capturarFiltro !== "") {
        urlLocal += "busquedafiltro/" + encodeURIComponent(capturarFiltro); // Asegúrate de codificar el filtro
    }

    $.ajax({
        url: urlLocal,
        type: "GET",
        success: function (result) {
            console.log(result); 

            var cuerpoTabla = document.getElementById("cuerpoTabla");
            cuerpoTabla.innerHTML = "";

            result.forEach(function (usuario) {
                var trRegistro = document.createElement("tr");

                // Crear celdas y añadir los datos
                var celdaId = document.createElement("td");
                var celdaCorreoElectronico = document.createElement("td");
                var celdaTipoDocumento = document.createElement("td");
                var celdaNumDocumento = document.createElement("td");
                var celdaFechaNacimiento = document.createElement("td");
                var celdaFechaUltimaActualizacion = document.createElement("td");
                var celdaFechaUltimoInicio = document.createElement("td");
                var celdaContraseña = document.createElement("td");
                var celdaEstado = document.createElement("td");
                // var celdaAcciones = document.createElement("td");

                // Asignar valores a las celdas
                celdaId.innerText = usuario.id_usuario;
                celdaCorreoElectronico.innerText = usuario.correo_electronico;
                celdaTipoDocumento.innerText = usuario.tipo_Documento;
                celdaNumDocumento.innerText = usuario.num_Documento;
                celdaFechaNacimiento.innerText = usuario.fecha_nacimiento;
                celdaFechaUltimaActualizacion.innerText = usuario.fecha_ultima_actua;
                celdaFechaUltimoInicio.innerText = usuario.fecha_ultima_inicio;
                celdaContraseña.innerText = usuario.contraseña;
                celdaEstado.innerText = usuario.estado;

                // Añadir celdas a la fila
                trRegistro.appendChild(celdaId);
                trRegistro.appendChild(celdaTipoDocumento);
                trRegistro.appendChild(celdaNumDocumento);
                trRegistro.appendChild(celdaFechaNacimiento);
                trRegistro.appendChild(celdaCorreoElectronico);
                trRegistro.appendChild(celdaFechaUltimaActualizacion);
                trRegistro.appendChild(celdaFechaUltimoInicio);
                trRegistro.appendChild(celdaContraseña);
                trRegistro.appendChild(celdaEstado);
                // trRegistro.appendChild(celdaAcciones);

                // Añadir la fila a la tabla
                cuerpoTabla.appendChild(trRegistro);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error: ", error);
            // Puedes mostrar un mensaje de error en la interfaz si lo deseas
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    const today = new Date().toISOString().split('T')[0]; // Obtiene la fecha actual en formato YYYY-MM-DD

    const fechaUltimaActualizacion = document.getElementById('fecha_ultima_actua');
    const fechaUltimoInicio = document.getElementById('fecha_ultima_inicio');

    if (fechaUltimaActualizacion) {
        fechaUltimaActualizacion.value = today;
    }
    if (fechaUltimoInicio) {
        fechaUltimoInicio.value = today;
    }
});


function registrarUsuario() {
    // Capturar los valores de los campos del formulario
    let nombre = document.getElementById("Nombre").value;
    let direccion = document.getElementById("Direccion").value;
    let correo_electronico = document.getElementById("Correo_electronico").value;
    let tipo_usuario = document.getElementById("Tipo_usuario").value;
    let tipo_documento = document.getElementById("Tipo_documento").value; // Asegúrate de que estos IDs coincidan con los del HTML
    let num_documento = document.getElementById("Num_documento").value;
    let fecha_nacimiento = document.getElementById("Fecha_nacimiento").value;
    let fecha_ultima_actua = document.getElementById("Fecha_ultima_actua").value;
    let fecha_ultimo_inicio = document.getElementById("Fecha_ultimo_inicio").value;
    let estado = document.getElementById("Estado").value;

    // Validación para comprobar si todos los campos están llenos
    if (nombre === "" || direccion === "" || correo_electronico === "" || tipo_usuario === "" ||
        tipo_documento === "" || num_documento === "" || fecha_nacimiento === "" ||
        fecha_ultima_actua === "" || fecha_ultimo_inicio === "" || estado === "") {
        Swal.fire({
            title: "Error",
            text: "Por favor, rellene todos los campos.",
            icon: "error"
        });
        return;
    }

    // Validación del correo electrónico
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(correo_electronico)) {
        Swal.fire({
            title: "Error",
            text: "Por favor, ingrese un correo electrónico válido.",
            icon: "error"
        });
        return;
    }

    // Datos del formulario
    let formData = {
        "nombre": nombre,
        "direccion": direccion,
        "correo_electronico": correo_electronico,
        "tipo_usuario": tipo_usuario,
        "tipo_documento": tipo_documento,
        "num_documento": num_documento,
        "fecha_nacimiento": fecha_nacimiento,
        "fecha_ultima_actua": fecha_ultima_actua,
        "fecha_ultimo_inicio": fecha_ultimo_inicio,
        "estado": estado
    };

    // Realizar la solicitud AJAX para registrar el usuario
    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        success: function (result) {
            Swal.fire({
                title: "¡Excelente!",
                text: "Se guardó correctamente",
                icon: "success"
            });
            limpiarFormulario(); // Llama a la función para limpiar el formulario después del registro exitoso
        },
        error: function (xhr, status, error) {
            Swal.fire({
                title: "Error",
                text: "Error al guardar el usuario",
                icon: "error"
            });
        }
    });
}