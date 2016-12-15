package wildflyswarm;

import helloworld.HelloWorld;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.undertow.UndertowFraction;

public class Bootstrap {

  public static void main(String[] args) throws Exception {
    // (1) WildFly 自身を表す
    Swarm swarm = new Swarm(args);

    // (2) WildFly の設定
    swarm.fraction(
      UndertowFraction.createDefaultFraction("keystore.jks", "password", "selfsigned")
    );

    // (3) アプリケーションのアーカイブ
    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addClass(HelloWorld.class);

    swarm
      // (4) WildFly の起動
      .start()
      // (5) アプリケーションのデプロイ
      .deploy(archive);
  }

}
