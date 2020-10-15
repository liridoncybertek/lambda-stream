package com.cybertek.lambdastream;

import com.cybertek.lambdastream.model.CourseAssigned;
import com.cybertek.lambdastream.model.CourseStatus;
import com.cybertek.lambdastream.model.User;
import com.cybertek.lambdastream.model.UserState;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exam {

    /**
     * Read all manager users.
     * Read all users that role name is equal to "MANAGER".
     * Read all users via "filter" streamline keyword.
     *
     * @return list of managers {@link List<User>}.
     */
    public static List<User> readAllManagers() {
        return DataGenerator.fillUsers().stream()
                .filter(user -> user.getRole().getName().equals("MANAGER"))
                .collect(Collectors.toList());
    }

    /**
     * Read all SUSPENDED users.
     * Read all users that role is SUSPENDED.
     * Make condition using "==" sign instead of .equal() comparing strings method.
     *
     * @return suspended users. {@link List<User>}
     */
    public static List<User> readAllSuspendedUsers() {
        return DataGenerator.fillUsers().stream()
                .filter(user -> user.getState() == UserState.SUSPENDED)
                .collect(Collectors.toList());
    }

    /**
     * Count all courses.
     *
     * @return number of courses {@link Integer}
     */
    public static Integer countCourses() {
        return DataGenerator.fillCourses().size();
    }


    /**
     * Group by and count courses by status.
     * Count courses by status via "groupingBy" streamline keyword.
     * Return a specific result with course status and size of records for that course status
     *
     * @return a specific map, with course status and size of records for that. {@link Map<CourseStatus,Long>}
     */
    public static Map<CourseStatus, Long> countCoursesByStatus() {
        return DataGenerator.fillCoursesAssigned().stream()
                .collect(Collectors.groupingBy(CourseAssigned::getStatus, Collectors.counting()));
    }

    /**
     * Sum all duration for all records.
     * Sum all course duration without any condition via "reduce" stream keyword.
     *
     * @return sum of duration. {@link Integer}.
     */
    public static Integer sumDurationForAllData() {
        return DataGenerator.fillCoursesAssigned().stream()
                .map(x -> x.getCourse().getDuration())
                .reduce(0, Integer::sum);

    }

    /**
     * Find Courses attended by a specific user.
     *
     * @return
     */
    public static List<CourseAssigned> findCoursesByUser() {
        User specificUser = DataGenerator.findUserById(6);

        return DataGenerator.fillCoursesAssigned().stream()
                .filter(courseAssigned -> courseAssigned.getUser().equals(specificUser))
                .collect(Collectors.toList());
    }

    /**
     * Read all finished courses.
     * Modify response to show only course name, course duration, (user firstName + user lastName)
     */
    public static List<Map<String, Object>> modifyObject() {
        List<Map<String, Object>> result = DataGenerator.fillCoursesAssigned().stream()
                .filter(course -> course.getStatus() == CourseStatus.FINISHED)
                .map(course -> {
                    Map<String, Object> modifyResult = new HashMap<>();
                    modifyResult.put("courseName", course.getCourse().getName());
                    modifyResult.put("courseDuration", course.getCourse().getDuration());
                    modifyResult.put("username", course.getUser().getFirstName() + " " + course.getUser().getLastName());
                    return modifyResult;
                }).collect(Collectors.toList());
        return result;
    }

    /**
     * Duration of course that is in hours return to week that specific user finished courses.
     * One week has 40 hours working time. divider parameter should be 40.
     * Filter all courses by a specific user and course status to be FINISHED via "filter" stream keyword.
     * convert duration from integer to bigDecimal via "map" keyword.
     * Sum all courses hours via "reduce" keyword.
     * Divide getting result in hours with @{@link BigDecimal#divideToWeek} parameter.
     * @return converted duration to week. {@link BigDecimal}
     */
    public static BigDecimal divideToWeek() {
        User specificUser = DataGenerator.findUserById(6);
        BigDecimal divideToWeek = new BigDecimal(40);
        BigDecimal convertToWeek = DataGenerator.fillCoursesAssigned().stream()
                .filter(courseAssigned -> courseAssigned.getStatus() == CourseStatus.FINISHED && courseAssigned.getUser().equals(specificUser))
                .map(courseAssigned -> new BigDecimal(courseAssigned.getCourse().getDuration()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(divideToWeek, 2);

        return convertToWeek;
    }
}
