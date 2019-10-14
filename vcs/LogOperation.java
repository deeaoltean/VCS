package vcs;

import utils.OperationType;

import java.util.ArrayList;

public class LogOperation extends VcsOperation {
    public LogOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        for (int i = 0; i < vcs.getCurrentBranch().getBranch().size(); i++) {
            vcs.getOutputWriter().write("Commit id: "
                    + vcs.getCurrentBranch().getBranch().get(i).getId() + "\n");
            vcs.getOutputWriter().write("Message: "
                    + vcs.getCurrentBranch().getBranch().get(i).getMessage() + "\n");

            if (i != vcs.getCurrentBranch().getBranch().size() - 1) {
                vcs.getOutputWriter().write("\n");
            }
        }
        return 0;
    }

}
