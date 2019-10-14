package vcs;

import utils.OperationType;
import java.util.ArrayList;

public class StatusOperation extends VcsOperation {
    public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        vcs.getOutputWriter().write("On branch: " + vcs.getCurrentBranch().getName());
        vcs.getOutputWriter().write("\n" + vcs.getTrace().get(0));
        // prints the staging
        for (int i = 1; i < vcs.getTrace().size(); i++) {
            vcs.getOutputWriter().write("\n\t" + vcs.getTrace().get(i));
        }

        vcs.getOutputWriter().write("\n");
        return 0;
    }
}
