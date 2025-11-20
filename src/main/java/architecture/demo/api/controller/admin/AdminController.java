package architecture.demo.api.controller.admin;


import architecture.demo.dao.mapper.UserInfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private UserInfoMapper userInfoMapper;

	@GetMapping("/listUserById")
    public int listUserById() {
        return userInfoMapper.selectList(null).size();
    }
}
