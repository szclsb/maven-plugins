package ch.szclsb.plugins.cmake;

import ch.szclsb.plugins.common.AbstractProcessMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "cmake")
public class CMakeMojo extends AbstractProcessMojo {
    @Parameter(property = "nativePath", defaultValue = "native")
    private String nativePath;
    @Parameter(property = "nativeBuildPath", defaultValue = "native-build")
    private String nativeBuildPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Compiling native dll");
        executeCommands(
                new CommandLine("cmake",
                        "-S", nativePath,
                        "-B", nativeBuildPath,
                        "."),
                new CommandLine("cmake",
                        "--build", "./" + nativeBuildPath)
        );
        getLog().info("Finished building dll");
    }
}
