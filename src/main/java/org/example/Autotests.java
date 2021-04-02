package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.net.URL;

@Command(name = "autotests", description = "Autotests for frontend")
public class Autotests implements Runnable {
    @Option(names = {"-u", "--url"}, description = "URL to frontend", required = true)
    String url;

    @Option(names = {"-l", "--login"}, description = "Login for profile", required = true)
    String login;

    @Option(names = {"-p", "--password"}, description = "Password for profile", required = true)
    String password;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Autotests()).execute(args);
    }

    @Override
    public void run() {
        TestExecutor testExecutor = new TestExecutor(url, login, password);
    }
}
