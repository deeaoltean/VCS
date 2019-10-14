package vcs;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Commit> branch;
    private String name;
    public Branch() {
        this.branch = new ArrayList<Commit>();
        this.name = "master";
    }

    /**
     *
     * @return the name of the branch
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name is the new name of the branch
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the list of commits
     */
    public ArrayList<Commit> getBranch() {
        return this.branch;
    }

    /**
     *
     * @param commit
     */
    public void setBranch(Commit commit) {
        this.branch.add(commit);
    }
}
