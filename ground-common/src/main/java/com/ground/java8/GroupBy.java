package com.ground.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GroupBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("t1", "a1", null));
		articles.add(new Article("t0", "a1", null));
		articles.add(new Article("t2", "a2", null));
		articles.add(new Article("t3", "a3", null));
		System.out.println(groupByAuthor(articles));
		
		articles.forEach(article -> {
			System.out.println(article.getAuthor());
		});
		
		System.out.println(Runtime.getRuntime().availableProcessors());

	}

	public static Map<String, List<Article>> groupByAuthor(List<Article> articles) {
		return articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
	}

}

class Article {

	private final String title;
	private final String author;
	private final List<String> tags;

	public Article(String title, String author, List<String> tags) {
		this.title = title;
		this.author = author;
		this.tags = tags;
	}

	

	public String getTitle() {
		return title;
	}



	public String getAuthor() {
		return author;
	}



	public List<String> getTags() {
		return tags;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}