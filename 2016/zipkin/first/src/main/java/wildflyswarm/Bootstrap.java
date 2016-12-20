package wildflyswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jaxrs.btm.ZipkinFraction;

public class Bootstrap {

  public static void main(String[] args) throws Exception {
    Swarm container = new Swarm(args);

    container.fraction(new ZipkinFraction("first")
      .reportAsync("http://localhost:9411/api/v1/spans"));

    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addPackage("zipkin");

    container.start().deploy(archive);
  }
}
