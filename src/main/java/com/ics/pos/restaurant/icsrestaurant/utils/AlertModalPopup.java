package com.ics.pos.restaurant.icsrestaurant.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Utility class for showing modal alert dialogs (info, warning, error, confirm).
 */
public class AlertModalPopup {

    private AlertModalPopup() {}

    // ─── Info ────────────────────────────────────────────────────────────────

    public static void showInfo(Component parent, String title, String message) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showInfo(String title, String message) {
        showInfo(null, title, message);
    }

    public static void showInfo(String message) {
        showInfo(null, "Information", message);
    }

    // ─── Warning ─────────────────────────────────────────────────────────────

    public static void showWarning(Component parent, String title, String message) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showWarning(String title, String message) {
        showWarning(null, title, message);
    }

    public static void showWarning(String message) {
        showWarning(null, "Warning", message);
    }

    // ─── Error ───────────────────────────────────────────────────────────────

    public static void showError(Component parent, String title, String message) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showError(String title, String message) {
        showError(null, title, message);
    }

    public static void showError(String message) {
        showError(null, "Error", message);
    }

    // ─── Confirm ─────────────────────────────────────────────────────────────

    /**
     * Returns true if the user clicked OK/Yes, false otherwise.
     * @param parent
     * @param title
     * @param message
     * @return 
     */
    public static boolean showConfirm(Component parent, String title, String message) {
        int result = JOptionPane.showConfirmDialog(
                parent, message, title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static boolean showConfirm(String title, String message) {
        return showConfirm(null, title, message);
    }

    public static boolean showConfirm(String message) {
        return showConfirm(null, "Confirm", message);
    }

    // ─── Confirm with OK/Cancel ───────────────────────────────────────────────

    /**
     * Returns true if the user clicked OK, false if Cancel.
     * @param parent
     * @param title
     * @param message
     * @return 
     */
    public static boolean showOkCancel(Component parent, String title, String message) {
        int result = JOptionPane.showConfirmDialog(
                parent, message, title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.OK_OPTION;
    }

    public static boolean showOkCancel(String title, String message) {
        return showOkCancel(null, title, message);
    }

    public static boolean showOkCancel(String message) {
        return showOkCancel(null, "Confirm", message);
    }
}
