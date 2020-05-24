package net.xiaosaguo.myblog.dao;

import net.xiaosaguo.myblog.pojo.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 标签 DAO
 *
 * @author xiaosaguo
 * @date 2020/04/25
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    /**
     * description: 根据标签名称查询标签
     *
     * @param name 标签名称
     * @return 根据标签名称查询到的 {@code Tag}
     * @author xiaosaguo
     * @date 2020-04-30 20:04
     */
    Tag findByName(String name);

    /**
     * description: 根据标签下的博客数量排名，返回前几名
     *
     * @param pageable 分页封装参数
     * @return 前几名的 {@code Tag}
     * @author xiaosaguo
     * @date 2020/05/15 23:24
     */
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
