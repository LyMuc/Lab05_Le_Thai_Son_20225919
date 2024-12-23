package hust.soict.hedspi.aims.media;
// 20225651
public abstract class Media implements Comparable<Media> {
    // Comparator
    public static final MediaComparatorByTitleCost COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final MediaComparatorByCostTitle COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nMedia = 0;
    public Media(String title, String category, float cost){
        id = nMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nMedia++;
    }
    public Media(String title){
        id = nMedia;
        this.title = title;
        nMedia++;
    }
    public void print(){}

    // Getters
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

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "Media:{ ID: " + id + " - Title: " + title + " - Category: " 
            + category + " - Cost: " + cost + " }";
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Media media){
            if (this.getTitle().equals(media.getTitle())){
                return true;
            }
        }
        return false;
    }
    @Override
    public int compareTo(Media other) {
        // Sort by cost (descending)
        int costComparison = Float.compare(other.cost, this.cost);
        if (costComparison != 0) {
            return costComparison;
        }

        // If costs are the same, sort by title (ascending)
        return this.title.compareTo(other.title);
    }
    //@Override
// public int compareTo(Media other) {
//     // Sort by title (ascending)
//     int titleComparison = this.title.compareTo(other.title);
//     if (titleComparison != 0) {
//         return titleComparison;
//     }

//     // If titles are the same, sort by cost (descending)
//     return Float.compare(other.cost, this.cost);
// }
}