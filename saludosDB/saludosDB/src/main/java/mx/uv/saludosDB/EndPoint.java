package mx.uv.saludosDB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint {
    @Autowired
    private iSaludador iSaludador;
    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+ peticion.getNombre());
  
        Saludadores saludadores = new Saludadores();
        saludadores.setNombre(peticion.getNombre());

    iSaludador.save(saludadores);
    
    return respuesta;
}
/* 
    @PayloadRoot (localPart= "BuscarTodoRequest", namespace = "https://t4is.uv.mx/saludos")
    
    @ResponsePayload
    public BuscarTodoRequest Buscar)(@RequestPayload BuscarTodoRequest peticion){
        BuscarTodoRequest response = new BuscarTodoRequest();
        Saludadores saludadores = new Saludadores();
        iSaludador.findAll();
        response.setRepuesta(saludadores.getNombre());

        return nombre;
  
    } */
}
//buscar, eliminar, actualizar 