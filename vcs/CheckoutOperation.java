package vcs;


import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class CheckoutOperation extends VcsOperation {
    public CheckoutOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    public final int execute(Vcs vcs) {
        ArrayList<String> operationArgs = getOperationArgs();
        // checks if the taging is empty
        if (vcs.getTrace().size() == 1) {
           if (operationArgs.get(0).equals("-c")) {
               // delates all the commits till I reach the one I did the checkout on
               boolean b = false;
               String noCommit = operationArgs.get(1);
               for (int i = 0; i < vcs.getCurrentBranch().getBranch().size(); i++) {
                    if (vcs.getCurrentBranch().getBranch().get(i).getId()
                            == Integer.valueOf(noCommit)) {
                        for (int j = i + 1; j < vcs.getCurrentBranch().getBranch().size(); j++) {
                            vcs.getCurrentBranch().getBranch().remove(j);
                            j--;
                        }
                        vcs.setActiveSnapshot(vcs.getCurrentBranch().
                                getBranch().get(i).getSnapshot());
                        b = true;
                    }
               }
               if (!b) {
                   return ErrorCodeManager.VCS_BAD_PATH_CODE;
               }

           } else {
               // moves at the end of the needed branch
               boolean b = false;
               int pos = 0;
               for (int i = 0; i < vcs.getSystem().size(); i++) {
                   if (operationArgs.get(0).equals(vcs.getSystem().get(i).getName())) {
                       b = true;
                       pos = i;
                   }
               }

               if (!b) {
                   return ErrorCodeManager.VCS_BAD_CMD_CODE;
               } else {
                   vcs.setCurrentBranch(vcs.getSystem().get(pos));
               }
           }
        } else {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }
        return 0;
    }
}
