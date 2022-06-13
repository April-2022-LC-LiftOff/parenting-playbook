package org.launchcode.liftoffproject.data;

import org.launchcode.liftoffproject.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {
    Page<Comment> findCommentByInterventionId
            (@Param("interventionId") Integer interventionId, Pageable pageable);

    Page<Comment> findCommentByUserId
            (@Param("userId") Integer userId, Pageable pageable);
}

