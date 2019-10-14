package vcs;

import utils.OperationType;

import java.util.ArrayList;

public class RollbackOperation extends VcsOperation {
    public RollbackOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        // gets the last snapshot and sets it active
        vcs.setActiveSnapshot(vcs.getCurrentBranch().getBranch().
                get(vcs.getCurrentBranch().getBranch().size() - 1).getSnapshot());
        for (int i = 1; i < vcs.getTrace().size(); i++) {
            vcs.getTrace().remove(i);
            i--;
        }
        return 0;
    }
}
