package de.oforge.osgi.repo.builder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.indexer.ResourceIndexer;
import org.osgi.service.indexer.impl.BundleAnalyzer;
import org.osgi.service.indexer.impl.KnownBundleAnalyzer;
import org.osgi.service.indexer.impl.OSGiFrameworkAnalyzer;
import org.osgi.service.indexer.impl.RepoIndex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author Matthaeus.schmedding
 */
public class RepoBuilder {


    public static void main(String[] args) throws Exception {

        Map<String, String> config = new HashMap<>();
        config.put(ResourceIndexer.REPOSITORY_NAME, "recalot.com OSGi Bundle Repository");
      //  config.put(ResourceIndexer.SOURCE_BASE_URL, "http://recalot.com/download/");
        config.put(ResourceIndexer.SOURCE_BASE_URL, "file:/C:/Privat/3_Uni/5_Workspaces/recalot.com/");
        config.put(ResourceIndexer.COMPRESSED, "false");
        config.put(ResourceIndexer.VERBOSE, "false");
        config.put(ResourceIndexer.PRETTY, "true");
        RepoIndex indexer = new RepoIndex();
        indexer.addAnalyzer(new MyTestAnalyser(), null);

        Set<File> inputs = findInputs("out/production");
        OutputStream output = new FileOutputStream("bundles/repo.xml");
        indexer.index(inputs, output, config);
    }


    private static Set<File> findInputs(String path) {
        Set<File> files = new HashSet<>();

        File dir = new File(path);
        System.out.println(dir.getAbsolutePath());
        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.getName().endsWith(".jar")) {
                    files.add(file);
                }
            }
        }
        System.out.println("Found " + files.size() + " files");
        return files;
    }
}
