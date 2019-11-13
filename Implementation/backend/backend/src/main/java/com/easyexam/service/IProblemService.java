package com.easyexam.service;


import com.easyexam.model.Problem;
import com.easyexam.model.aux.ProblemCompleted;

public interface IProblemService {

    Boolean save(ProblemCompleted p);

    List<Problem> getAllProblems();

    List<ProblemSubmitted> findUserProblem(int idUser);

    List<ProblemTopic> getProblemTopics(int idProb);

    Boolean saveProblemSelected(ProblemSelected promSecl);
}
