package hust.soict.ite6.test.store;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store anOrder = new Store();
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		//anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		//anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		//anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDVD(dvd1, dvd2, dvd3);
		anOrder.removeDVD(dvd2);
		anOrder.addDVD(dvd1);
	}

}
