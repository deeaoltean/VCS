package vcs;

import filesystem.FileSystemSnapshot;
import utils.IDGenerator;

public class Commit {
    private String message;
    private FileSystemSnapshot snapshot;
    private int id;

    public Commit(FileSystemSnapshot snapshot) {
        this.message = "First commit";
        this.snapshot = snapshot.cloneFileSystem();
        this.id = IDGenerator.generateCommitID();
    }
    public Commit(String message, FileSystemSnapshot snapshot) {
        this.message = message;
        this.snapshot = snapshot.cloneFileSystem();
        this.id = IDGenerator.generateCommitID();
    }

    /**
     *
     * @return the snapshot of the commit
     */
    public FileSystemSnapshot getSnapshot() {
        return this.snapshot;
    }

    /**
     *
     * @param snapshot is the new snapshot off the sistem
     */
    public void setSnapshot(FileSystemSnapshot snapshot) {
        this.snapshot = snapshot.cloneFileSystem();
    }

    /**
     *
     * @return the id of the commit
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @return the message of the commit command
     */
    public String getMessage() {
        return this.message;
    }
}
