package cn.liaocp.amireux.user.controller;

import cn.liaocp.amireux.core.AmireuxConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chunping.Liao
 * @date 2021/5/16
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(PermissionController.API)
public class PermissionController {

    public final static String API = AmireuxConstant.API + "/permission";

}
