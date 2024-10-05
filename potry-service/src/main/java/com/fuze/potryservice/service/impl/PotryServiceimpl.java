package com.fuze.potryservice.service.impl;

import com.fuze.entity.Poem;
import com.fuze.entity.Writer;
import com.fuze.potryservice.mapper.PotryMapper;
import com.fuze.potryservice.service.PotryService;
import com.fuze.vo.DynatryPoemResultVO;
import com.fuze.vo.PoemDataVo;
import com.fuze.vo.TypeDateVo;
import com.fuze.vo.WriterVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PotryServiceimpl implements PotryService {
    @Autowired
    private PotryMapper potryMapper;
    @Override
    public Integer getcount() {
       return potryMapper.getcount();
    }

    @Override
    public List<String> GetAllPoemName() {
        return potryMapper.GetAllPoemName();
    }

    @Override
    public Poem GetContentById(Integer id) {
        return potryMapper.GetContentById(id);
    }

    @Override
    public List<String> GetAllDynasty() {
        return potryMapper.Getdynasty();
    }

    @Override
    public List<DynatryPoemResultVO> GetDynastyPoemResulVo() {
        return potryMapper.GetDynastyPoemResulVo();
    }

    @Override
    public List<PoemDataVo> GetPoemDataVoByDynasty(String dynasty) {
        return potryMapper.GetPoemDataVoByDynasty(dynasty);
    }

    @Override
    public List<PoemDataVo> GetPoemDateRondom() {
        return potryMapper.GetPoemDateRondom();

    }

    @Override
    public PageInfo<PoemDataVo> GetPoemPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PoemDataVo> lis1 = potryMapper.GetPoemDateRondom();
        return new PageInfo<>(lis1);

    }

    @Override
    public List<PoemDataVo> GetPoemDataVoByWriter(String name) {
        return potryMapper.GetPoemData(name);
    }

    @Override
    public List<String> GetType() {
        List<String> list1=potryMapper.GetType();
        list1.removeIf(String::isEmpty);
        return list1;
    }

    @Override
    public List<PoemDataVo> GetPoemDataByType(String type) {
        return potryMapper.GetPoemDataByType(type);
    }

    @Override
    public List<Poem>  GetContentBytitle(String title) {
        return potryMapper.GetContentByTitle(title);
    }

    @Override
    public PoemDataVo GetVeryGoodPoem() {
        return potryMapper.GetVeryGoodPoem();
    }

    @Override
    public WriterVo GetPoemWriter(String name) {
        return potryMapper.GetPoemWriter(name);
    }


}
