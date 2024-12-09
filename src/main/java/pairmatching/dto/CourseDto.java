package pairmatching.dto;

import pairmatching.constant.Course;

public class CourseDto {

    private final Course course;

    public CourseDto(Course course) {
        this.course = course;
    }

    public String getName() {
        return course.name();
    }
}
