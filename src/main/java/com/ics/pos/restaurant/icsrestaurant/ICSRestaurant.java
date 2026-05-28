package com.ics.pos.restaurant.icsrestaurant;

import com.ics.pos.restaurant.icsrestaurant.logger.LoggerSetup;

/**
 *
 * @author nateelive
 */
public class ICSRestaurant {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ICSRestaurant.class.getName());
    
    private static void applyThaiFont() {
        // FlatLaf bundles "Inter" font which has no Thai glyphs.
        // Override defaultFont with Tahoma which ships with every Windows version and supports Thai.
        javax.swing.UIManager.put("defaultFont",
            new javax.swing.plaf.FontUIResource("Tahoma", java.awt.Font.PLAIN, 13));
    }

    public static void main(String[] args) {
        LoggerSetup.init();

        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.WARNING, "FlatLaf unavailable, using default L&F", ex);
        }

        applyThaiFont();

        // Rounded corners & accent color (must be set after setup)
        javax.swing.UIManager.put("Button.arc",          10);
        javax.swing.UIManager.put("Component.arc",        8);
        javax.swing.UIManager.put("TextComponent.arc",    6);
        javax.swing.UIManager.put("ScrollBar.thumbArc", 999);
        javax.swing.UIManager.put("ScrollBar.trackArc",  999);
        javax.swing.UIManager.put("Component.accentColor", new java.awt.Color(0x2196F3));

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new ICSRestaurant().setVisible(true));
    }
}
