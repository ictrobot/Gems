package ictrobot.gems.magnetic.armor;
import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
public class JetpackKeybind extends KeyHandler
{
         private EnumSet<TickType> tickTypes = EnumSet.of(TickType.CLIENT);
        
         static public boolean keyPressed;
         
         public JetpackKeybind(KeyBinding[] keyBindings, boolean[] repeatings)
         {
                 super(keyBindings, repeatings);
                 
         }
         @Override
         public String getLabel()
         {
                 return "GemsJetpack";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
           keyPressed = true;
         }
         @Override
         public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
         {
           keyPressed = false;
         }
         @Override
         public EnumSet<TickType> ticks()
         {
                 return tickTypes;
         }
}