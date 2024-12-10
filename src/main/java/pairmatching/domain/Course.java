package pairmatching.domain;

import pairmatching.constant.ErrorMessage;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Course find(String courseName) {
        for (Course course : Course.values()) {
            if (course.getName().equals(courseName)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.COURSE_NOT_EXIST_ERROR.getErrorMessage());
    }
}
