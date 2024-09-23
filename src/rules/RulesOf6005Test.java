/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    
    @Test
    public void testUncitedPubliclyAvailableCode() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }

    @Test
    public void testSelfWrittenRequiredCode() {
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

   
    @Test
    public void testCitedPubliclyAvailableCode() {
        assertTrue("Expected true: properly cited, publicly available, not course work, and implementation not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

   
    @Test
    public void testCitedCodeFromPreviousCourseWork() {
        assertFalse("Expected false: publicly available and cited, but from previous course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

   
    @Test
    public void testNotPubliclyAvailableButCited() {
        assertFalse("Expected false: not publicly available, even though cited",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }

    
    @Test
    public void testSelfWrittenNotRequiredButAvailable() {
        assertTrue("Expected true: self-written, not required but still valid",
                RulesOf6005.mayUseCodeInAssignment(true, true, false, false, false));
    }
}
