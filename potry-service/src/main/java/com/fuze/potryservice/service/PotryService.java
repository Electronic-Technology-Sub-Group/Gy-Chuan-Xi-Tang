package com.fuze.potryservice.service;

import com.fuze.entity.Poem;
import com.fuze.entity.Writer;
import com.fuze.vo.DynatryPoemResultVO;
import com.fuze.vo.PoemDataVo;
import com.fuze.vo.TypeDateVo;
import com.fuze.vo.WriterVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface PotryService {
    Integer getcount();

    List<String> GetAllPoemName();

    Poem GetContentById(Integer id);

    List<String> GetAllDynasty();

    List<DynatryPoemResultVO> GetDynastyPoemResulVo();

    List<PoemDataVo> GetPoemDataVoByDynasty(String dynasty);

    List<PoemDataVo> GetPoemDateRondom();

    PageInfo<PoemDataVo> GetPoemPage(Integer pageNum, Integer pageSize);

    List<PoemDataVo> GetPoemDataVoByWriter(String name);


    List<String> GetType();

    List<PoemDataVo> GetPoemDataByType(String type);

    List<Poem> GetContentBytitle(String title);

    PoemDataVo GetVeryGoodPoem();

    WriterVo GetPoemWriter(String name);
}
