package com.ost.android2.MediaInventory;



public class MediaURLData {
  // this id field contains the automatically incremented row id from the database
    private long uId;
    private long uMId;
 
    private String infoURL;
    private String infoURLDesc;

   
    
    public MediaURLData () {
      this.uId = 0; 
      this.uMId = 0; 
      this.infoURL = null;
      this.infoURLDesc = null;
   }
      
    public long getuId() {
      return uId;
    }


    public void setuId(long uId) {
      this.uId = uId;
    }

    public long getuMId() {
      return uMId;
    }


    public void setuMId(long uMId) {
      this.uMId = uMId;
    }
      
   
    public String getInfoURL() {
      return infoURL;
    }


    public void setInfoURL(String infoURL) {
      this.infoURL = infoURL;
    }
    
    public String getInfoURLDesc() {
      return infoURLDesc;
    }

    public void setInfoURLDesc(String infoURLDesc) {
      this.infoURLDesc = infoURLDesc;
    }

     
 }