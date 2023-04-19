package com.back.prev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

	@Select("select id_profile from pv_profile")
	List<Long> listTest();
}
