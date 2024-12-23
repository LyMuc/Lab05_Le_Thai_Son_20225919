package hust.soict.hedspi.aims.media;
// 20225651
// Track class represents a music track and implements Playable interface
public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track track){
            if (this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength()){
                return true;
            }
        }
        return false;
    }
}
