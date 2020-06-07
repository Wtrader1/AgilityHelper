package net.runelite.client.plugins.AgilityHelper;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

public class HelperObjectOverlay extends Overlay {
    private static final int MAX_DISTANCE = 200;
    private final Client client;
    private final HelperPlugin plugin;

    @Inject
    HelperObjectOverlay(Client client, HelperPlugin plugin){
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        return null;
    }
}
