package rules;

public class RulesOf6005 {

    /**
     * Judge whether a given piece of code may be used in an assignment (problem
     * set or team project) or not, according to the 6.005 collaboration policy.
     * 
     * @param writtenByYourself true if the code in question was written by
     *        yourself or, in the case of a team project, your teammates,
     *        otherwise false.
     * @param availableToOthers if not writtenByYourself, whether or not the
     *        code in question is available to all other students in the class.
     *        Otherwise ignored.
     * @param writtenAsCourseWork if not writtenByYourself, whether or not the
     *        code in question was written specifically as part of a solution to
     *        a 6.005 assignment, in the current or past semesters. Otherwise
     *        ignored.
     * @param citingYourSource if not writtenByYourself, whether or not you
     *        properly cite your source. Otherwise ignored.
     * @param implementationRequired whether the assignment specifically asks
     *        you to implement the feature in question.
     * @return Whether or not, based on the information provided in the
     *         arguments, you are likely to be allowed to use the code in
     *         question in your assignment, according to the 6.005 collaboration
     *         policy for the current semester.
     */
    public static boolean mayUseCodeInAssignment(boolean writtenByYourself,
            boolean availableToOthers, boolean writtenAsCourseWork,
            boolean citingYourSource, boolean implementationRequired) {
        
        // If you wrote the code yourself or it was written by your teammates, you may use it.
        if (writtenByYourself) {
            return false;
        }
        
        // If you didn't write it yourself:
        // - it must be available to others
        // - not from previous course assignments (as that would be an unfair advantage)
        // - it must be properly cited
        // - the assignment doesn't require implementation
        if (availableToOthers && !writtenAsCourseWork && citingYourSource && !implementationRequired) {
            return false;
        }
        
        // In all other cases, you may not use the code.
        return true;
    }

    /**
     * Main method of the class.
     * 
     * Runs the mayUseCodeInAssignment method.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("You may certainly use code you wrote yourself: " +
            RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        
        System.out.println("You may use code available to others, properly cited, and not course-related: " +
            RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
        
        System.out.println("You may not use code from previous course work: " +
            RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
}
