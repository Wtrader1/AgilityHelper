package net.runelite.client.plugins.AgilityHelper;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@PluginDescriptor(
        name = "Agility Helper",
        description = "Shows Player X,Y,Z coordinates & Nearest obstacle"
)
public class HelperPlugin extends Plugin {
    private WorldPoint lastlocaton;
    @Inject
    private Client client;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private HelperObjectOverlay objectOverlay;
    @Inject
    private HelperOverlay helperOverlay;
    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged){    }
    @Getter
    final Set<GameObject> courseObject = new HashSet<>();
    @Override
    public void startUp(){
        overlayManager.add(objectOverlay);
        overlayManager.add(helperOverlay);
    }
    @Override
    public void shutDown(){
        overlayManager.remove(objectOverlay);
        overlayManager.remove(helperOverlay);
    }
    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned event){
        GameObject gameObject = event.getGameObject();
        System.out.println("GameObjectSpawned "+gameObject.getId());
    }
    @Subscribe
    public void onGameObjectDespawned(GameObjectDespawned event){
        GameObject gameObject = event.getGameObject();
        System.out.println("GameObjectDespawned "+gameObject.getId());
    }
    @Subscribe
    public void onGameObjectChanged(GameObjectChanged event){
        GameObject gameObject = event.getGameObject();
        System.out.println("GameObjectChanged "+gameObject.getId());
    }
    @Subscribe
    public void OnGameStateChanged(GameStateChanged event){
        if(event.getGameState() == GameState.LOADING){
            courseObject.clear();
        }
        else if(event.getGameState() == GameState.LOGIN_SCREEN) {
            courseObject.clear();
            return;
        }
    }
}
