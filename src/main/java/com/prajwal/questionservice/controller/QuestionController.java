package com.prajwal.questionservice.controller;


import com.prajwal.questionservice.entity.Question;
import com.prajwal.questionservice.entity.QuestionWrapper;
import com.prajwal.questionservice.entity.Response;
import com.prajwal.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();

    }
   /*
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();

    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

   /* @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }*/

    @GetMapping("/byCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    /*@PutMapping("/{id}")
    public String updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question).getBody();
    }
*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        return questionService.deleteQuestion(id);
    }

/*
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }*/

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam String categoryName,
            @RequestParam Long numQuestions
    ) {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }


    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {

        return questionService.getQuestionsFromId(questionIds);
    }


    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }

        //generate
        //getQuestions (questionid)
        //getScore
    }


/*
Here are some sample URLs and request bodies you can use to test all the methods using Postman:

1. GET all questions: http://localhost:8080/question/allQuestions

   Request method: GET

2. GET question by ID: `http://localhost:8080/question/2`

   Request method: GET

   Replace `{id}` with the ID of the question you want to retrieve.

3. GET questions by category: `http://localhost:8080/question/byCategory/{category}`

   Request method: GET

   Replace `{category}` with the category of the questions you want to retrieve.

4. POST create question: `http://localhost:8080/question/addQuestion`

   Request method: POST

   Request body (JSON):
   ``````
   {
       "category": "History",
       "difficultyLevel": "Easy",
       "questionTitle": "What year did World War II end?",
       "option1": "1945",
       "option2": "1940",
       "option3": "1950",
       "option4": "1939",
       "rightAnswer": "1945"
   }
   ```

5. PUT update question: `http://localhost:8080/question/{id}`

   Request method: PUT

   Request body (JSON):
   ````
   {
       "category": "History",
       "difficultyLevel": "Easy",
       "questionTitle": "What year did World War II end?",
       "option1": "1945",
       "option2": "1940",
       "option3": "1950",
       "option4": "1939",
       "rightAnswer": "1945"
   }
   `````

   Replace `{id}` with the ID of the question you want to update.

6. DELETE question: `http://localhost:8080/question/{id}`

   Request method: DELETE

   Replace `{id}` with the ID of the question you want to delete.

Note: Make sure to set the correct request method for each URL (GET, POST, PUT, or DELETE) and set the `Content-Type` header of the request to `application/json` when sending the request body.
* */