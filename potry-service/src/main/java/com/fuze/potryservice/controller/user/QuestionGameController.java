package com.fuze.potryservice.controller.user;

import com.fuze.potryservice.service.PotryService;
import com.fuze.potryservice.service.QuestionGameService;
import com.fuze.result.Result;
import com.fuze.vo.PoemDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Autowired
private QuestionGameService questionGameService;
         @Value("120")
         private int gameTimeoutSeconds;
         private int sum=0;
    @ApiOperation("展示题目，一次调用出现一次题目")
    @GetMapping("questions")
    public Result<String> getQuestions(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("startTime", System.currentTimeMillis());// 记录开始时间
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
        questionGameService.addQuestion(temp.get(1));
        return Result.success(temp.get(0));
    }
@ApiOperation("检验是否答对")
    @GetMapping("check")
    public Result<String> check(String answer,HttpServletRequest request) {
    HttpSession session = request.getSession(false); // 使用false避免创建新的session
    if (session == null || session.getAttribute("startTime") == null) {
        questionGameService.deleteQuestion();
        sum=0;
        return Result.error("游戏会话无效，请重新开始");
    }
    long startTime = (Long) session.getAttribute("startTime");
    long currentTime = System.currentTimeMillis();
    if (currentTime - startTime > gameTimeoutSeconds * 1000L) {
        questionGameService.deleteQuestion();
        sum=0;
        return Result.error("游戏超时，请重新开始");
    }
    try {
        String daan = questionGameService.getQuestion();
        if (daan.equals(answer)) {
            questionGameService.deleteQuestion();
            sum+=10;
            return Result.success("答对了");
        } else {
            sum = 0;
            questionGameService.deleteQuestion();
            return Result.error("答错了,答案是" + daan);
        }
    }catch (Exception e){
        session.removeAttribute("startTime");
        throw e;
    }finally {
        // 无论成功还是失败都清除 startTime
        session.removeAttribute("startTime");
    }
}

@ApiOperation("总成绩传入数据库")
    @GetMapping("score")
    public Result<String> score(@RequestParam Integer userId){
    System.out.println("score");
        questionGameService.addsum(sum,userId);
        sum=0;
        return Result.success("答题结束");
    }

}
