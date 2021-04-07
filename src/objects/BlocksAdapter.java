package objects;

import java.util.ArrayList;

public class BlocksAdapter extends Adapter {
    private int[][] mBlocksPosition = { {13, 4}, {14, 4}, {15, 1}, {15, 2}, {15, 3}, {15, 4}, {16, 4}, {17, 4}, {22, 1}, {22, 2}, {22, 3}, {22, 4}, {23, 1}, {23, 3}, {24, 1}, {24, 2}, {24, 3}, {26, 1}, {26, 2}, {26, 3}, {26, 4}, {39, 3}, {39, 4}, {40, 3}, {41, 1}, {41, 2}, {41, 3}, {41, 4}, {46, 1}, {46, 2}, {46, 3}, {47, 4}, {48, 3}, {49, 4}, {50, 1}, {50, 2}, {50, 3}, {54, 2}, {54, 3}, {55, 1}, {55, 4}, {56, 1}, {56, 4}, {57, 2}, {57, 3}, {61, 1}, {61, 3}, {61, 4}, };

    BlocksAdapter() {
        for (int i = 0; i < mBlocksPosition.length; i++) {
            Block b = new Block(x(mBlocksPosition[i][0]), y(mBlocksPosition[i][1]));
            this.add("block", b.getIcon(), b.getPosition());
        }
    }

}
