package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class BranchOperation extends VcsOperation {
    public BranchOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        ArrayList<String> operationArgs = getOperationArgs();
        ErrorCodeManager error = ErrorCodeManager.getInstance();
        // checks if branch already exists
        for (int i = 0; i < vcs.getSystem().size(); i++) {
            if (operationArgs.get(0).equals(vcs.getSystem().get(i).getName())) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }
        }

        // creates the branch
        vcs.setSaved(false);
        Branch newBaranch = new Branch();
        Commit newCommit = new Commit(vcs.getCurrentBranch().getBranch().get(0).getSnapshot());
        newBaranch.setName(operationArgs.get(0));
        newBaranch.setBranch(newCommit);
        vcs.setSystem(newBaranch);
        return 0;
    }

}
