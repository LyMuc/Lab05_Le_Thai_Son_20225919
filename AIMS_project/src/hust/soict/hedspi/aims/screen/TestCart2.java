package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestCart2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        CompactDisc cd1 = new CompactDisc("Star wars", "Science Fiction", 24.95f, 87, "George Lucas", "John Williams");
        cd1.addTrack(new Track("Duel of the Fates", 240));
        cd1.addTrack(new Track("Anakin vs Obi-Wan", 180));
        Book book1 = new Book("One Piece", "Manga", 18.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Dazzling light in the summer", "Inazuma", 19.99f, 123, "miHoYo");
        CompactDisc cd2 = new CompactDisc("Liyue", "Gensin Impact", 24.99f, 0, "miHoyo", "Yu-Peng Chen");
        cd2.addTrack(new Track("Rapid as Wildfires", 240));
        cd2.addTrack(new Track("Moon in One's Cup", 180));
        Book book2 = new Book("The Art of War", "Sun Tzu", 19.99f);

        Cart cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(cd1);
        cart.addMedia(book1);
        cart.addMedia(dvd2);
        cart.addMedia(cd2);
        cart.addMedia(book2);
        CartScreen cartScreen = new CartScreen(cart);
    }

    public static void main(String[] args) {
        launch(args);
    }
}