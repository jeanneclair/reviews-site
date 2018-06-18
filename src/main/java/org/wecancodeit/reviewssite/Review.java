package org.wecancodeit.reviewssite;

//import java.util.ArrayList;
//import java.util.Collection;

//Got stuck trying to add tags.

public class Review {
	
	private long id;
	private String title;
	private String imgUrl;
	private String category;
	private String content;
//	private Collection<String> tags;
	
	
	public Review(long id, String title, String imgUrl, String category, String content) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.category = category;
		this.content = content;
//		this.tags = tags;
	}

	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getContent() {
		return content;
	}

//	public Collection<String> getTags() {
//		return tags;
//	}

	


}
