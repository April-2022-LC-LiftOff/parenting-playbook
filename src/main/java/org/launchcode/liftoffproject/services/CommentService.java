package org.launchcode.liftoffproject.services;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Page<Comment> getInterventionComments
            (int interventionId, int pageNum, String sortField, String sortDir) {

        Pageable pageable = PageRequest.of(pageNum - 1, 5,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                                      : Sort.by(sortField).descending()
        );
        return commentRepository.findCommentByInterventionId(interventionId, pageable);
    }

    public Page<Comment> getUserComments
            (int userId, int pageNum, String sortField, String sortDir) {

        Pageable pageable = PageRequest.of(pageNum - 1, 5,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                                      : Sort.by(sortField).descending()
        );
        return commentRepository.findCommentByUserId(userId, pageable);
    }
}