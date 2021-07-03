package cn.liaocp.amireux.core.properties;

import lombok.Data;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Load application.yml file configuration
 *
 * @author Chunping.Liao
 * @date 2021/5/16
 */
@Data
@Component
@ConfigurationProperties(prefix = "amireux.security")
public class SecurityProperties {

    /**
     * Token expire time (hour)
     * 168 hours by default
     */
    private Integer tokenExpireTime = 168;

    /**
     * Token expire time (hour)
     * 8760 hours (One year) by default
     */
    private Integer secretExpireTime = 8760;

    /**
     * Anonymous Access URL
     */
    private Set<String> whiteList;

    /**
     * Enable dynamic generation secret
     */
    private Boolean secretDynamicEnable;

    /**
     * If the secretDynamicEnable value is false, then use this secretKey
     */
    private String secretKey;

}
