package calc;

import org.wildfly.swarm.cdi.jaxrsapi.Service;
import org.wildfly.swarm.cdi.jaxrsapi.ServiceClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Service(baseUrl = "http://localhost:8180/")
public interface AdditionService extends ServiceClient<AdditionService> {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  String add(@QueryParam("i1") int i1,
             @QueryParam("i2") int i2);

}
