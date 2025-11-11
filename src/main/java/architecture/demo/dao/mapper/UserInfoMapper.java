package architecture.demo.dao.mapper;

import architecture.demo.dao.domain.authentication.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
