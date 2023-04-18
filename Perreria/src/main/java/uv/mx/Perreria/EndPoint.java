package uv.mx.Perreria;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.perrerialomos_uv_mx.perreria.DeletePerroRequest;
import https.perrerialomos_uv_mx.perreria.DeletePerroResponse;

@Endpoint
public class EndPoint {

    @Autowired
    private iPerro iPerro;

    @PayloadRoot(localPart = "DeletePerroRequest", namespace = "https://perreriaLomos.uv.mx/perreria")
    @ResponsePayload
    public DeletePerroResponse deletePerro(@RequestPayload DeletePerroRequest request) {
        Integer id = request.getId();
        Optional<Perro> optionalPerro = iPerro.findById(id.intValue());
        if (optionalPerro.isPresent()) {
            Perro perro = optionalPerro.get();
            iPerro.delete(perro);
            return new DeletePerroResponse("Perro eliminado correctamente.");
        } else {
            return new DeletePerroResponse("No se encontró el perro con id " + id);
        }
    }
}
