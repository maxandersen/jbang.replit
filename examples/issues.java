//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.2.0

//REPOS jboss-nexus=https://repository.jboss.org/nexus/content/groups/public/
//DEPS org.jboss.set:jboss-aphrodite-github:0.7.9.Final

import org.jboss.set.aphrodite.Aphrodite;
import org.jboss.set.aphrodite.domain.Issue;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.net.URL;
import java.util.concurrent.Callable;

@Command(name = "issues", mixinStandardHelpOptions = true, version = "issues 0.1",
        description = "issues made with jbang")
class issues implements Callable<Integer> {

    @Parameters(index = "0", description = "The greeting to print", defaultValue = "World!")
    private String greeting;

    public static void main(String... args) {
        int exitCode = new CommandLine(new issues()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println("Hello " + greeting);

        var aphrodite = Aphrodite.instance();
        Issue issue = aphrodite.getIssue(new URL("https://issues.stage.jboss.org/browse/WFLY-100"));

        System.out.println(issue);

        return 0;
    }
}
