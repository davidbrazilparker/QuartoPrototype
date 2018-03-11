public class asciiNode
{
    private asciiNode childZero;
    private asciiNode childOne;
    private String artwork;

    public asciiNode(asciiNode newChildZero, asciiNode newChildOne, String newArtwork)
    {
        this.childZero = newChildZero;
        this.childOne = newChildOne;
        this.artwork = newArtwork;
    }

    public asciiNode getChildZero() {
        return childZero;
    }

    public void setChildZero(asciiNode childZero) {
        this.childZero = childZero;
    }

    public asciiNode getChildOne() {
        return childOne;
    }

    public void setChildOne(asciiNode childOne) {
        this.childOne = childOne;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public asciiNode getChild(int index)
    {
        return (index == 0) ? this.childZero : this.childOne;
    }
}
