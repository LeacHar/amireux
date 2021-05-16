package cn.liaocp.amireux.user.repository;

import cn.liaocp.amireux.core.repository.BaseRepository;
import cn.liaocp.amireux.user.domain.User;

/**
 * @author Chunping.Liao
 * @date 2021/5/16
 */
public interface UserRepository extends BaseRepository<User, String> {

    /**
     * Get the user by username
     *
     * @param username username
     * @return User
     */
    User findByUsername(String username);

    /**
     * Query if the same username exists
     *
     * @param username username
     * @return Returns true if it already exists, false if it doesn't
     */
    Boolean existsUserByUsername(String username);
}
