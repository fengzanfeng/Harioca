package com.harioca.shell;

import org.xeustechnologies.jcl.JarClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ShellClassLoader extends JarClassLoader {

    private final List<URL> resources = new ArrayList<>();

    public ShellClassLoader() {
    }

    public ShellClassLoader(String hadoopVersion, String hbaseVersion) {
        add(getResource("hadoop_lib/hadoop-core-" + hadoopVersion + ".jar"));
        add(getResource("hadoop_lib/hbase-" + hbaseVersion + ".jar"));
    }

    @Override
    public void add(URL url) {
        super.add(url);
        resources.add(url);
    }

    public List<String> getAddedPackages() {
        List<String> packages = new ArrayList<>();
        try {
            for (URL url : resources) {
                File jarFile = new File(url.toURI());
                JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile));
                JarEntry entry;
                while ((entry = jarInputStream.getNextJarEntry()) != null) {
                    if (entry.isDirectory()) {
                        String directory = entry.getName();
                        packages.add(directory.replace('/', '.').substring(0, directory.length() - 1));
                    }
                }
            }
        } catch (Exception exception) {
            //todo add logging
        }
        return packages;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Package[] getPackages() {
        return super.getPackages();
    }
}
