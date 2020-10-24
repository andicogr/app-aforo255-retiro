package org.aforo255.withdrawal;

import org.aforo255.withdrawal.entity.Transaction;
import org.aforo255.withdrawal.service.ITransaction;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/retiro")
public class Withdrawal {

    @Inject
    @Channel("transactions")
    Emitter<Transaction> emitter;

    @POST
    @Counted(name = "contador transaction")
    @Timed(name= "duracion transaction")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveTransaction(Transaction transaction) {

        Transaction trx = transaction;
        trx.persist();

        Map<String, Object> response = new HashMap<>();

        emitter.send(trx);

        response.put("message", "Transaccion realizada con exito!!");
        response.put("transaction", trx);

        return Response.status(Response.Status.CREATED).entity(response).build();
    }

}
