package com.fuze.potryservice.mapper;

import com.fuze.entity.Poem;
import com.fuze.entity.Writer;
import com.fuze.vo.DynatryPoemResultVO;
import com.fuze.vo.PoemDataVo;
import com.fuze.vo.TypeDateVo;
import com.fuze.vo.WriterVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

@Mapper
public interface PotryMapper {
    @Select("select count(*) from poem.potry")
    Integer getcount();

    @Select("select title from poem.potry")
    List<String> GetAllPoemName();

    @Select("select *  from poem.potry where id=#{id}")
    Poem GetContentById(Integer id);

    @Select("select distinct dynasty from poem.potry")
    List<String> Getdynasty();

    List<DynatryPoemResultVO> GetDynastyPoemResulVo();

    @Select("select id,title,writer,content,type from poem.potry where dynasty=#{dynasty}")
    List<PoemDataVo> GetPoemDataVoByDynasty(String dynasty);
    @Select("select id,title,writer,content,type from poem.potry order by rand() limit 10")
    List<PoemDataVo> GetPoemDateRondom();
@Select("select id,title,dynasty,content,type from poem.potry where writer=#{writer}")
    List<PoemDataVo> GetPoemData(String name);
@Select("select type from poem.potry")
    List<String> GetType();
@Select("select title,content,writer,type,dynasty from poem.potry where type like concat('%',#{type},'%')")
    List<PoemDataVo> GetPoemDataByType(String type);
@Select("select * from  poem.potry where title like CONCAT('%',#{title},'%')")
    List<Poem>  GetContentByTitle(String title);
@Select("select * from poem.potry order by  rand() limit 1")
    PoemDataVo GetVeryGoodPoem();
//不使用模糊查询只有输入正确的名字才行
@Select("SELECT * FROM poem.writer WHERE name=#{name}")
WriterVo GetPoemWriter(String name);
}
