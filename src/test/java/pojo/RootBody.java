package pojo;
import java.util.ArrayList;
import java.util.List;

public class RootBody {

	    private String id;

	    private Category category;

	    private String name;

	    private List<String> photoUrls;

	    private Tags tags;

	    private String status;

	    public void setId(String id2){
	        this.id = id2;
	    }
	    public String getId(){
	        return this.id;
	    }
	    public void setCategory(Category category){
	        this.category = category;
	    }
	    public Category getCategory(){
	        return this.category;
	    }
	    public void setName(String name){
	        this.name = name;
	    }
	    public String getName(){
	        return this.name;
	    }
	    public void setPhotoUrls(List<String> photoUrls){
	        this.photoUrls = photoUrls;
	    }
	    public List<String> getPhotoUrls(){
	        return this.photoUrls;
	    }
	    public void setTags(Tags tags){
	        this.tags = tags;
	    }
	    public Tags getTags(){
	        return this.tags;
	    }
	    public void setStatus(String status){
	        this.status = status;
	    }
	    public String getStatus(){
	        return this.status;
	    }
	}


