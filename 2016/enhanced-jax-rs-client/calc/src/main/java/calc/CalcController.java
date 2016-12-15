package calc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
public class CalcController {

  @Inject
  AdditionService additionService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String calc(@QueryParam("i1") int i1,
                     @QueryParam("i2") int i2) {
    return additionService.add(i1, i2);
  }

}
