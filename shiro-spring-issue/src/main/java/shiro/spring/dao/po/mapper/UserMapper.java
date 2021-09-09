package shiro.spring.dao.po.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import shiro.spring.dao.po.User;

/**
 * @author chenzhi.xu
 * @date 2021/09/09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
