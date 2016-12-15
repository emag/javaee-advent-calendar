package addition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class AdditionController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String add(@QueryParam("i1") int i1,
                    @QueryParam("i2") int i2) {

    return String.format("{\"result\" : %d}", i1 + i2);

  }

}
