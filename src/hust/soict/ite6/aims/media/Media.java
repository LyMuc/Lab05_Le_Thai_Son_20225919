package hust.soict.ite6.aims.media;

import java.util.Comparator;

public abstract class Media {

	public Media() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Media)
		{
			return this.title == ((Media) obj).title;
		}
		return(false);
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

}
