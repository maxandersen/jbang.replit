//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.2.0
//DEPS org.kohsuke:github-api:1.101

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "ghactions", mixinStandardHelpOptions = true, version = "ghactions 0.1",
        description = "ghactions made with jbang")
class ghactions implements Callable<Integer> {

    @Option(names={"--token"}, required = true, description = "Github token to use", defaultValue = "${GITHUB_TOKEN}")
    private String token;

    public static void main(String... args) {
        int exitCode = new CommandLine(new ghactions()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...

        var github = new GitHubBuilder().withOAuthToken(token).build();

        github.getRepository("")

        return 0;
    }
}
