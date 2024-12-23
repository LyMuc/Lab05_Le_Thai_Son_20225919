package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.authentication.Authentication;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;
    public CartScreen(Cart cart){
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/hedspi/aims/screen/cart.fxml"));
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        } );

    }
}
