package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long>
{

}
