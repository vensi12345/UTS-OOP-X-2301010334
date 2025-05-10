package uts.oop.x.pkg2301010334;

class Note {
    private String title;
    private String content;

    // Constructor
    public Note() {
        this.title = "";
        this.content = "";
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Content: " + content;
    }
}



