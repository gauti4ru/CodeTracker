package org.example;

import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        git();

    }
    public  static void git() throws IOException {
        Repository repo = new FileRepositoryBuilder()
                .setGitDir(new File("/Users/gauti4ru/Downloads/Testing/.git"))
                .build();


        // Get a reference
        Ref master = repo.getRef("main");

// Get the object the reference points to
        ObjectId masterTip = master.getObjectId();

// Rev-parse
        ObjectId obj = repo.resolve("HEAD^{tree}");

// Load raw object contents
        ObjectLoader loader = repo.open(masterTip);
        loader.copyTo(System.out);

// Create a branch
        RefUpdate createBranch1 = repo.updateRef("refs/heads/branch1");
        createBranch1.setNewObjectId(masterTip);
        createBranch1.update();


    }
}