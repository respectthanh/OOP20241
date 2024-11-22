package aimsfolder;

public class DigitalVideoDisc {

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;	
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc() {
		this.id = nbDigitalVideoDiscs;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
        return title;
	}
	
	public boolean isMatch(String search) {
        boolean matched = false;
        String[] searchArr = search.split(" ", 0);
        for (String word: searchArr) {
            String lowerCaseTitle = title.toLowerCase();
            int index = lowerCaseTitle.indexOf(word.toLowerCase());
            if (index != -1) {
                matched = true;
                break;
            }
        }
        return matched;
    }
	
    public boolean isMatch(int id){
        if (this.id == id){
            return true;
        }
        return false;
    }

	
	@Override
    public String toString() {
        return "hust.soict.dsai.aims.disc.DigitalVideoDisc{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", cost=" + cost +
                ", id=" + id +
                '}';
    }
	
	

}