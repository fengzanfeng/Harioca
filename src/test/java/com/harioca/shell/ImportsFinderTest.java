package com.harioca.shell;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImportsFinderTest {

    private final ImportsFinder importsFinder = new ImportsFinder();

    @Test
    public void definitionClassNotFoundTest() throws Exception{
        String script = "String a = \"\";";
        Collection<String> missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(1, missingImports.size());
        assertTrue(missingImports.contains("String"));

        script = "List<String> a = new ArrayList<String>();";
        missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(3, missingImports.size());
        assertTrue(missingImports.contains("ArrayList"));
        assertTrue(missingImports.contains("List"));
        assertTrue(missingImports.contains("String"));

        script = "Map<String, Object> a = Collections.emptyMap()";

        missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(4, missingImports.size());
        assertTrue(missingImports.contains("Map"));
        assertTrue(missingImports.contains("String"));
        assertTrue(missingImports.contains("Object"));
        assertTrue(missingImports.contains("Collections"));
    }


    @Test
    public void foundInImportTest() throws Exception {
        String script = "import java.lang.String;" +
                "String a = \"\";";
        Collection<String> missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(0, missingImports.size());

        script = "import java.util.List;" +
                "List<String> a = new ArrayList<String>();";
        missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(2, missingImports.size());
        assertTrue(missingImports.contains("ArrayList"));
        assertTrue(missingImports.contains("String"));

        script = "import java.util.*;" +
                "Map<String, Object> a = Collections.emptyMap()";

        missingImports = importsFinder.findMissingImports(script, new ShellClassLoader());
        assertEquals(2, missingImports.size());
        assertTrue(missingImports.contains("String"));
        assertTrue(missingImports.contains("Object"));
    }

}
