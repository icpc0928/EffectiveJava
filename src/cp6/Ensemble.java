package cp6;

public enum Ensemble {

    SOLO, DUET, TRIO;
    public int getNumberOfMusicians(){return ordinal() + 1;}
}

enum Ensemble2{
    SOLO(1), DUET(2), TRIO(3);
    private final int numberOfMusicians;
    Ensemble2(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }
    public int getNumberOfMusicians() {
        return numberOfMusicians;
    }
}
