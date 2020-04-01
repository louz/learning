package io.jasonlu.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {

    @Test
    public void testReplaceAll() {
        String origin = "project: {{project_name}}";
        String result = StringUtils.replace(origin, "{{project_name}}", "project_a");

        assertEquals("project: project_a", result);
    }
}
