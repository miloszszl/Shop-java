package dao;

import POJO.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface CommentDao extends CrudRepository<Comment, Integer> {

    List<Comment> findAll();
    Comment findOne(Integer primaryKey);
    Comment save(Comment c);
    boolean exists(Integer primaryKey);
    @Query("select c from Comment c where c.idComment.product.id = :id_porduktu order by c.datetime asc")   //not sure ifworks correctly
    List<Comment> findCommentByProductId(@Param("id_porduktu") Integer id_product);
    void delete(Comment entity);

}
