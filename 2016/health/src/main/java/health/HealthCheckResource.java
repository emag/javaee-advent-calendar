package health;

import org.wildfly.swarm.monitor.Health;
import org.wildfly.swarm.monitor.HealthStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@Path("/health-check")
public class HealthCheckResource {

  @GET
  @Path("/something")
  @Health
  public HealthStatus checkSomething() {
    return HealthStatus
      .named("something")
      .up()
      .withAttribute("date", LocalDateTime.now().toString())
      .withAttribute("time", System.currentTimeMillis());
  }

  @GET
  @Path("/unstable")
  @Health
  public HealthStatus unstable() {

    return (Math.random() < 0.5) ?
      HealthStatus
        .named("unstable")
        .up()
        .withAttribute("message", "Woo Hoo!") :
      HealthStatus
        .named("unstable")
        .down()
        .withAttribute("message", "Too Bad...");
  }

}
