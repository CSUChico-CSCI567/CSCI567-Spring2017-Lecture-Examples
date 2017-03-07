package example.csci567.retrofitexample;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bryandixon on 3/7/17.
 */

public class Recipe {
    @Expose
    private String title;
    @SerializedName("image_url")
    @Expose
    private String imageURL;
    @SerializedName("source_url")
    @Expose
    private String sourceURL;
    @SerializedName("f2f_url")
    @Expose
    private String f2fURL;
    @Expose
    private String publisher;
    @SerializedName("publisher_url")
    @Expose
    private String publisherURL;
    @SerializedName("social_rank")
    @Expose
    private String socialRank;
    @Expose
    private Integer page;

    public Recipe(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getSourceURL() {
        return sourceURL;
    }
}
