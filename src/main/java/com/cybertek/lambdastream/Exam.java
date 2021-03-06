package com.cybertek.lambdastream;

import com.cybertek.lambdastream.model.CourseAssigned;
import com.cybertek.lambdastream.model.CourseStatus;
import com.cybertek.lambdastream.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Exam {

    /**
     * Read all manager users.
     *
     * @return
     */
    public static List<User> readAllManagers() {
        // Write your stream code here to read all manager users.
        return null;
    }

    /**
     * Read all SUSPENDED users.
     *
     * @return
     */
    public static List<User> readAllSuspendedUsers() {
        //Write your stream code to read all users that have SUSPENDED status.
        return null;
    }

    /**
     * Count all courses.
     *
     * @return
     */
    public static Integer countCourses() {
        // Write your code for how many courses do we have?.
        return null;
    }


    /**
     * Group by and count courses by status.
     */
    public static Map<CourseStatus, Long> countCoursesByStatus() {
        //Write your code..
        return null;
    }

    /**
     * Sum all duration for all records.
     *
     * @return sum of duration.
     */
    public static Integer sumDurationForAllData() {
        return null;
    }

    /**
     * Find Courses attended by a specific user.
     *
     * @return
     */
    public static List<CourseAssigned> findCoursesByUser() {
        User specificUser = DataGenerator.findUserById(6);
        //Write your code to return all courses by specific user...;
        return null;
    }

    /**
     * Read all finished courses.
     * Modify response to show only course name, course duration, (user firstName + user lastName)
     */
    public static List<Map<String, Object>> modifyObject() {
        return null;
    }

    /**
     * Duration of course that is in hours return to week that specific user finished courses.
     * One week has 40 hours working time. divider parameter should be 40.
     * @return converted duration to week. {@link BigDecimal}
     */
    public static BigDecimal divideToWeek() {
        User specificUser = DataGenerator.findUserById(6);
        BigDecimal divideToWeek = new BigDecimal(40);
        return null;
    }

}
