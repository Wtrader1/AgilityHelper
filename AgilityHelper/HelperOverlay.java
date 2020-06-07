package net.runelite.client.plugins.AgilityHelper;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import javax.inject.Inject;
import java.awt.*;

public class HelperOverlay extends Overlay {
    private HelperPlugin plugin;
    private PanelComponent panelComponent = new PanelComponent();
    private int X_Player;
    private int Y_Player;
    private int Z_Player;
    @Inject HelperOverlay(HelperPlugin plugin){
        super(plugin);
        setPosition(OverlayPosition.TOP_CENTER);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        this.plugin = plugin;
    }
    @Inject
    private Client client;
    @Override
    public Dimension render(Graphics2D graphics){
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Player Location")
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Player_X : ")
                .right(Integer.toString(GetPlayer("x")))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Player_Y : ")
                .right(Integer.toString(GetPlayer("y")))
                .build());
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Player_Z : ")
                .right(Integer.toString(GetPlayer("z")))
                .build());
        return panelComponent.render(graphics);
    }
    public int GetPlayer(String loc){
        if(loc == "x"){
            return client.getLocalPlayer().getWorldLocation().getX();
        }
        else if(loc == "y"){
            return client.getLocalPlayer().getWorldLocation().getY();
        }
        else if(loc == "z"){
            return client.getLocalPlayer().getWorldLocation().getPlane();
        }
        return 0;
    }
}
