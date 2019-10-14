package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class CommitOperation extends VcsOperation {
    public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        // checks if the staging is empty
        if (vcs.getTrace().size() == 1) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        } else {
            // creates the new commit
            operationArgs.remove(0);
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < operationArgs.size() - 1; i++) {
                message.append(operationArgs.get(i));
                message.append(" ");
            }

            // clears the staging
            message.append(operationArgs.get(operationArgs.size() - 1));
            Commit commit = new Commit(message.toString(), vcs.getActiveSnapshot());
            vcs.getCurrentBranch().setBranch(commit);
            for (int i = 1; i < vcs.getTrace().size(); i++) {
                vcs.getTrace().remove(i);
                i--;
            }
            vcs.setSaved(true);
        }
        return 0;
    }

}
