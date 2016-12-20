package wildflyswarm;

import helloworld.HelloWorld;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.undertow.UndertowFraction;

public class Bootstrap {

  public static void main(String[] args) throws Exception {
    Swarm swarm = new Swarm(args);

    swarm.fraction(
      UndertowFraction.createDefaultFraction("keystore.jks", "password", "selfsigned")
    );

    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addClass(HelloWorld.class);

    swarm
      .start()
      .deploy(archive);
  }

}
