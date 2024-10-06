package com.fuze.potryservice.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionGameMapper {
    @Insert("INSERT INTO poem.questionsgame(answer) VALUE (#{answer})")
    void addQuestion(String s);
@Select("select * from poem.questionsgame")
    String getquestion();
@Delete("delete from poem.questionsgame")
    void deleteQuestion();
@Insert("INSERT INTO poem.gamerank(grand,userid) value (#{grand},#{userid})")
    void addsum(int grand, Integer userid);
}
