package com.se.tss.ExamOnline.Domain;

import java.util.ArrayList;
import java.util.List;

public class GradeResponseBody {
    public static class ExamGrade {
        private Exam exam;
        private Double grade;
        private Double maxGrade;
        private String maxName;
        private Double minGrade;
        private String minName;
        private Double avgGrade;

        public Double getGrade() {
            return grade;
        }

        public void setGrade(Double grade) {
            this.grade = grade;
        }

        public Exam getExam() {
            return exam;
        }

        public void setExam(Exam exam) {
            this.exam = exam;
        }

        public Double getAvgGrade() {
            return avgGrade;
        }

        public void setAvgGrade(Double avgGrade) {
            this.avgGrade = avgGrade;
        }

        public Double getMaxGrade() {
            return maxGrade;
        }

        public void setMaxGrade(Double maxGrade) {
            this.maxGrade = maxGrade;
        }

        public Double getMinGrade() {
            return minGrade;
        }

        public void setMinGrade(Double minGrade) {
            this.minGrade = minGrade;
        }

        public String getMaxName() {
            return maxName;
        }

        public void setMaxName(String maxName) {
            this.maxName = maxName;
        }

        public String getMinName() {
            return minName;
        }

        public void setMinName(String minName) {
            this.minName = minName;
        }
    }

    private String msg;

    private List<ExamGrade> examGrades;

    public GradeResponseBody(String msg) {
        this.msg = msg;
        this.examGrades = null;
    }

    public GradeResponseBody(String msg, List<ExamGrade> examGrades) {
        this.msg = msg;
        this.examGrades = examGrades;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ExamGrade> getExamGrades() {
        return examGrades;
    }

    public void setExamGrades(List<ExamGrade> examGrades) {
        this.examGrades = examGrades;
    }
}
