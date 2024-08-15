package ch.szclsb.plugins.jextract;

import ch.szclsb.plugins.common.AbstractProcessMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "jextract")
public class JextractMojo extends AbstractProcessMojo {
    @Parameter(property = "includeDir", required = true)
    private String includeDir;
    @Parameter(property = "header", required = true)
    private String header;
    @Parameter(property = "library", required = true)
    private String library;
    @Parameter(property = "target", defaultValue = "src/main/java")
    private String target;
    @Parameter(property = "targetPackage", required = true)
    private String targetPackage;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Creating native API handle");
        executeCommands(new CommandLine("jextract",
                "--include-dir", includeDir,
                "--output", target,
                "--target-package", targetPackage,
                "--library", library,
                header));
        getLog().info("Finished building dll");
    }
}
