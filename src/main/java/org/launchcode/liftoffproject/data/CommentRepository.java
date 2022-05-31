package org.launchcode.liftoffproject.data;

import org.launchcode.liftoffproject.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
//    @Query(value = "SELECT * FROM comment WHERE intervention_id = :interventionId AND user_id =:userId",nativeQuery = true)
//    List<Comment> findCommentByInterventionIdAndUserId(@Param("interventionId") Integer interventionId, @Param("userId") Integer userId);
    List<Comment> findCommentByInterventionId(@Param("interventionId") Integer interventionId);

}

