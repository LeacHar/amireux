package cn.liaocp.amireux.core.service;

import cn.liaocp.amireux.core.domain.BaseDomain;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Chunping.Liao
 * @date 2021/5/16
 */
public interface BaseService<T extends BaseDomain, ID> {

    /**
     * Save or update the domain by id
     *
     * @param domain domain
     * @return domain
     */
    T save(T domain);

    /**
     * find all
     *
     * @return list
     */
    List<T> findAll();

    /**
     * page query
     *
     * @param example  Query Criteria
     * @param pageable pageable
     * @return
     */
    Page<T> page(Example<T> example, Pageable pageable);

}
