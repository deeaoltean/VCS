package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.OutputWriter;
import utils.Visitor;

import java.util.ArrayList;

public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private ArrayList<String> trace;
    private Branch branch;
    private ArrayList<Branch> system = new ArrayList<Branch>();
    private boolean saved = true;
    private Commit commit;

    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    /**
     * Does initialisations.
     */
    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);
        this.trace = new ArrayList<String>();
        this.trace.add("Staged changes:");
        this.branch = new Branch();
        this.commit = new Commit(activeSnapshot);
        branch.setBranch(commit);
        this.system.add(this.branch);
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
        return vcsOperation.execute(this);
    }
    public ArrayList<String> getTrace() {
        return this.trace;
    }
    public void setTrace(String s) {
        this.trace.add(s);
    }
    public ArrayList<Branch> getSystem() {
        return this.system;
    }
    public void setCurrentBranch(Branch currentBranch) {
        this.branch = currentBranch;
    }
    public Branch getCurrentBranch() {
        return this.branch;
    }
    public void setSystem(Branch newBranch) {
        this.system.add(newBranch);
    }
    public boolean getSaved() {
        return this.saved;
    }
    public void setSaved(boolean x) {
        this.saved = x;
    }
    public OutputWriter getOutputWriter() {
        return this.outputWriter;
    }
    public FileSystemSnapshot getActiveSnapshot() {
        return this.activeSnapshot;
    }
    public void setActiveSnapshot(FileSystemSnapshot snapshot) {
        this.activeSnapshot = snapshot;
    }
}
