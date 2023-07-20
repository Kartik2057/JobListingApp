package com.kartik.joblisting.repository;

import com.kartik.joblisting.model.Post;

import java.util.List;


public interface SearchRepository {

    List<Post> findByText(String text);
}
