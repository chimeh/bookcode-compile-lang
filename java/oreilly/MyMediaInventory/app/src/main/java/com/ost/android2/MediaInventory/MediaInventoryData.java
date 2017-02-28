package com.ost.android2.MediaInventory;



public class MediaInventoryData {
  // this id field contains the automatically incremented row id from the database
    private int mId;

    private String title;
    private String artist;

    private String type;
    private String subtype;
    
    private String publisher;

    private String catalogID;
    private int    year;
    private String genre;
    private String country; 
    private String language;

    private boolean selected;

    
    public MediaInventoryData () {
      this.mId = 0;
      this.title     = null;
      this.artist    = null;
      this.subtype   = null;       
      this.publisher = null;
      this.year      = 0;
      this.setCountry(null);
      this.language  = null;
      this.genre     = null;
      this.catalogID = null;
      
   }
    
    public MediaInventoryData (int id) {
      this.mId       = id;
      this.title     = null;
      this.artist    = null;
      this.subtype   = null;       
      this.publisher = null;
      this.setCountry(null);
      this.year      = 0;
      this.language  = null;
      this.genre     = null;
      this.catalogID = null;
      
   }
      
      
     @Override
     public String toString() {
       return getTitle();
     }
    
   
    public boolean isSelected() {
      return selected;
    }
    
    
    public void selectedOn() {
      this.selected=true;
    }
    
    public void selectedOff() {
      this.selected=false;
    }
    
    
    public int getmId() {
      return mId;
    }

    public void setmId(int mId) {
      this.mId = mId;
    }
    
    
    public String getArtist() {
      return artist;
    }
    
    public void setArtist(String s) {
      this.artist = s;
    }
    
    public String getTitle() {
      return title;
    }
    
    public void setTitle(String s) {
      this.title = s;
    }
    
    public String getType() {
      return type;
    }
    
    public void setType(String s) {
      this.type = s;
    }
      
    public String getSubType() {
      return subtype;
    }
    
    public void setSubType(String s) {
      this.subtype = s;
    }
    
    public String getPublisher() {
      return publisher;
    }
    
    public void setPublisher(String s) {
      this.publisher = s;
    }
    
    public int getYear() {
      return year;
    }
    
    public void setYear(int y) {
      this.year = y;
    }
    
    public String getGenre() {
      return genre;
    }
    
    public void setGenre(String s) {
      this.genre = s;
    }
    
    
    public String getCatalogID() {
      return catalogID;
    }
    
    public void setCatalogID( String s) {
      this.catalogID = s;
    }   
     
    public String getLanguage() {
      return language;
    }


    public void setLanguage(String language) {
      this.language = language;
    }
    
      public String getCountry() {
        return country;
      }

      public void setCountry(String country) {
        this.country = country;
      }
}