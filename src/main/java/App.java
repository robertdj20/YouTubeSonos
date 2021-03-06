
import base.WebServer;
import youtubesonos.S;
import youtubesonos.SonosApi;
import base.ResourceHttpHandler;
import youtubesonos.youtube.YouTubeAuthHttpHandler;
import youtubesonos.youtube.YouTubeStreamHttpHandler;

import javax.xml.ws.Endpoint;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        WebServer webServer = new WebServer(S.getResources().getString(S.WEB_SERVER_HOST), Integer.parseInt(S.getResources().getString(S.WEB_SERVER_PORT)));
        webServer.createContext("/PresentationMap.xml", new ResourceHttpHandler("/PresentationMap.xml"));
        webServer.createContext("/Strings.xml", new ResourceHttpHandler("/Strings.xml"));
        webServer.createContext("/stream", new YouTubeStreamHttpHandler());
        webServer.createContext(S.getResources().getString(S.AUTH_PATH), YouTubeAuthHttpHandler.getInstance());
        webServer.publishEndpoint(S.getResources().getString(S.SMAPI_PATH), Endpoint.create(new SonosApi()));
        webServer.start();
    }
}
