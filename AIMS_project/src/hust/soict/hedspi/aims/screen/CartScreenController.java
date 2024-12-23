package hust.soict.hedspi.aims.screen;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
public class CartScreenController {
    @FXML private Label costTextView;
    private Cart cart;
    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Button btnPlaceOrder;
    public CartScreenController(){
        super();
    }
    public void setCart(Cart cart){
        this.cart = cart;
        try{
            colMediaTitle.setCellValueFactory(
                    new PropertyValueFactory<Media, String>("title"));
            colMediaCategory.setCellValueFactory(
                    new PropertyValueFactory<Media, String>("category"));
            colMediaCost.setCellValueFactory(
                    new PropertyValueFactory<Media, Float>("cost"));
            tblMedia.setItems(cart.getItemsOrdered());
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            tblMedia.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<Media>() {
                        @Override
                        public void changed(ObservableValue<? extends Media> observableValue,
                                            Media oldValue, Media newValue) {
                            if (newValue != null){
                                updateButtonBar(newValue);
                            }
                        }
                    }
            );
            cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> updateTotalCost());
            updateTotalCost();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML private void initialize(){

    }
    private void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    @FXML public void btnRemovePressed(MouseEvent mouseEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    public void placeOrderPressed(MouseEvent mouseEvent) {
        cart.emptyCart();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }
    private void updateTotalCost() {
        float totalCost = cart.totalCost();
        costTextView.setText(String.format("%.2f$", totalCost));
    }
}
