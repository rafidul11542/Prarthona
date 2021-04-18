package com.example.prarthona;

public class rdmodel {
    String id;
    String title;
    String arabic;
    String bangla;

    rdmodel()
    {

    }

    public rdmodel(String id, String title, String arabic, String bangla) {
        this.id = id;
        this.title = title;
        this.arabic = arabic;
        this.bangla = bangla;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getBangla() {
        return bangla;
    }

    public void setBangla(String bangla) {
        this.bangla = bangla;
    }
}
