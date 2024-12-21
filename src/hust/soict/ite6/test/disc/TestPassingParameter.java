package hust.soict.ite6.test.disc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD= new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2)
	{
		Object tmpObject=o1;
		o1=o2;
		o2=tmpObject;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title)
	{
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
	{
		String tmpString = dvd2.getTitle();
		dvd2.setTitle(dvd1.getTitle());
		dvd1.setTitle(tmpString);
	}

}
