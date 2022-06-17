package ru.itis.diplom.check;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.diplom.algorithm.VectorSearch;
import ru.itis.diplom.models.Answer;
import ru.itis.diplom.models.Task;
import ru.itis.diplom.models.TaskType;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckHandler {
    @Transactional
    public boolean check(Task task, Object answer) {
        if (task.getType() == TaskType.TEXT) {
            List<String> ans = new ArrayList<>();
            for (Answer a : task.getAnswers()) {
                ans.add(a.getAnswer());
            }
            return VectorSearch.check((String) answer, ans);
        } else if ((task.getType() == TaskType.STRING) || (task.getType() == TaskType.SELECT_ONE) || (task.getType() == TaskType.SEQUENCE) || (task.getType() == TaskType.SELECT_SOME)) {
            String ans = answer.toString();
            for (Answer a : task.getAnswers()) {
                if (a.getAnswer().equals(ans)) return true;
            }
            return false;
        } /*else if  {
            String[] answers = (String[]) answer;
            int count = 0;
            if (answers.length == task.getAnswers().size()) {
                for (String s : answers) {
                    for (Answer a: task.getAnswers()) {
                        if (s.equals(a.getAnswer())) {
                            count++;
                        }
                    }
                }
                return count == answers.length;
            } else return false;
        }
         */
         else return false;
    }
}
