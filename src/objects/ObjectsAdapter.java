package objects;

public class ObjectsAdapter extends Adapter{
    private BlocksAdapter mBlocksAdapter;
    private TrianglesAdapter mTrianglesAdapter;
    public ObjectsAdapter() {
        mBlocksAdapter = new BlocksAdapter();
        mTrianglesAdapter = new TrianglesAdapter();
        for (int i = 0; i < mBlocksAdapter.size(); i++) {
            this.add(mBlocksAdapter.getType(i), mBlocksAdapter.getIcon(i), mBlocksAdapter.getPosition(i));
            System.out.println(mBlocksAdapter.getType(i));
            System.out.println(mBlocksAdapter.getPosition(i)[0]);
            System.out.println(mBlocksAdapter.getPosition(i)[1]);
            System.out.println("----------------");
        }

        for (int i = 0; i < mTrianglesAdapter.size(); i++) {
            this.add(mTrianglesAdapter.getType(i), mTrianglesAdapter.getIcon(i), mTrianglesAdapter.getPosition(i));
            System.out.println(mTrianglesAdapter.getType(i));
            System.out.println(mTrianglesAdapter.getPosition(i)[0]);
            System.out.println(mTrianglesAdapter.getPosition(i)[1]);
            System.out.println("----------------");
        }
    }
}
