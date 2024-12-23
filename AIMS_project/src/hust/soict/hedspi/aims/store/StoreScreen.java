package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.authentication.Authentication;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

// 20225651
public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart = new Cart();

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        List<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, this);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public void addToCart(Media media) {
        cart.addMedia(media);
        JOptionPane.showMessageDialog(this, media.getTitle() + " has been added to the cart.", "Item Added", JOptionPane.INFORMATION_MESSAGE);
    }

    public void playMedia(Playable media) {
        JDialog dialog = new JDialog(this, "Playing Media", true);
        dialog.setLayout(new BorderLayout());
        JLabel message = new JLabel("<html><div style='text-align: center;'>Playing: " + ((Media) media).getTitle() +
                "<br>Length: " + ((Disc) media).getLength() + " seconds</div></html>", SwingConstants.CENTER);
        dialog.add(message, BorderLayout.CENTER);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
        media.play();
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Add some media to the store
        store.SetAuthentication(Authentication.StoreManager);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                19.95f, 87, "Roger Allers");
        CompactDisc cd1 = new CompactDisc("Star wars", "Science Fiction",
                24.95f, 87, "Geogre Lucas", "John Williams");
        cd1.addTrack(new Track("Duel of the Fates", 240));
        cd1.addTrack(new Track("Anakin vs Obi-Wan", 180));
        Book book1 = new Book("One Piece", "Manga", 18.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Dazzling light in the summer", "Inazuma",
                19.99f, 123, "miHoYo");
        CompactDisc cd2 = new CompactDisc("Liyue", "Gensin Impact",
                24.99f, 0, "miHoyo", "Yu-Peng Chen");
        cd2.addTrack(new Track("Rapid as Wildfires", 240));
        cd2.addTrack(new Track("Moon in One's Cup", 180));
        Book book2 = new Book("The Art of War", "Sun Tzu", 19.99f);
        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book1);
        store.addMedia(dvd2);
        store.addMedia(cd2);
        store.addMedia(book2);
        StoreScreen storeScreen = new StoreScreen(store);
    }
}