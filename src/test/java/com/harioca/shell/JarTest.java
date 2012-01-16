package com.harioca.shell;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: elena
 * Date: 13/12/11
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class JarTest {

    @Test
    public void test() throws Exception {
        URL hadoopURL = getClass().getClassLoader().getResource("hadoop_lib/hadoop-core-0.20.204.0.jar");
        List<String> packages = new ArrayList();
        File jarFile = new File(hadoopURL.toURI());
        JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile));
        JarEntry entry;
        while ((entry = jarInputStream.getNextJarEntry()) != null) {
            if (entry.isDirectory()) {
                String directory = entry.getName();
                packages.add(directory.replace('/', '.').substring(0, directory.length() - 1));
            }
        }
        System.out.println(packages);
    }
}
