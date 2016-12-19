package health;

import org.wildfly.swarm.monitor.Health;
import org.wildfly.swarm.monitor.HealthStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@Path("/health-check")
public class HealthCheckResource {

  @GET
  @Path("/unstable")
  @Health
  public HealthStatus checkDiskspace() {

    return (Math.random() < 0.5) ?
      HealthStatus
        .named("random")
        .up()
        .withAttribute("message", "Woo Hoo!") :
      HealthStatus
        .named("random")
        .down()
        .withAttribute("message", "Too Bad...");
  }

  @GET
  @Path("/second-health")
  @Health
  public HealthStatus checkSomethingElse() {
    return HealthStatus
      .named("something-else")
      .up()
      .withAttribute("date", LocalDateTime.now().toString())
      .withAttribute("time", System.currentTimeMillis());
  }

}
