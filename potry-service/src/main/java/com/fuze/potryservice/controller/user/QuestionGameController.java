package com.fuze.potryservice.controller.user;

import com.fuze.potryservice.service.PotryService;
import com.fuze.result.Result;
import com.fuze.vo.PoemDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/game")
@Api(tags ="用户游戏的相关接口")
@Slf4j
public class QuestionGameController {
@Autowired
private PotryService potryService;

    @ApiOperation("展示题目，一次调用出现一次题目")
    @GetMapping("questions")
    public Result<String> getQuestions(){
    PoemDataVo questions=potryService.GetVeryGoodPoem();
   String content =questions.getContent();
        String[] parts = content.split("。");
        List<String> line=new ArrayList<>();
        for(String part : parts){
            String trimmedPart = part.trim();
            if (!trimmedPart.isEmpty()) {
                line.add(trimmedPart);
            }
        }
        String[] part = line.get(0).split("，");
        List<String> temp = new ArrayList<>();
        for(String s : part){
            temp.add(s);
        }

        return Result.success(temp.get(0));
    }


}
