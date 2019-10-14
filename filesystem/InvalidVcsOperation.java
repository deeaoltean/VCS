package filesystem;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public final class InvalidVcsOperation extends FileSystemOperation {
    /**
     * Invalid file system operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public InvalidVcsOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Execute the invalid file system operation operation.
     *
     * @param fileSystemSnapshot the active file system snapshot
     * @return return code
     */
    @Override
    public int execute(FileSystemSnapshot fileSystemSnapshot) {
        return ErrorCodeManager.VCS_BAD_CMD_CODE;
    }
}
