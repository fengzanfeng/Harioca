package com.harioca.shell;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Adds imports to the script.
 */
public class ImportsFinder {
    public static final String genericPattern = "(?:<(\\w+)(?:,\\s*(\\w+))*)*+>*";
    public static final String classPattern = "([A-Z]?[\\w\\.]+)";
    public static final String arrayPattern = "(?:\\[\\])?";
    private Pattern classPattern1 = Pattern.compile(classPattern + genericPattern + arrayPattern +
            "\\s+\\w+(?:\\[\\])?\\s*" +
            "=\\s*(?:(?:new\\s+" + classPattern + genericPattern + ")" +
            "|" +
            "(?:" + classPattern + "\\.\\w+)?.*)");
    private Pattern staticClassPattern = Pattern.compile(".*([A-Z]\\w*)\\.\\w+\\(.*\\).*");
    private Pattern classImportsPattern = Pattern.compile("\\s*import\\s+(?:\\w+\\.)+(\\w+);");
    private Pattern packageImportsPattern = Pattern.compile("\\s*import\\s+((?:\\w+\\.)+)\\*;");

    /**
     * Finds all used classes in script that do not have corresponding import
     *
     * @param script groovy script
     * @return list of class name to resolve
     */
    public Collection<String> findMissingImports(String script, ShellClassLoader classLoader) throws Exception {
        List<String> classImports = importsMatcher(script, classImportsPattern);

        List<String> packageImports = importsMatcher(script, packageImportsPattern);
        Set<String> missingImports = new HashSet<>();

        missingImports.addAll(importsByMatcher(classLoader, classImports, packageImports, classPattern1.matcher(script)));
        missingImports.addAll(importsByMatcher(classLoader, classImports, packageImports, staticClassPattern.matcher(script)));

        return missingImports;
    }

    private Set<String> importsByMatcher(ShellClassLoader classLoader, List<String> classImports, List<String> packageImports, Matcher classMatcher) throws Exception {
        Set<String> missingImports = new HashSet<>();
        while (classMatcher.find()) {
            for (int i = 1; i <= classMatcher.groupCount(); i++) {
                String className = classMatcher.group(i);
                if (className != null
                        && !classImports.contains(className)
                        && !importedThroughPackage(className, packageImports, classLoader)) {
                    missingImports.add(getFullClassName(className, classLoader));
                }
            }
        }
        return missingImports;
    }

    private boolean importedThroughPackage(String className, List<String> staticImports, ShellClassLoader classLoader) {
        for (String importedPackage : staticImports) {
            try {
                classLoader.findClass(importedPackage + className);
                return true;
            } catch (ClassNotFoundException notFound) {
            }
        }
        return false;
    }

    private List<String> importsMatcher(String script, Pattern pattern) {
        List<String> imports = new ArrayList<>();
        Matcher importsMatcher = pattern.matcher(script);
        while (importsMatcher.find()) {
            imports.add(importsMatcher.group(1));
        }
        return imports;
    }

    public String getFullClassName(String className, ShellClassLoader classLoader) throws Exception {
        for (String applicationPackage : getApplicationPackages(classLoader)) {
            try {
                return Class.forName(applicationPackage + "." + className, false, classLoader).getName();
            } catch (ClassNotFoundException notFound) {
            }
        }
        return null;
    }

    public Collection<String> getApplicationPackages(ShellClassLoader classLoader) throws Exception {
        Set<String> packages = new HashSet<String>();
        for (Package aPackage : classLoader.getPackages()) {
            packages.add(aPackage.getName());
        }
        packages.addAll(classLoader.getAddedPackages());
        return packages;
    }
}
